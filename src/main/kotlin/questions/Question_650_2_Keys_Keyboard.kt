package questions

import kotlin.math.min
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

        fun minStepsGeneralSolution(n: Int): Int {
            val result = IntArray(n + 1) { 0 }
            for (i in 2..result.size - 1) {
                var min = Int.MAX_VALUE
                for (j in 2..i) {
                    if (i % j != 0) {
                        continue
                    }
                    min = min(min, result[i / j] + 1 + j - 1)
                    break
                }
                result[i] = min
            }
            return result[result.size - 1]
        }

        fun minStepsWithRecursive(n: Int): Int {
            val result = IntArray(n + 1) { -1 }
            result[0] = 0
            result[1] = 0
            val ans = dp(n, result)
            return ans
        }

        fun dp(n: Int, result: IntArray): Int {
            if (n == 1) {
                return 0
            }
            if (result[n] != -1) {
                return result[n]
            }
            var min = Int.MAX_VALUE
            for (count in 2..n) {
                if (n % count != 0) {
                    continue
                }
                min = min(min, dp(n / count, result) + count)
            }
            result[n] = min
            return result[n]
        }
    }
}