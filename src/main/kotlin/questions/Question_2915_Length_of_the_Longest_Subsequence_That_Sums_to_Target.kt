package questions

import kotlin.math.max


class Question_2915_Length_of_the_Longest_Subsequence_That_Sums_to_Target {

    companion object {

        fun runQuestion() {
//            Input: nums = [4,1,3,2,1,5], target = 7
//            Output: 4
            val nums = listOf(4, 1, 3, 2, 1, 5)
            val target = 7
            val result = lengthOfLongestSubsequence(nums, target)
            println("Question 2915: $result")
        }

        fun lengthOfLongestSubsequence(nums: List<Int>, target: Int): Int {
            val result = Array(nums.size + 1) { IntArray(target + 1) { -1 } }
            for (i in 0..result.size - 1) {
                result[i][0] = 0
            }
            for (i in 1..result.size - 1) {
                for (j in 1..result[0].size - 1) {
                    val notPick = result[i - 1][j]
                    val pick = if (j - nums[i - 1] >= 0 && result[i - 1][j - nums[i - 1]] != -1) {
                        result[i - 1][j - nums[i - 1]] + 1
                    } else {
                        -1
                    }
                    result[i][j] = max(notPick, pick)
                }
            }
            // println("result = ${result.contentDeepToString()}")
            return result[result.size - 1][result[0].size - 1]
        }

        fun lengthOfLongestSubsequenceWithRecursive(nums: List<Int>, target: Int): Int {
            val result = Array(nums.size + 1) { IntArray(target + 1) { -1 } }
            dp(nums, result, result.size - 1, result[0].size - 1)
            var ans = result[result.size - 1][result[0].size - 1]
            if (ans < 0) {
                ans = -1
            }
            return ans
        }

        fun dp(nums: List<Int>, result: Array<IntArray>, x: Int, y: Int): Int {
            if (y == 0) {
                return 0
            }
            if (y < 0 || x < 1) {
                return Int.MIN_VALUE
            }
            if (result[x][y] != -1) {
                return result[x][y]
            }
            val notPick = dp(nums, result, x - 1, y)
            var pick = dp(nums, result, x - 1, y - nums[x - 1]) + 1
            result[x][y] = max(notPick, pick)
            return result[x][y]
        }
    }
}