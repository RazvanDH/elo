(ns elo.pages.leagues
  (:require [elo.db :as db]
            [elo.pages.header :refer [gen-header]]))

(def body
  [:html
   (gen-header "Leagues List")
   [:body
    [:h2 "Pick one of the leagues"]
    (into [:ul.list-group]
          (for [{:keys [id name]} (db/load-leagues)]
            [:li.list-group-item
             [:a {:href (format "/league/%s" id)} name]]))]])
