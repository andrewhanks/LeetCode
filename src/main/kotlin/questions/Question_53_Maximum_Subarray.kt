package questions

import kotlin.math.max


class Question_53_Maximum_Subarray {

    companion object {

        fun runQuestion() {
//            Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
//            Output: 6
            val intArray = intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)
            val result = maxSubArray(intArray)
            println("Question 53: $result")
        }

        fun maxSubArrayMySolution(nums: IntArray): Int {
            var sum = 0
            var max = 0
            var allNegative = true
            for (count in 0..nums.size - 1) {
                if (nums[count] >= 0) {
                    allNegative = false
                    break
                }
            }
            if (allNegative) {
                return nums.max()
            }
            for (count in 0..nums.size - 1) {
                sum += nums[count]
                if (sum < 0) {
                    sum = 0
                }
                max = max(max, sum)
            }
            return max
        }

        fun maxSubArray(nums: IntArray): Int {
            var sum = 0
            var max = nums[0]
            for (count in 0..nums.size - 1) {
                sum += nums[count]
                max = max(max, sum)
                if (sum < 0) {
                    sum = 0
                }
            }
            return max
        }
    }
}