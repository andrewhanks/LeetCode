package questions

import kotlin.math.min

class Question_712_Minimum_ASCII_Delete_Sum_for_Two_Strings {

    companion object {

        fun runQuestion() {
//            Input: s1 = "sea", s2 = "eat"
//            Output: 231
            val s1 = "sea"
            val s2 = "eat"
            val result = minimumDeleteSum(s1, s2)
            println("Question 712: $result")
        }

        fun minimumDeleteSum(s1: String, s2: String): Int {
            val temp1 = "#"+s1
            val temp2 = "#"+s2
            val dp = Array(temp1.length){IntArray(temp2.length){0}}
            for(i in 1..dp.size-1) {
                dp[i][0] = dp[i-1][0]+temp1[i].toInt()
            }
            for(i in 1..dp[0].size-1) {
                dp[0][i] = dp[0][i-1]+temp2[i].toInt()
            }
            for(i in 1..dp.size-1) {
                for(j in 1..dp[0].size-1) {
                    if(temp1[i]==temp2[j]) {
                        dp[i][j]=dp[i-1][j-1]
                    }else {
                        dp[i][j] = min(dp[i-1][j]+temp1[i].toInt(), dp[i][j-1]+temp2[j].toInt())
                    }
                }
            }
            return dp[dp.size-1][dp[0].size-1]
        }
    }
}