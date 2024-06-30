package questions

import kotlin.math.max

class Question_3202_Find_the_Maximum_Length_of_Valid_Subsequence_II {

    companion object {

        fun runQuestion() {
//            Input: nums = [1,4,2,3,1,4], k = 3
//            Output: 4
            val nums = intArrayOf(1, 4, 2, 3, 1, 4)
            val k = 3
            val result = maximumLength(nums, k)
            println("Question 3202: $result")
        }

        fun maximumLength(nums: IntArray, k: Int): Int {
            val result = Array(nums.size) { IntArray(k) { 1 } }
            var max = 0
            for (i in 1..nums.size - 1) {
                for (j in i - 1 downTo 0) {
                    val remain = (nums[i] + nums[j]) % k
                    result[i][remain] = max(result[i][remain], result[j][remain] + 1)
                    max = max(max, result[i][remain])
                }
            }
            return max
        }
    }
}