package questions

import kotlin.math.min


class Question_1658_Minimum_Operations_to_Reduce_X_to_Zero {

    companion object {

        fun runQuestion() {
//            Input: nums = [1,1,4,2,3], x = 5
//            Output: 2
            val nums = intArrayOf(1, 1, 4, 2, 3)
            val x = 5
            val result = minOperations(nums, x)
            println("Question 1658: $result")
        }

        fun minOperations(nums: IntArray, x: Int): Int {
            val map = mutableMapOf<Int, Int>()
            val n = nums.size
            var preSum = 0
            map.put(0, -1)
            for (a in 0..n - 1) {
                preSum += nums[a]
                map.put(preSum, a)
            }
            var ret = Int.MAX_VALUE
            if (map.contains(x)) {
                ret = map[x]!! + 1
            }
            var sufSum = 0
            for (b in n - 1 downTo 0) {
                sufSum += nums[b]
                if (map.contains(x - sufSum)) {
                    val preIndex = map[x - sufSum]!!
                    if (preIndex < b) {
                        ret = min(ret, preIndex + 1 + n - b)
                    }
                }
            }
            return if (ret == Int.MAX_VALUE) {
                -1
            } else {
                ret
            }
        }
    }
}