package questions

import kotlin.math.min

class Question_209_Minimum_Size_Subarray_Sum {

    companion object {

        fun runQuestion() {
//            Input: target = 7, nums = [2,3,1,2,4,3]
//            Output: 2
            val target = 7
            val inpuArray = intArrayOf(2, 3, 1, 2, 4, 3)
            val result = minSubArrayLen(target, inpuArray)
            println("Question 209: $result")
        }

        fun minSubArrayLen(target: Int, nums: IntArray): Int {
            var i = 0
            var j = 0
            var minimum = 1000000
            var sum = 0
            while (j <= nums.size - 1) {
                sum += nums[j]
                while (sum >= target) {
                    sum -= nums[i]
                    minimum = min(minimum, j - i + 1)
                    i++
                }
                j++
            }
            if (minimum == 1000000) {
                return 0
            }
            return minimum
        }
    }
}