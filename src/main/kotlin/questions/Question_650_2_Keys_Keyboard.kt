package questions

import kotlin.math.sqrt

class Question_650_2_Keys_Keyboard {

    companion object {

        fun runQuestion() {
//            Input: n = 3
//            Output: 3
            val n = 3
            val result = minSteps(n)
            println("Question 650: $result")
        }

        fun minSteps(n: Int): Int {
            val result = IntArray(n + 1) { 0 }
            for (count in 2..result.size - 1) {
                val maxQuotient = getMaxQuotient(count)
                if (maxQuotient == -1) {
                    result[count] = count
                    continue
                }
                // println("count = $count, result[$maxQuotient] = ${result[maxQuotient]}")
                result[count] = result[maxQuotient] + (count - maxQuotient) / maxQuotient + 1
            }
            return result[result.size - 1]
        }

        fun getMaxQuotient(n: Int): Int {
            val till = sqrt(n.toDouble()).toInt()
            for (count in 2..till) {
                if (n % count == 0) {
                    return n / count
                }
            }
            return -1
        }
    }
}