(defn pythagorean [a b] (+ (* a a) (* b b)))

(defn triplets-that-sum-to-n [As Bs Cs n acc]
  (let [a (first As)
        b (first Bs)
        c (first Cs)]
    (if (empty? As)
      acc
      (if (empty? Bs)
        (recur (drop 1 As) (drop 1 As) (drop 1 As) n acc)
        (if (empty? Cs)
          (recur As (drop 1 Bs) (drop 1 Bs) n acc)
          (if (== n (+ a b c))
            (recur As Bs (drop 1 Cs) n (conj acc [a b c]))
            (recur As Bs (drop 1 Cs) n acc)))))))

(defn -main
  "
A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
a^2 + b^2 = c^2

For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.

There exists exactly one Pythagorean triplet for which a + b + c = 1000.
Find the product abc.
"
  [n]
  (let [f (fn [[a b c]] (== (* c c) (pythagorean a b)))
        triplets (triplets-that-sum-to-n (range 1 n) (range 1 n) (range 1 n) n [])]
    (println (reduce * (first (filter f triplets))))))

(-main 1000)