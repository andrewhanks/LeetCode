package questions

import kotlin.math.max

class Question_1312_Minimum_Insertion_Steps_to_Make_a_String_Palindrome {

    companion object {

        fun runQuestion() {
//            Input: s = "leetcode"
//            Output: 5
            val s = "leetcode"
            val result = minInsertions(s)
            println("Question 1312: $result")
        }

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
    }
}