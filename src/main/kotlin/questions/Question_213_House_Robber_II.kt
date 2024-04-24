package questions

import kotlin.math.max


class Question_213_House_Robber_II {

    companion object {

        fun runQuestion() {
//            Input: nums = [1,2,3]
//            Output: 3
            val nums = intArrayOf(1, 2, 3)
            val result = rob(nums)
            println("Question 213: $result")
        }

        fun rob(nums: IntArray): Int {
            val result = Array(2) { Array(nums.size) { -1 } }
            return dp(nums, 0, 0, result)
        }

        fun dp(nums: IntArray, index: Int, firstItemTaken: Int, result: Array<Array<Int>>): Int {
            if (index > nums.size - 1) {
                return 0
            }
            if (result[firstItemTaken][index] != -1) {
                return result[firstItemTaken][index]
            }
            val taken = if (index == 0 || firstItemTaken == 1) {
                nums[index] + dp(nums, index + 2, 1, result)
            } else {
                nums[index] + dp(nums, index + 2, 0, result)
            }
            val notTaken = if (firstItemTaken == 1) {
                dp(nums, index + 1, 1, result)
            } else {
                dp(nums, index + 1, 0, result)
            }
            if (firstItemTaken == 1 && index == nums.size - 1) {
                result[firstItemTaken][index] = notTaken
                return result[firstItemTaken][index]
            } else {
                result[firstItemTaken][index] = max(taken, notTaken)
                return result[firstItemTaken][index]
            }
        }
    }
}