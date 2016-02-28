(ns cljs-presentation.handlers
  (:require [re-frame.core :as re-frame]
            [cljs-presentation.db :as db]
            [cljs-presentation.util :refer [toggle-fullscreen]])
  (:import [goog.events KeyCodes]))

(re-frame/register-handler
 :init-db
 (fn [db _]
   (merge db/default-value db)))

(re-frame/register-handler
 :slide-count
 (fn [db [_ slide-count]]
   (assoc db :slide-count slide-count)))

(re-frame/register-handler
 :next-slide
 (fn [db _]
   (if (< (:slide db) (dec (:slide-count db)))
    (update db :slide inc)
    db)))

(re-frame/register-handler
 :previous-slide
 (fn [db _]
   (if (> (:slide db) 0)
     (update db :slide dec)
     db)))

(re-frame/register-handler
 :toggle-state-visibility
 (fn [db _]
   (update db :state-visible not)))

(re-frame/register-handler
 :toggle-fullscreen
 (fn [db _]
   (update db :full-screen not)))

(re-frame/register-handler
 :keyboard-event
 (fn [db [_ e]]
   (some-> (condp = (.-keyCode e)
             KeyCodes.LEFT [:previous-slide]
             KeyCodes.RIGHT [:next-slide]
             KeyCodes.H [:toggle-state-visibility]
             KeyCodes.F (do (toggle-fullscreen) [:toggle-fullscreen])
             nil)
           re-frame/dispatch)
   db))
