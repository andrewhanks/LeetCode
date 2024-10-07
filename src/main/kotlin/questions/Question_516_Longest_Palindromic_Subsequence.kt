package questions

import kotlin.math.max

class Question_516_Longest_Palindromic_Subsequence {

    companion object {

        fun runQuestion() {
//            Input: s = "bbbab"
//            Output: 4
            val s = "bbbab"
            val result = longestPalindromeSubseq(s)
            println("Question 516: $result")
        }

        fun longestPalindromeSubseq(s: String): Int {
            val result = Array(s.length + 1) { IntArray(s.length + 1) { 0 } }
            val reverse = s.reversed()
            for (i in 1..s.length) {
                for (j in 1..reverse.length) {
                    if (s[i - 1] == reverse[j - 1]) {
                        result[i][j] = result[i - 1][j - 1] + 1
                    } else {
                        result[i][j] = max(result[i - 1][j], result[i][j - 1])
                    }
                }
            }
            return result[s.length][s.length]
        }

        fun longestPalindromeSubseqAnotherSolution(s: String): Int {
            val temps = "#" + s
            val dp = Array(temps.length) { IntArray(temps.length) { 0 } }
            for (count in 1..dp.size - 1) {
                dp[count][count] = 1
            }
            for (len in 2..temps.length - 1) {
                for (i in 1..temps.length - 1 - len + 1) {
                    val j = i + len - 1
                    // temps: X X i X X j
                    if (temps[i] == temps[j]) {
                        dp[i][j] = dp[i + 1][j - 1] + 2
                    } else {
                        dp[i][j] = max(dp[i + 1][j], dp[i][j - 1])
                    }
                }
            }
            // println("dp = ${dp.contentDeepToString()}")
            return dp[1][dp[0].size - 1]
        }
    }
}