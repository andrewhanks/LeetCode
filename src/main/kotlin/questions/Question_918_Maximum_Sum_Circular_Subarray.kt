package questions

import kotlin.math.max


class Question_918_Maximum_Sum_Circular_Subarray {

    companion object {

        fun runQuestion() {
//            Input: nums = [5,-3,5]
//            Output: 10
            val intArray = intArrayOf(5, -3, 5)
            val result = maxSubarraySumCircular(intArray)
            println("Question 918: $result")
        }

        fun maxSubarraySumCircular(nums: IntArray): Int {
            // get max in nums
            val max = kadaneAlgo(nums)
            // 1. calculate sum of all items in nums.
            // 2. multiply all items by -1 for finding min in nums
            var sum = 0
            for (count in 0..nums.size - 1) {
                sum = sum + nums[count]
                nums[count] = -nums[count]
            }
            // get min in nums
            val min = -kadaneAlgo(nums)

            // println("$max, $sum, $min")
            if (sum == min) {
                return max
            }
            return max(max, sum - min)
        }

        fun kadaneAlgo(nums: IntArray): Int {
            var sum = 0
            var max = Int.MIN_VALUE
            nums.forEach { value ->
                sum = sum + value
                max = max(max, sum)
                if (sum < 0) {
                    sum = 0
                }
            }
            return max
        }

        fun maxSubarraySumCircularSlow(nums: IntArray): Int {
            val circular: IntArray = nums + nums
            var max = -50000
            var sum = 0
            for (i in 0..nums.size - 1) {
                sum = 0
                for (j in (i + 0)..(i + nums.size - 1)) {
                    val value = circular[j]
                    sum = sum + value
                    max = max(max, sum)
                    if (sum < 0) {
                        sum = 0
                    }
                }
            }
            return max
        }
    }
}