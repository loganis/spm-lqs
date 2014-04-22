(ns spm-lqs.core
  (:use [incanter core stats io charts datasets svg pdf])
  (:use [clj-lqs.core])
  )


; Put your token string here (more info on http://docs.loganis.com)
(def token "PUT_YOUR_TOKEN_STRING_HERE")

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Session Metrics group by ga:deviceCategory ;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(def query {:met "ch3:ga:sessions,ch3:ga:users,ch3:ga:pageviews,ch3:ga:bounceRate,ch3:ga:pageviewsPerSession,ch3:ga:avgSessionDuration"
            :dim "date,ga:deviceCategory"
            :per "last_4_weeks" 
            :col "ch3:ga:sessions,ch3:ga:users,ch3:ga:pageviews,ch3:ga:bounceRate,ch3:ga:pageviewsPerSession,ch3:ga:avgSessionDuration,ga:deviceCategory"})

; Execute Query
(def mydata (lqs->map token query))

; Convert map to dataset
(def myds (dataset (-> mydata :colnames) (-> mydata :rows)))

(if-not (= ["error"] (col-names myds))
  (do
    ;; Create a Scatter Plot Matrix
    (def spm (scatter-plot-matrix myds :group-by "ga:deviceCategory" :only-first 6 ))

    ;; View Scatter Plot Matrix on display
    (view spm :width 1600 :height 800)
    
    ;; Save Scatter Plot Matrix as PDF
    (save-pdf spm "out/spm.pdf" :width 1600 :height 800)


    ;; Save Scatter Plot Matrix as SVG
    (save-svg spm "out/spm.svg" :width 1600 :height 800)

    ;; Save Scatter Plot Matrix as PNG
    (save spm "out/spm.png" :width 1600 :height 800))
  
  ;; Print Error message
  (prn (-> myds :rows first (get "error"))))



;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Adwords Metrics group by ga:campaign ;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(def query2 {:met "ch3:ga:impressions,ch3:ga:adClicks,ch3:ga:adCost,ch3:ga:CPC,ch3:ga:CTR"
             :dim "date,ga:campaign"
             :per "last_4_weeks"
             :col "ch3:ga:impressions,ch3:ga:adClicks,ch3:ga:adCost,ch3:ga:CPC,ch3:ga:CTR,ga:campaign"})

; Execute Query
(def mydata2 (lqs->map token query2))

; Convert map to dataset
(def myds2 (dataset (-> mydata2 :colnames) (-> mydata2 :rows)))

(if-not (= ["error"] (col-names myds2))
  (do
    ;; create a Scatter Plot Matrix
    (def spm2 (scatter-plot-matrix myds2 :group-by "ga:campaign" :only-first 6 ))

    ;; View Scatter Plot Matrix on display
    (view spm2 :width 1600 :height 800)

    ;; Save Scatter Plot Matrix as PDF
    (save-pdf spm2 "out/spm2.pdf" :width 1600 :height 800)

    ;; Save Scatter Plot Matrix as SVG
    (save-svg spm2 "out/spm2.svg" :width 1600 :height 800)

    ;; Save Scatter Plot Matrix as PNG
    (save spm2 "out/spm2.png" :width 1600 :height 800))

  ;; Print Error message
  (prn (-> myds2 :rows first (get "error"))))

