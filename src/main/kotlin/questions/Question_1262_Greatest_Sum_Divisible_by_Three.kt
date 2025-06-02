package questions

import java.util.*
import kotlin.math.max

class Question_1262_Greatest_Sum_Divisible_by_Three {

    companion object {

        fun runQuestion() {
//            Input: nums = [3,6,5,1,8]
//            Output: 18
            val nums = intArrayOf(3, 6, 5, 1, 8)
            val result = maxSumDivThree(nums)
            println("Question 1262: $result")
        }

        fun maxSumDivThree(nums: IntArray): Int {
            val map: MutableMap<Int, PriorityQueue<Int>> = mutableMapOf()
            for (i in 0..nums.size - 1) {
                val rest = nums[i] % 3
                val queue = map.getOrDefault(rest, PriorityQueue { a, b -> a - b })
                queue.add(nums[i])
                map[rest] = queue
            }
            val sum = nums.sum()
            val rest1Queue = map[1]
            val rest2Queue = map[2]
            if (sum % 3 == 1) {
                if (rest1Queue != null && rest2Queue == null) {
                    return sum - rest1Queue.remove()
                } else if (rest1Queue == null && rest2Queue != null) {
                    return sum - rest2Queue.remove() - rest2Queue.remove()
                } else {
                    if (rest2Queue!!.size <= 1) {
                        return sum - rest1Queue!!.remove()
                    } else {
                        return max(sum - rest1Queue!!.remove(), sum - rest2Queue!!.remove() - rest2Queue!!.remove())
                    }
                }
            } else if (sum % 3 == 2) {
                if (rest1Queue != null && rest2Queue == null) {
                    return sum - rest1Queue.remove() - rest1Queue.remove()
                } else if (rest1Queue == null && rest2Queue != null) {
                    return sum - rest2Queue.remove()
                } else {
                    if (rest1Queue!!.size <= 1) {
                        return sum - rest2Queue!!.remove()
                    } else {
                        return max(sum - rest1Queue!!.remove() - rest1Queue!!.remove(), sum - rest2Queue!!.remove())
                    }
                }
            } else {
                return sum
            }
        }
    }
}