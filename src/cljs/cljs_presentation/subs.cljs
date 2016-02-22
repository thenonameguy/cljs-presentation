(ns cljs-presentation.subs
  (:require-macros [reagent.ratom :refer [reaction]])
  (:require [re-frame.core :as re-frame]))

(re-frame/register-sub
 :slide-index
 (fn [db]
   (reaction (:slide @db))))

(re-frame/register-sub
 :state-visible
 (fn [db]
   (reaction (:state-visible @db))))
