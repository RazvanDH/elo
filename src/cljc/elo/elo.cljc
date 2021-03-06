(ns elo.elo
  "Main namespace containing all the core logic.
  See the mathematical details of the Elo formula used here:
  https://en.wikipedia.org/wiki/Elo_rating_system")

(def k 32)
(def initial-ranking 1500)

(defn valid-rankings?
  [rankings]
  (== 0 (mod (apply + rankings) initial-ranking)))

(defn expected
  [diff]
  (/ 1.0 (inc (Math/pow 10 (/ diff 400)))))

(defn new-rating
  [old expected game]
  (+ old (* k (- game expected))))

(defn new-ratings
  [ratings [p1 p2 p1-score p2-score]]

  (let [ra (get ratings p1)
        rb (get ratings p2)]

    (assoc ratings
           p1 (new-rating ra
                          (expected (- rb ra))
                          p1-score)

           p2 (new-rating rb
                          (expected (- ra rb))
                          p2-score))))

(defn update-ratings
  [ratings games]
  (if (empty? games)
    ratings
    (recur (new-ratings ratings (first games))
           (rest games))))

(defn initial-rankings
  [players]
  (zipmap players (repeat initial-ranking)))

(defn- extract-players
  [games]
  (vec (set (apply concat
                   (for [[f s] games]
                     [f s])))))

(defn compute-rankings
  ([games players]
   {:post [(valid-rankings? (vals %))]}
   (update-ratings (initial-rankings players)
                   games))
  ([games]
   (compute-rankings games (extract-players games))))
