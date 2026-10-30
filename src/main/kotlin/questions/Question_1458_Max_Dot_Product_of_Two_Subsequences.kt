package questions

import kotlin.math.max


class Question_1458_Max_Dot_Product_of_Two_Subsequences {

    companion object {

        fun runQuestion() {
//            Input: nums1 = [2,1,-2,5], nums2 = [3,0,-6]
//            Output: 18
            val nums1 = intArrayOf(2, 1, -2, 5)
            val nums2 = intArrayOf(3, 0, -6)
            val result = maxDotProduct(nums1, nums2)
            println("Question 1458: $result")
        }

        fun maxDotProduct(nums1: IntArray, nums2: IntArray): Int {
            val m = nums1.size
            val n = nums2.size
            val dp = Array(m + 1) { IntArray(n + 1) { 0 } }
            for (i in 1..m) {
                for (j in 1..n) {
                    val notPicked = max(dp[i][j - 1], dp[i - 1][j])
                    val picked = dp[i - 1][j - 1] + nums1[i - 1] * nums2[j - 1]
                    // println("notPicked = $notPicked, picked = $picked")
                    dp[i][j] = max(notPicked, picked)
                }
            }
            // println("dp = ${dp.contentDeepToString()}")
            var ret = dp[m][n]
            if (ret == 0) {
                if (nums1.filter { it > 0 }.isEmpty()) {
                    ret = nums1.max() * nums2.min()
                } else {
                    ret = nums1.min() * nums2.max()
                }
            }
            return ret
        }

        fun maxDotProductWithMaxPaired(nums1: IntArray, nums2: IntArray): Int {
            val m = nums1.size
            val n = nums2.size
            val dp = Array(m + 1) { IntArray(n + 1) { Int.MIN_VALUE } }
            for (i in 1..m) {
                for (j in 1..n) {
                    val notPaired = max(dp[i][j - 1], dp[i - 1][j])
                    val paired = max(0, dp[i - 1][j - 1]) + nums1[i - 1] * nums2[j - 1]
                    dp[i][j] = max(notPaired, paired)
                }
            }
            return dp[m][n]
        }
    }
}