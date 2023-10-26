package questions

import kotlin.math.max

class Question_300_Longest_Increasing_Subsequence {

    companion object {

        fun runQuestion() {
//            Input: nums = [10,9,2,5,3,7,101,18]
//            Output: 4
            val array = intArrayOf(10, 9, 2, 5, 3, 7, 101, 18)
            val result = lengthOfLIS(array)
            println("Question 300: $result")
        }

        fun lengthOfLIS(nums: IntArray): Int {
            if (nums.size <= 1) {
                return nums.size
            }
            val result: MutableList<Int> = MutableList(nums.size) { 1 }
            var ans = 0
            for (x in 1..nums.size - 1) {
                for (y in 0..x - 1) {
                    if (nums[y] >= nums[x]) {
                        continue
                    } else {
                        result[x] = max(result[x], result[y] + 1)
                    }
                }
                ans = max(ans, result[x])
            }
            return ans
        }
    }
}