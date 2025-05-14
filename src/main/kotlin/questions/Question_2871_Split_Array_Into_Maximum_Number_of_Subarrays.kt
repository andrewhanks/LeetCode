package questions

import kotlin.math.max


class Question_2871_Split_Array_Into_Maximum_Number_of_Subarrays {

    companion object {

        fun runQuestion() {
//            Input: nums = [1,0,2,0,1,2]
//            Output: 3
            val nums = intArrayOf(1, 0, 2, 0, 1, 2)
            val result = maxSubarrays(nums)
            println("Question 2871: $result")
        }

        fun maxSubarrays(nums: IntArray): Int {
            var ans = 0
            var subAnd = 0
            for (i in 0..nums.size - 1) {
                if (subAnd == 0) {
                    ans++
                    subAnd = nums[i]
                } else {
                    subAnd = subAnd and nums[i]
                }
            }
            if (subAnd != 0 && ans > 1) {
                ans--
            }
            return ans
        }

        fun maxSubarraysWebSolution(nums: IntArray): Int {
            var ans = 0
            var i = 0
            while (i <= nums.size - 1) {
                var j = i
                var x = nums[i]
                while (j + 1 <= nums.size - 1 && x != 0) {
                    j++
                    x = x and nums[j]
                }
                if (x == 0) {
                    ans++
                }
                i = j + 1
            }
            return max(1, ans)
        }
    }
}