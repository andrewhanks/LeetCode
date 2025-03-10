package questions

import kotlin.math.max

class Question_2786_Visit_Array_Positions_to_Maximize_Score {

    companion object {

        fun runQuestion() {
//            Input: nums = [2,3,6,1,9,2], x = 5
//            Output: 13
            val nums = intArrayOf(2, 3, 6, 1, 9, 2)
            val x = 5
            val result = maxScore(nums, x)
            println("Question 2786: $result")
        }

        fun maxScore(nums: IntArray, x: Int): Long {
            val dp = Array(nums.size) { LongArray(2) { 0L } }
            if (nums[0] % 2 == 0) {
                dp[0][0] = nums[0].toLong()
                dp[0][1] = nums[0].toLong() - x
            } else {
                dp[0][0] = nums[0].toLong() - x
                dp[0][1] = nums[0].toLong()
            }
            for (i in 1..dp.size - 1) {
                // not pick
                dp[i][0] = dp[i - 1][0]
                dp[i][1] = dp[i - 1][1]
                // pick
                if (nums[i] % 2 == 0) {
                    dp[i][0] = max(dp[i - 1][0] + nums[i], dp[i - 1][1] + nums[i] - x)
                } else {
                    dp[i][1] = max(dp[i - 1][1] + nums[i], dp[i - 1][0] + nums[i] - x)
                }
            }
            // println("dp = ${dp.contentDeepToString()}")
            return max(dp[dp.size - 1][0], dp[dp.size - 1][1])
        }
    }
}