package questions


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
    }
}