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

        // https://leetcode.wang/leetcode-152-Maximum-Product-Subarray.html 解法二
        fun maxProductLinearSolution(nums: IntArray): Int {
            var max = 1.0
            var ans = nums[0].toDouble()
            for (count in 0..nums.size - 1) {
                max = max * nums[count]
                ans = max(max, ans)
                if (max == 0.0) {
                    max = 1.0
                }
            }
            max = 1.0
            for (count in nums.size - 1 downTo 0) {
                max = max * nums[count]
                ans = max(max, ans)
                if (max == 0.0) {
                    max = 1.0
                }
            }
            return ans.toInt()
        }
    }
}