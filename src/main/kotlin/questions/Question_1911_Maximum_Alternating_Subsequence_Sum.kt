package questions

import kotlin.math.max

class Question_1911_Maximum_Alternating_Subsequence_Sum {

    companion object {

        fun runQuestion() {
//            Input: nums = [6,2,1,2,4,5]
//            Output: 10
            val array = intArrayOf(6, 2, 1, 2, 4, 5)
            val result = maxAlternatingSum(array)
            println("Question 1911: $result")
        }

        fun maxAlternatingSum(nums: IntArray): Long {
            var ans = 0L
            for (i in 0..nums.size - 2) {
                if (nums[i] > nums[i + 1]) {
                    ans += (nums[i].toLong() - nums[i + 1])
                }
            }
            ans += nums[nums.size - 1]
            return ans
        }

        fun maxAlternatingSumDp(nums: IntArray): Long {
            val n = nums.size
            val even = LongArray(n) { 0L }
            val odd = LongArray(n) { 0L }
            even[0] = nums[0].toLong()
            odd[0] = 0
            for (i in 1..n - 1) {
                even[i] = max(odd[i - 1] + nums[i], even[i - 1])
                odd[i] = max(even[i - 1] - nums[i], odd[i - 1])
            }
            return max(even[n - 1], odd[n - 1])
        }
    }
}