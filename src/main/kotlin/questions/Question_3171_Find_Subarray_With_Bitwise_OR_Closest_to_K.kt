package questions

import kotlin.math.abs
import kotlin.math.min


class Question_3171_Find_Subarray_With_Bitwise_OR_Closest_to_K {

    companion object {

        fun runQuestion() {
//            Input: nums = [1,2,4,5], k = 3
//            Output: 0
            val nums = intArrayOf(1, 2, 4, 5)
            val k = 3
            val result = minimumDifference(nums, k)
            println("Question 3171: $result")
        }

        fun minimumDifference(nums: IntArray, k: Int): Int {
            var result: MutableSet<Int> = mutableSetOf()
            var min = Int.MAX_VALUE
            for (i in 0..nums.size - 1) {
                result.add(nums[i])
                for (j in i - 1 downTo 0) {
                    if (nums[i] or nums[j] == nums[j]) {
                        break
                    }
                    nums[j] = nums[j] or nums[i]
                    result.add(nums[j])
                }
            }
            for (item in result) {
                min = min(min, abs(k - item))
            }
            return min
        }
    }
}