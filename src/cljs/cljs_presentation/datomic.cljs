(ns cljs-presentation.datomic
  (:require [clojure.string :as string]))

(defmulti render-slide identity)

(defmethod render-slide 0 []
  [:div.slide-0
   [:h1.text-center "Embracing Immutability in the Database:"
    [:br] "Intro to Datomic"]
   [:h3 "Presenter: Krisztián Szabó"]])

(defmethod render-slide 1 []
  [:div.slide-1
   [:h1 "What is Datomic?"]
   [:ul
    [:li "A functional database"]
    [:li "A sound model of information, with time"]
    [:li "Provides " [:b "database as a value"] " to applications"]
    [:li "Bring declarative programming to applications"]
    [:li "Focus on reducing complexity"]]])

(defmethod render-slide 2 []
  [:div.slide-2
   [:h1 "DB Complexity"]
   [:ul
    [:li "Inherently stateful"]
    [:li "Same query, different results (no basis)"]
    [:li "Over there"]]])

(defmethod render-slide 3 []
  [:div.slide-3
   [:h1 "Manifestations"]
   [:ul
    [:li "Wrong programs"]
    [:li "Round-trip fears"]
    [:li "Fear of overloading server"]]])

(defmethod render-slide 4 []
  [:div.slide-4
   [:img {:src "/images/traditional_db.png" :height "1000"}]])

(defmethod render-slide 5 []
  [:div.slide-5
   [:img {:src "/images/datomic_architecture.png" :height "1000"}]])

(defmethod render-slide 6 []
  [:div.slide-6.datomic-data-model
   [:h1 "Data model"]
   [:ul
    [:li "Stored as facts, encoded as 'datoms':"
     [:br]
     (->>
      ["Entity" "Attribute" "Value" "Transaction" "Operation"]
      (map (fn [[first-ch & rst]] [:span [:b first-ch] (string/join rst)]))
      (interpose " / "))]]])
