package questions

import kotlin.math.min

class Question_172_Factorial_Trailing_Zeroes {

    companion object {

        fun runQuestion() {
            val input = 5
            val result = trailingZeroes(input)
            println("Question 172: $result")
        }

        fun trailingZeroes(n: Int): Int {
            var timesOf2 = 0
            var timesOf5 = 0
            for (count in 1..n) {
                var temp = count
                while (temp % 2 == 0) {
                    timesOf2++
                    temp /= 2
                }
                temp = count
                while (temp % 5 == 0) {
                    timesOf5++
                    temp /= 5
                }
            }
            return min(timesOf2, timesOf5)
        }
    }
}