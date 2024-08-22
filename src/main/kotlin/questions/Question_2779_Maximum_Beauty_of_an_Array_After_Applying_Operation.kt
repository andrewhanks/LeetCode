package questions

import kotlin.math.max


class Question_2779_Maximum_Beauty_of_an_Array_After_Applying_Operation {

    companion object {

        fun runQuestion() {
//            Input: nums = [4,6,1,2], k = 2
//            Output: 3
            val nums = intArrayOf(4, 6, 1, 2)
            val k = 2
            val result = maximumBeauty(nums, k)
            println("Question 2779: $result")
        }

        fun maximumBeauty(nums: IntArray, k: Int): Int {
            nums.sort()
            var max = 0
            var right = 0
            var left = 0
            for (count in nums[0] - k..nums[nums.size - 1] + k) {
                while (right <= nums.size - 1 && nums[right] - k <= count && nums[right] + k >= count) {
                    right++
                }
                while (left <= nums.size - 1 && nums[left] + k < count) {
                    left++
                }
                max = max(max, right - left)
            }
            return max
        }
    }
}