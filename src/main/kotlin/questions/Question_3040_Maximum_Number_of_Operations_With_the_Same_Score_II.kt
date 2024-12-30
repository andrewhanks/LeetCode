package questions

import kotlin.math.max


class Question_3040_Maximum_Number_of_Operations_With_the_Same_Score_II {

    companion object {

        fun runQuestion() {
//            Input: nums = [3,2,1,2,3,4]
//            Output: 3
            val nums = intArrayOf(3, 2, 1, 2, 3, 4)
            val result = maxOperations(nums)
            println("Question 3040: $result")
        }

        fun maxOperations(nums: IntArray): Int {
            val result = MutableList(nums.size) { MutableList<Int>(nums.size) { -1 } }
            val front = dp(nums, result, 2, nums.size - 1, nums[0] + nums[1])
            val back = dp(nums, result, 0, nums.size - 3, nums[nums.size - 2] + nums[nums.size - 1])
            val frontBack = dp(nums, result, 1, nums.size - 2, nums[0] + nums[nums.size - 1])
            val max = max(frontBack, max(front, back))
            return max + 1
        }

        fun dp(nums: IntArray, result: MutableList<MutableList<Int>>, start: Int, end: Int, sum: Int): Int {
            if (end - start < 1) {
                return 0
            }
            if (result[start][end] != -1) {
                return result[start][end]
            }
            val front = if (sum == nums[start] + nums[start + 1]) {
                dp(nums, result, start + 2, end, sum)
            } else {
                -1
            }
            val back = if (sum == nums[end - 1] + nums[end]) {
                dp(nums, result, start, end - 2, sum)
            } else {
                -1
            }
            val frontBack = if (sum == nums[start] + nums[end]) {
                dp(nums, result, start + 1, end - 1, sum)
            } else {
                -1
            }
            val max = max(frontBack, max(front, back))
            result[start][end] = max
            return max + 1
        }
    }
}