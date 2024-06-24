package questions

import kotlin.math.max

class Question_3196_Maximize_Total_Cost_of_Alternating_Subarrays {

    companion object {

        fun runQuestion() {
//            Input: nums = [1,-2,3,4]
//            Output: 10
            val array = intArrayOf(1, -2, 3, 4)
            val result = maximumTotalCost(array)
            println("Question 3196: $result")
        }

        fun maximumTotalCost(nums: IntArray): Long {
            val result = Array(nums.size) { -1L }
            return dp(nums, result, nums.size - 1)
        }

        fun dp(nums: IntArray, result: Array<Long>, index: Int): Long {
            if (index < 0) {
                return 0
            }
            if (index == 0) {
                return nums[index].toLong()
            }
            if (result[index] != -1L) {
                return result[index]
            }
            val twoNums = dp(nums, result, index - 2) + nums[index - 1].toLong() - nums[index].toLong()
            val oneNums = dp(nums, result, index - 1) + nums[index].toLong()
            result[index] = max(twoNums, oneNums)
            return result[index]
        }
    }
}