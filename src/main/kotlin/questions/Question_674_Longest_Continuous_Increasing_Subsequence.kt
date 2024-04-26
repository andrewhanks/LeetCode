package questions

import kotlin.math.max

class Question_674_Longest_Continuous_Increasing_Subsequence {

    companion object {

        fun runQuestion() {
//            Input: nums = [1,3,5,4,7]
//            Output: 3
            val array = intArrayOf(1, 3, 5, 4, 7)
            val result = findLengthOfLCIS(array)
            println("Question 674: $result")
        }

        fun findLengthOfLCIS(nums: IntArray): Int {
            var max = 1
            var temp = 1
            for (count in 1..nums.size - 1) {
                if (nums[count] > nums[count - 1]) {
                    temp++
                } else {
                    temp = 1
                }
                max = max(max, temp)
            }
            return max
        }
    }
}