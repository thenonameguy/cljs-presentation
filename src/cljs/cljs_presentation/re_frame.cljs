(ns cljs-presentation.re-frame)

(defmulti render-slide identity)

(defmethod render-slide 0 []
  [:div.slide-0
   [:h1.text-center "Re-framing frontend development with Clojurescript:" [:br] " A case study"]
   [:h3 "Presenter: Krisztián Szabó"]])

(defmethod render-slide 1 []
  [:div.slide-1
   [:h1 "About me"]
   [:ul
    [:li "Full-stack engineer at Whitepages Hungary, Budapest"]
    [:li "Mainly developing on a Ruby on Rails/Coffeescript/Sass based stack during the day"]
    [:li "Started experimenting with Clojure/Clojurescript ~1 year ago"]
    [:li "Eager about alternative software architecture/system design"]]])

(defn cljs-logo []
  [:img {:src "https://raw.githubusercontent.com/cljsinfo/logo.cljs/master/cljs-white.png" :height "100px"}])

(defmethod render-slide 2 []
  [:div.slide-2
   [:h1 "Clojurescript"]
   [cljs-logo]
   [:h3 "Why bother?"]
   [:ul
    [:li [:strong "LISP"] " in the browser! " [:small "(code as data/data as code, minimal syntax)"]]
    [:li "A standard library for the web provided by the " [:strong "Google Closure Library"] [:br]
     [:small "(used in production for products such as Gmail)"]]
    [:li "One of the easiest interfaces to the " [:strong "Google Closure Compiler"] [:br] " in the Javascript ecosystem"]]])

(defmethod render-slide 3 []
  [:div.slide-3.left-aligned
   [:header [cljs-logo]]
   [:h4 "Interop"]
   [:p "Functions calls:"]
   [:code (str '(.log js/console "Hello World!"))]
   [:p "Object property access:"]
   [:code (str '(.-Infinity js/window))]
   [:h4 "Immutable, persistent data-structures (aka immutable.js)"]
   [:code
    (str '(def example-hash-map {:foo 42})) [:br] [:br]
    (str '(assoc example-hash-map 42 :bar)) [:br]
    "=> " (str {:foo 42 42 :bar}) [:br] [:br]
    "example-hash-map" [:br]
    "=> " (str {:foo 42})]
   [:h4 "Seq abstraction: Goodbye lodash/underscore!"]
   [:code (str '(->> (range 10)
                     (map inc)
                     (filter odd?)
                     (reduce +)))
    [:br]
    "=> 25"]])

(defmethod render-slide 4 []
  [:div.slide-4.left-aligned
   [:header [cljs-logo]]
   [:h1 "Google Closure *"]
   [:h4 "The reason we can get away with using these abstractions"]])

(defn rich-hickey-quote []
  [:div.rich-hickey-quote
   [:blockquote "We can create precisely the same programs we're creating right now with drastically simpler tools."]
   [:span.one-true-god "- Rich Hickey"]])

(defmethod render-slide 5 []
  [:div.slide-5.left-aligned
   [:h2 "So there's this React.js thing..."]
   [:h4 "Apparently it goes pretty well together with immutability"]
   [:br]
   [rich-hickey-quote]])

(defmethod render-slide 6 []
  [:div.slide-6
   [:h1 "Reagent"]
   [:ul
    [:li "An idiomatic React.js wrapper for Clojurescript using " [:strong "Hiccup"]]
    [:li "Provides an alternate implementation of the " [:strong "atom"] " concurrency construct"]
    [:li "Maintains component local state with " [:strong "closures"]]
    [:li "But just like React, it only solves the " [:strong \V] " part of 'MVC'..."]]])

(defmethod render-slide 7 []
  [:div.slide-7 "DEMO"])
