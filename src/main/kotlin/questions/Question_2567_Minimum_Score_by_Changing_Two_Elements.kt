package questions

import kotlin.math.min

class Question_2567_Minimum_Score_by_Changing_Two_Elements {

    companion object {

        fun runQuestion() {
//            Input: nums = [1,4,7,8,5]
//            Output: 3
            val array = intArrayOf(1, 4, 7, 8, 5)
            val result = minimizeSum(array)
            println("Question 2567: $result")
        }

        fun minimizeSum(nums: IntArray): Int {
            nums.sort()
            var ans1 = 0
            var ans2 = 0
            var ans3 = 0
            ans1 += nums[nums.size - 1] - nums[2]
            ans2 += nums[nums.size - 2] - nums[1]
            ans3 += nums[nums.size - 3] - nums[0]
            val min = min(ans1, min(ans2, ans3))
            return min
        }
    }
}