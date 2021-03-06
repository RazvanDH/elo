(ns elo.css
  (:require [garden.def :refer [defstyles defcssfn]]))

(def internal-grid-gap "10px")
(def grid-gap "15px")

(def leagues-page
  [[:.league__content {:width "80%"
                       :padding-top "10px"
                       :padding-left "10px"}]
   [:.language_pick {:font-size "24px"
                     :text-align "center"}]])

(def league-detail-page
  [[:.content
    {:display "grid"
     :width "90%"
     :padding-left "20px"
     :padding-top "30px"
     :grid-gap grid-gap}]

   [:.players__form_container
    {:width "60%"}]

   [:.rankings__table
    {:width "75%"}]

   [:.result__element
    {:color "white"
     :margin "2px"
     :font-weight :bolder}]

   [:.rankings-slider
    {:padding "20px"}]

   [:.result__w
    {:background-color "green"}]

   [:.result__d
    {:background-color "black"}]

   [:.result__l
    {:background-color "red"}]

   [:.fork-me
    {:position "absolute"
     :top 0
     :right 0
     :border 0}]

   [:th {:text-transform "uppercase"}]
   [:.fas {:font-size "20px"
           :cursor "pointer"}]

   [:.up-to-current-games {:font-size "20px"
                           :padding-left "5px"
                           :padding-right "5px"
                           :background-color "#DDDDDD"}]

   [:.add-player_form
    {:display "grid"
     :width "70%"
     :padding-left "15px"
     :grid-gap internal-grid-gap}]

   [:.game_form
    {:display "grid"
     :width "80%"
     :padding-left "15px"
     :grid-gap internal-grid-gap
     :grid-template-rows "auto auto auto auto"
     :grid-template-columns "auto auto"}]

   [:label {:padding-right "30px"}]

   [:.section {:padding "10px"
               :box-shadow "-1px 1px 2px 2px rgba(0,0,0,0.2)"}]])

(defstyles screen
  ;; could maybe even split creating multiple CSS files?
  (concat leagues-page league-detail-page))
