package questions

import kotlin.math.max
import kotlin.math.min

class Question_1312_Minimum_Insertion_Steps_to_Make_a_String_Palindrome {

    companion object {

        fun runQuestion() {
//            Input: s = "leetcode"
//            Output: 5
            val s = "leetcode"
            val result = minInsertions(s)
            println("Question 1312: $result")
        }

        // s.length - LCS
        fun minInsertions(s: String): Int {
            val len = s.length
            val revS = s.reversed()
            val dp = Array(len + 1) { IntArray(len + 1) { 0 } }
            for (i in 1..dp.size - 1) {
                for (j in 1..dp[i].size - 1) {
                    if (s[i - 1] == revS[j - 1]) {
                        dp[i][j] = dp[i - 1][j - 1] + 1
                    } else {
                        dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])
                    }
                }
            }
            // println("dp = ${dp.contentDeepToString()}")
            return s.length - dp[len][len]
        }

        fun minInsertionsByDpStringItself(s: String): Int {
            val m = s.length
            val dp = Array(m) { IntArray(m) { 0 } }
            for (i in 0..m - 1) {
                dp[i][i] = 0
            }
            for (i in 0..m - 2) {
                dp[i][i + 1] = if (s[i] == s[i + 1]) {
                    0
                } else {
                    1
                }
            }
            for (len in 3..m) {
                for (i in 0..m - len) {
                    val j = i + len - 1
                    // println("i = $i, j = $j, len = $len")
                    if (s[i] == s[j]) {
                        // iXXXXXXXXj
                        dp[i][j] = dp[i + 1][j - 1]
                    } else {
                        // min ( iXXXXXXXXji , jiXXXXXXXXj )
                        //                 +   +
                        dp[i][j] = min(dp[i + 1][j] + 1, dp[i][j - 1] + 1)
                    }
                }
            }
            // println("dp = ${dp.contentDeepToString()}")
            return dp[0][m - 1]
        }
    }
}