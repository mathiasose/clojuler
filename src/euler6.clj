(defn sum [Ns] (reduce + Ns))

(defn square [n] (* n n))

(defn -main
  "
  Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
  "
  [n]
  (let [Ns (range 1 101)]
    (println (- (square (sum Ns)) (sum (map square Ns))))))

(-main 100)