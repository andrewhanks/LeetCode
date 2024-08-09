package questions

import kotlin.math.pow

class Question_1680_Concatenation_of_Consecutive_Binary_Numbers {

    companion object {

        fun runQuestion() {
//            Input: n = 12
//            Output: 505379714
            val n = 12
            val result = concatenatedBinary(n)
            println("Question 1680: $result")
        }

        fun concatenatedBinary(n: Int): Int {
            val mod = 1000000007
            var ans = 1
            for (count in 2..n) {
                val binStrN = Integer.toBinaryString(count)
                val length = binStrN.length
                ans = ((ans * (2.0).pow(length) + count) % mod).toInt()
            }
            return ans
        }
    }
}