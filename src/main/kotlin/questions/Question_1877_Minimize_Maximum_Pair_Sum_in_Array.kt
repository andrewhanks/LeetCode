package questions

import kotlin.math.max

class Question_1877_Minimize_Maximum_Pair_Sum_in_Array {

    companion object {

        fun runQuestion() {
//            Input: nums = [4,1,5,1,2,5,1,5,5,4]
//            Output: 8
            val nums = intArrayOf(4, 1, 5, 1, 2, 5, 1, 5, 5, 4)
            val result = minPairSum(nums)
            println("Question 1877: $result")
        }

        fun minPairSum(nums: IntArray): Int {
            nums.sort()
            var start = 0
            var end = nums.size - 1
            var max = 0
            while (start < end) {
                max = max(max, nums[start] + nums[end])
                start++
                end--
            }
            return max
        }
    }
}