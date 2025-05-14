package questions

import kotlin.math.max


class Question_2401_Longest_Nice_Subarray {

    companion object {

        fun runQuestion() {
//            Input: nums = [1,3,8,48,10]
//            Output: 3
            val nums = intArrayOf(1, 3, 8, 48, 10)
            val result = longestNiceSubarray(nums)
            println("Question 2401: $result")
        }

        fun longestNiceSubarray(nums: IntArray): Int {
            var ans = 1
            for (i in 0..nums.size - 1) {
                var sum = nums[i]
                var current = i + 1
                var count = 1
                while (current <= nums.size - 1 && (sum and nums[current]) == 0) {
                    count++
                    ans = max(ans, count)
                    sum = sum + nums[current]
                    current = current + 1
                }
            }
            return ans
        }
    }
}