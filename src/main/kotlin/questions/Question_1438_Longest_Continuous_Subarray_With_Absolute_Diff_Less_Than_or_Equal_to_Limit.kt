package questions

import java.util.*
import kotlin.math.max
import kotlin.math.min


class Question_1438_Longest_Continuous_Subarray_With_Absolute_Diff_Less_Than_or_Equal_to_Limit {

    companion object {

        fun runQuestion() {
//            Input: nums = [8,2,4,7], limit = 4
//            Output: 2
            val nums = intArrayOf(8, 2, 4, 7)
            val limit = 4
            val result = longestSubarray(nums, limit)
            println("Question 1438: $result")
        }

        fun longestSubarray(nums: IntArray, limit: Int): Int {
            val maxQueue = PriorityQueue<IntArray> { a, b ->
                if (a[1] == b[1]) {
                    a[0] - b[0]
                } else {
                    b[1] - a[1]
                }
            }
            val minQueue = PriorityQueue<IntArray> { a, b ->
                if (a[1] == b[1]) {
                    a[0] - b[0]
                } else {
                    a[1] - b[1]
                }
            }
            var ans = 0
            var left = -1
            for (right in 0..nums.size - 1) {
                maxQueue.add(intArrayOf(right, nums[right]))
                minQueue.add(intArrayOf(right, nums[right]))
                while (!maxQueue.isEmpty() && !minQueue.isEmpty() && maxQueue.peek()[1] - minQueue.peek()[1] > limit) {
                    left = min(maxQueue.peek()[0], minQueue.peek()[0])
                    while (maxQueue.peek()[0] <= left) {
                        maxQueue.remove()
                    }
                    while (minQueue.peek()[0] <= left) {
                        minQueue.remove()
                    }
                }
                ans = max(ans, right - (left + 1) + 1)
            }
            return ans
        }
    }
}