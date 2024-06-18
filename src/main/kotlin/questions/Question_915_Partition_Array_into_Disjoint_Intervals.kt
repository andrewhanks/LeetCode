package questions

import kotlin.math.max

class Question_915_Partition_Array_into_Disjoint_Intervals {

    companion object {

        fun runQuestion() {
//            Input: nums = [5,0,3,8,6]
//            Output: 3
            val nums = intArrayOf(5, 0, 3, 8, 6)
            val result = partitionDisjoint(nums)
            println("Question 915: $result")
        }

        fun partitionDisjoint(nums: IntArray): Int {
            var max = 0
            for (i in 0..nums.size - 2) {
                max = max(max, nums[i])
                var fit = true
                for (j in i + 1..nums.size - 1) {
                    if (max > nums[j]) {
                        fit = false
                        break
                    }
                }
                if (fit) {
                    return i + 1
                }
            }
            return nums.size
        }
    }
}