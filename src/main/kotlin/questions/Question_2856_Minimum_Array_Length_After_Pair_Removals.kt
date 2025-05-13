package questions

import java.util.*
import kotlin.math.max

class Question_2856_Minimum_Array_Length_After_Pair_Removals {

    companion object {

        fun runQuestion() {
//            Input: nums = [1,1,2,2,3,3]
//            Output: 0
            val nums = listOf(1, 1, 2, 2, 3, 3)
            val result = minLengthAfterRemovals(nums)
            println("Question 2856: $result")
        }

        fun minLengthAfterRemovals(nums: List<Int>): Int {
            val map: MutableMap<Int, Int> = mutableMapOf()
            for (i in 0..nums.size - 1) {
                val num = nums[i]
                map[num] = map.getOrDefault(num, 0) + 1
            }
            val queue = PriorityQueue<IntArray> { a, b ->
                b[1] - a[1]
            }

            for ((key, value) in map) {
                val item = intArrayOf(key, value)
                queue.add(item)
            }
            var count = 0
            while (!queue.isEmpty() && queue.size >= 2) {
                val item1 = queue.remove()
                val item2 = queue.remove()
                item1[1]--
                item2[1]--
                if (item1[1] > 0) {
                    queue.add(item1)
                }
                if (item2[1] > 0) {
                    queue.add(item2)
                }
            }
            if (queue.isEmpty()) {
                return 0
            } else {
                return queue.remove()[1]
            }
        }

        fun minLengthAfterRemovalsFaster(nums: List<Int>): Int {
            val map: MutableMap<Int, Int> = mutableMapOf()
            for (i in 0..nums.size - 1) {
                val num = nums[i]
                map[num] = map.getOrDefault(num, 0) + 1
            }
            var max = 0
            for ((key, value) in map) {
                max = max(max, value)
            }
            if (max > nums.size / 2) {
                return max - (nums.size - max)
            } else {
                if (nums.size % 2 == 0) {
                    return 0
                } else {
                    return 1
                }
            }
        }
    }
}