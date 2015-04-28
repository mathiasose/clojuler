(defn prime-factors
  [n]
  (case n
    1 []
    2 [2]
    (let [divisible? (fn [x] (== (mod n x) 0))
          upper-candidate (int (Math/sqrt n))
          candidates (cons 2 (range 3 upper-candidate 2))
          divisors (filter divisible? candidates)
          prime-divisor (first divisors)]
      (if (nil? prime-divisor) [n]
        (cons prime-divisor (prime-factors (/ n prime-divisor)))))))


(defn -main
  "
  What is the largest prime factor of the number 600851475143?
  "
  [n]
  (println (prime-factors n)))

(-main 600851475143)