(ns cljs-presentation.app
  (:require [reagent.core :as reagent :refer [atom]]
            [re-frame.core :as re-frame]
            [cljs-presentation.handlers]
            [cljs-presentation.subs]
            [cljs-presentation.util :refer [container]]
            [cljs-presentation.views :as views]))

(defn on-js-reload []
  (reagent/render-component [views/presentation-component] (container)))

(defn init []
  (.log js/console "Initializing...")
  (.addEventListener js/document "keydown" #(re-frame/dispatch-sync [:keyboard-event %]))
  (re-frame/dispatch-sync [:init-db])
  (on-js-reload))
