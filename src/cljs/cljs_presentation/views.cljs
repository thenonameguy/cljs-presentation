(ns cljs-presentation.views
  (:require
   [cljs-presentation.datomic :as datomic]
   [re-frame.core :as re-frame]
   [cljs.pprint :refer [pprint]]
   [json-html.core :refer [edn->hiccup]]))

(defn presentation-component []
  (let [slide (re-frame/subscribe [:slide-index])
        state-visible (re-frame/subscribe [:state-visible])]
    (fn []
      [:div.presentation
       [:div.slide-holder [datomic/render-slide @slide]]
       (when @state-visible
         [:footer "App-state: "
          [:div.app-state (edn->hiccup @re-frame.db/app-db)]])])))
