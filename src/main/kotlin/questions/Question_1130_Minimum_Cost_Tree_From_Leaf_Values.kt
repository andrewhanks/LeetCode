package questions

import kotlin.math.min


class Question_1130_Minimum_Cost_Tree_From_Leaf_Values {

    companion object {

        fun runQuestion() {
//            Input: arr = [6,2,4]
//            Output: 32
            val arr = intArrayOf(6, 2, 4)
            val result = mctFromLeafValues(arr)
            println("Question 1130: $result")
        }

        fun mctFromLeafValues(arr: IntArray): Int {
            val dp = Array(arr.size) { IntArray(arr.size) { 0 } }
            for (len in 2..dp.size) {
                for (i in 0..dp.size - 1 - len + 1) {
                    val j = i + len - 1
                    if (len == 2) {
                        dp[i][j] = arr[i] * arr[j]
                        continue
                    }
                    var current = Int.MAX_VALUE
                    for (k in i..j - 1) {
                        val left = arr.slice(i..k).max()
                        val right = arr.slice(k + 1..j).max()
                        current = min(current, dp[i][k] + dp[k + 1][j] + left * right)
                    }
                    dp[i][j] = current
                }
            }
            // println("dp = ${dp.contentDeepToString()}")
            return dp[0][dp[0].size - 1]
        }
    }
}