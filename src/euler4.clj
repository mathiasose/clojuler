(defn palindrome? [s]
  (if (< (.length s) 2)
    true
    (let [last-index (- (.length s) 1)]
      (and (.equals (.charAt s 0) (.charAt s last-index)) (palindrome? (.substring s 1 last-index))))))

(defn product-palindromes [As Bs results]
  (if (empty? As)
    results
    (let [a (first As)
          b (first Bs)
          An (drop 1 As)
          Bn (drop 1 Bs)]
      (if (nil? b)
        (recur An An results)
        (let [p (* a b)
              s (Integer/toString p)]
          (if (palindrome? s)
            (recur As Bn (conj results p))
            (recur As Bn results)))))))

(defn -main
  "
  Find the largest palindrome made from the product of two 3-digit numbers.
  "
  []
  (println (apply max (product-palindromes (range 999 99 -1) (range 999 99 -1) []))))

(-main)