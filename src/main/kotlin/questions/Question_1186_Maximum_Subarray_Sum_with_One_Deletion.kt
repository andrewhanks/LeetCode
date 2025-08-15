package questions

import kotlin.math.max


class Question_1186_Maximum_Subarray_Sum_with_One_Deletion {

    companion object {

        fun runQuestion() {
//            Input: arr = [1,-2,0,3]
//            Output: 4
            val arr = intArrayOf(1, -2, 0, 3)
            val result = maximumSum(arr)
            println("Question 1186: $result")
        }

        fun maximumSum(arr: IntArray): Int {
            // dp[i][0]: maximum sum for a non-empty subarray with one deletion
            // dp[i][1]: maximum sum for a non-empty subarray without any deletion
            val dp = Array(arr.size) { IntArray(2) { 0 } }
            var ans = arr[0]
            dp[0][0] = 0
            dp[0][1] = arr[0]
            for (i in 1..arr.size - 1) {
                dp[i][0] = max(dp[i - 1][1], dp[i - 1][0] + arr[i])
                dp[i][1] = max(dp[i - 1][1] + arr[i], arr[i])
                ans = max(ans, max(dp[i][0], dp[i][1]))
            }
            return ans
        }
    }
}