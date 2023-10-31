package questions

import java.math.BigInteger


class Question_191_Number_of_1_Bits {

    companion object {

        fun runQuestion() {
//            Input: n = 00000000000000000000000000001011
//            Output: 3
            val n = 11
            val result = hammingWeight(n)
            println("Question 191: $result")
        }

        fun hammingWeight(n: Int): Int {
            var result = 0
            var tempN = n.toUInt().toLong()
            while (tempN > 0) {
                if (tempN % 2 == 1L) {
                    result++
                }
                tempN = tempN / 2
            }
            return result
        }
    }
}