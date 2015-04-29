(defn -main
  "
  What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
  "
  [n]
  (let [Ns (range (+ (/ n 2) 1) (+ n 1))
        divisible-by-all (fn [dividend] (every? (fn [divisor] (== 0 (mod dividend divisor))) Ns))]
    (println (first (filter divisible-by-all (range 20 (reduce * Ns) 20))))))

(-main 20)