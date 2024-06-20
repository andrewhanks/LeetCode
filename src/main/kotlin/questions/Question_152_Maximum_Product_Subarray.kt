package questions

import kotlin.math.max

class Question_152_Maximum_Product_Subarray {

    companion object {

        fun runQuestion() {
//            Input: nums = [2,3,-2,4]
//            Output: 6
            val nums = intArrayOf(2, 3, -2, 4)
            val result = maxProduct(nums)
            println("Question 152: $result")
        }

        fun maxProduct(nums: IntArray): Int {
            var max = Int.MIN_VALUE
            for (i in 0..nums.size - 1) {
                var product = 1.0
                for (j in i..nums.size - 1) {
                    product *= nums[j]
                    max = max(max, product.toInt())
                }
            }
            return max
        }
    }
}