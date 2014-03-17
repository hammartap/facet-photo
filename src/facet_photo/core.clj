(ns facet-photo.core
  (:require [quil.core :as ql])
  (:require [facet.core :as ft])

  (:import javax.imageio.ImageIO)
  (:import java.io.ByteArrayInputStream)

  (:import [processing.core PConstants])
  (:gen-class))


;; An atom which holds data of a taken photo.
(def ^:private PhotoData (atom nil))


;; You can take a picture at any time after calling -main function.
(defn shutter!
  "Take a picture."
  []
  (reset! PhotoData (ft/takeAndFetchPicture)))


;; ## Setup function for Quil
(defn- setup []
  (ql/smooth)
  (ql/frame-rate 30)
  
  ;; Set the background colour to a nice shade of grey.
  (ql/background 200)
  
  ;; Initialize the camera.
  ;; And start retrieving liveview images.
  (ft/init)
  ;; Wai a bit.
  (Thread/sleep 1000)
  (shutter!))


;; ## Draw function for Quil
(defn- draw []
  (let [url (:result @PhotoData)
        pimg   (when-not (= url nil)
                 (ql/load-image url))
        ;;width  (.width pimg)
        ;;height (.height pimg)
        ;;pixels (.pixels pimg)
        ]
    ;; Display pimg
    (ql/image pimg 0 0)))


;; ## Sketch defenition for Quil
(defn -main
  "This is liveview example."
  [& args]
  (ql/defsketch photo                    ;; Define a new sketch named liveview
    :title "Sony Camera Photo Taking Sample." ;; Set the title of the sketch
    :setup setup                         ;; Specify the setup fn
    :draw draw                           ;; Specify the draw fn
    :size [1440 1080])                     ;; You struggle to beat the golden ratio
  )


(defn close
  []
  (ql/sketch-close photo))
