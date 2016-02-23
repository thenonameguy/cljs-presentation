(ns cljs-presentation.views
  (:require [re-frame.core :as re-frame]
            [cljs.pprint :refer [pprint]]
            [json-html.core :refer [edn->hiccup]]))

(defmulti render-slide identity)

(defmethod render-slide 0 []
  [:div.slide-0
   [:h1 "Re-framing frontend development with Clojurescript: A case study"]
   [:h3 "Presenter: Krisztián Szabó"]])

(defmethod render-slide 1 []
  [:div.slide-1
   [:h2 "Second page, yay!"]])

(defn presentation-component []
  (let [slide (re-frame/subscribe [:slide-index])
        state-visible (re-frame/subscribe [:state-visible])]
    (fn []
      [:div.presentation
       [:div.slide-holder [render-slide @slide]]
       (when @state-visible
         [:footer "App-state: "
          [:div.app-state (edn->hiccup @re-frame.db/app-db)]])])))
