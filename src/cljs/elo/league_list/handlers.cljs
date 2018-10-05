(ns elo.league-list.handlers
  (:require [ajax.core :as ajax]
            [elo.common.handlers :as common]
            [re-frame.core :as rf]))

;;TODO: use the path interceptor instead of this

(def page ::page-id)

(def setter (partial common/setter* page))
(def getter (partial common/getter* page))

(def default-db
  {:leagues []})

(rf/reg-event-db ::initialize-db
                 (fn [db _]
                   (assoc db page default-db)))

(rf/reg-event-db :load-leagues-success (setter [:leagues]))

(rf/reg-event-fx :load-leagues
                 (common/loader-no-league page "/api/leagues" :load-leagues-success))

(rf/reg-sub :leagues (getter [:leagues]))
