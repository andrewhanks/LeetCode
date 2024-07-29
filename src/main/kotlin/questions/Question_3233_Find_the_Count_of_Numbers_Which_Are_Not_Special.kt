package questions

import kotlin.math.sqrt

class Question_3233_Find_the_Count_of_Numbers_Which_Are_Not_Special {

    companion object {

        fun runQuestion() {
//            Input: l = 4, r = 16
//            Output: 11
            val l = 4
            val r = 16
            val result = nonSpecialCount(l, r)
            println("Question 3233: $result")
        }

        fun nonSpecialCount(l: Int, r: Int): Int {
            var totalNumber = r - l + 1
            var n = 1
            while (n * n <= r) {
                // println("$n is prime? ${isPrime(n)}")
                if (n * n >= l && n * n <= r && isPrime(n)) {
                    totalNumber--
                }
                n++
            }
            // println("totalNumber = $totalNumber")
            return totalNumber
        }

        fun isPrime(n: Int): Boolean {
            if (n == 1) {
                return false
            }
            if (n == 2) {
                return true
            }
            if (n == 3) {
                return true
            }
            val till = sqrt(n.toDouble()).toInt()
            for (count in 2..till) {
                if (n % count == 0) {
                    return false
                }
            }
            return true
        }
    }
}