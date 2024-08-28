package questions

import kotlin.math.sqrt

class Question_2523_Closest_Prime_Numbers_in_Range {

    companion object {

        fun runQuestion() {
//            Input: left = 10, right = 19
//            Output: [11,13]
            val left = 10
            val right = 19
            val result = closestPrimes(left, right)
            println("Question 2523: ${result.contentToString()}")
        }

        fun closestPrimes(left: Int, right: Int): IntArray {
            val result: MutableList<Int> = mutableListOf()
            for (count in left..right) {
                if (isPrime(count)) {
                    result.add(count)
                }
            }
            if (result.size <= 1) {
                return intArrayOf(-1, -1)
            }
            var min = Int.MAX_VALUE
            var ans = intArrayOf(-1, -1)
            for (count in 1..result.size - 1) {
                if (result[count] - result[count - 1] < min) {
                    ans[0] = result[count - 1]
                    ans[1] = result[count]
                    min = result[count] - result[count - 1]
                }
            }
            return ans
        }

        fun isPrime(n: Int): Boolean {
            if (n == 1) {
                return false
            }
            if (n == 2 || n == 3) {
                return true
            }
            val sqrt = sqrt(n.toDouble()).toInt()
            for (count in 2..sqrt) {
                if (n % count == 0) {
                    return false
                }
            }
            return true
        }
    }
}