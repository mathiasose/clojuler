(defn not-divisible-by-any? [n possible-divisors]
  (not-any? (fn [x] (== 0 (mod n x))) possible-divisors))

(defn primes [primes candidate end]
  (if (>= (count primes) end)
    primes
    (if (not-divisible-by-any? candidate primes)
      (recur (conj primes candidate) (+ candidate 2) end)
      (recur primes (+ candidate 2) end))))

(defn -main
  "
  What is the 10 001st prime number?
  "
  [n]
  (println (last (primes [2] 3 n))))

(-main 10001)