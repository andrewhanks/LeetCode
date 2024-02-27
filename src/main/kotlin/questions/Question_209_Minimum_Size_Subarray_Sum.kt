package questions

import kotlin.math.min

class Question_209_Minimum_Size_Subarray_Sum {

    companion object {

        fun runQuestion() {
//            Input: target = 7, nums = [2,3,1,2,4,3]
//            Output: 2
            val target = 7
            val inpuArray = intArrayOf(2, 3, 1, 2, 4, 3)
            val result = minSubArrayLen(target, inpuArray)
            println("Question 209: $result")
        }

        fun minSubArrayLenBaseEnd(target: Int, nums: IntArray): Int {
            var length = nums.size
            var sum = 0
            var start = 0
            for (end in 0..nums.size - 1) {
                sum = nums[end]
                start = end
                while (sum < target && start > 0) {
                    start--
                    sum += nums[start]
                }
                //println("end = $end, start = $start, length = $length, sum = $sum")
                if (sum >= target) {
                    length = min(length, end - start + 1)
                }
            }
            return if (length == nums.size && sum < target) {
                0
            } else {
                length
            }
        }

        fun minSubArrayLenWithAddFirst(target: Int, nums: IntArray): Int {
            val result = IntArray(nums.size + 1)
            result[0] = 0
            for (count in 1..nums.size) {
                result[count] = result[count - 1] + nums[count - 1]
            }
            var start = 0
            var end = 0
            var ans = Int.MAX_VALUE
            while (end <= result.size - 1) {
                if (result[end] - result[start] < target) {
                    end++
                } else {
                    if (result[end] - result[start + 1] < target) {
                        ans = min(ans, end - start)
                    }
                    start++
                }
            }
            if (ans == Int.MAX_VALUE) {
                ans = 0
            }
            return ans
        }

        fun minSubArrayLen(target: Int, nums: IntArray): Int {
            var i = 0
            var j = 0
            var minimum = 1000000
            var sum = 0
            while (j <= nums.size - 1) {
                sum += nums[j]
                while (sum >= target) {
                    sum -= nums[i]
                    minimum = min(minimum, j - i + 1)
                    i++
                }
                j++
            }
            if (minimum == 1000000) {
                return 0
            }
            return minimum
        }
    }
}