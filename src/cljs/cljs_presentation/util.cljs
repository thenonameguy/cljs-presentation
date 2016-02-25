(ns cljs-presentation.util
  (:require [goog.dom.fullscreen :refer [isFullScreen exitFullScreen requestFullScreenWithKeys] ]))

(defn container []
  (.getElementById js/document "container"))

(defn toggle-fullscreen []
  (if (isFullScreen)
    (exitFullScreen)
    (requestFullScreenWithKeys (.-documentElement js/document))))

(defmulti render-slide identity)

(defn slide-count []
	(count (methods render-slide)))