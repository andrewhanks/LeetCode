package questions

import kotlin.math.max


class Question_1004_Max_Consecutive_Ones_III {

    companion object {

        fun runQuestion() {
//            Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
//            Output: 10
            val nums = intArrayOf(0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1)
            val k = 3
            val result = longestOnes(nums, k)
            println("Question 1004: $result")
        }

        fun longestOnes(nums: IntArray, k: Int): Int {
            var start = 0
            val numbers = IntArray(2) { 0 }
            var max = 0
            for (end in 0..nums.size - 1) {
                numbers[nums[end]]++
                if (numbers[0] <= k) {
                    max = max(max, end - start + 1)
                } else {
                    numbers[nums[start]]--
                    start++
                }
            }
            return max
        }
    }
}