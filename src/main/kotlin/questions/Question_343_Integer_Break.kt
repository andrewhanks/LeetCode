package questions

import kotlin.math.pow

class Question_343_Integer_Break {

    companion object {

        fun runQuestion() {
//            Input: n = 10
//            Output: 36
            val n = 10
            val result = integerBreak(n)
            println("Question 343: $result")
        }

        fun integerBreak(n: Int): Int {
            if (n == 2) {
                return 1
            }
            if (n == 3) {
                return 2
            }
            var max: Double = 1.0
            val time = n / 3
            max = (max * 3.toDouble().pow(time))
            if (n % 3 == 2) {
                max = max * 2
            } else if (n % 3 == 1) {
                max = max / 3
                max = max * 2 * 2
            }
            return max.toInt()
        }
    }
}