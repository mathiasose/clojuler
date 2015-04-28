(defn fib-sequence
  [coll limit]
  (let [next (+ (last coll) (last (butlast coll)))]
    (if (> next limit) coll (recur (conj coll next) limit))))

(defn -main
  "
  By considering the terms in the Fibonacci sequence whose values do not exceed four million,
  find the sum of the even-valued terms.
  "
  [n]
  (println (reduce + (filter (fn [x] (== 0 (mod x 2))) (fib-sequence [0 1] n)))))

(-main 4000000)