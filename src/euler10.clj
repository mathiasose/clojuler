(defn sum [Ns] (reduce + Ns))

(defn divisible? [x y] (== 0 (mod x y)))

(defn sieve [primes Ns]
  (if (empty? Ns)
    primes
    (let [prime (last primes)
          filtered (doall (remove (fn [x] (divisible? x prime)) Ns))
          new-prime (first filtered)]
      (recur (conj primes new-prime) (drop 1 filtered)))))

(defn -main
  "Find the sum of all the primes below two million."
  [n]
  (println (sum (sieve [2 3] (range 3 n 2)))))

(-main 2000000)