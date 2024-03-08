package questions

import java.util.*
import kotlin.collections.ArrayDeque
import kotlin.collections.ArrayList
import kotlin.collections.MutableList
import kotlin.collections.indices
import kotlin.collections.mutableListOf
import kotlin.collections.toIntArray
import kotlin.math.max


class Question_239_Sliding_Window_Maximum {

    companion object {

        fun runQuestion() {
//            Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
//            Output: [3,3,5,5,6,7]
            val nums = intArrayOf(1, 3, -1, -3, 5, 3, 6, 7)
            val k = 3
            val result = maxSlidingWindow(nums, k)
            println("Question 239: ${result.contentToString()}")
        }

        fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
            val result: MutableList<Int> = mutableListOf()
            var maxNumberPosition = -1
            for (count in 0..nums.size - k) {
                var max = Int.MIN_VALUE
                if (maxNumberPosition >= count && maxNumberPosition <= count + k - 2) {
                    max = nums[maxNumberPosition]
                    // println("count+k-1 = ${count+k-1}, maxNumberPosition = $maxNumberPosition")
                    // println("nums[count+k-1] = ${nums[count+k-1]}, nums[maxNumberPosition] = ${nums[maxNumberPosition]}")
                    if (nums[count + k - 1] >= nums[maxNumberPosition]) {
                        maxNumberPosition = count + k - 1
                    }
                    max = max(max, nums[count + k - 1])
                } else {
                    for (item in 0..k - 1) {
                        if (nums[count + item] >= max) {
                            maxNumberPosition = count + item
                        }
                        max = max(max, nums[count + item])
                    }
                }
                // println("count = $count, maxNumberPosition = $maxNumberPosition")
                result.add(max)
            }
            return result.toIntArray()
        }

        fun maxSlidingWindowWithDeque(nums: IntArray, k: Int): IntArray {
            val q = ArrayDeque<Int>() // stores *indices*
            val res: MutableList<Int> = ArrayList()
            for (i in nums.indices) {
                while (!q.isEmpty() && nums[q.last()] <= nums[i]) {
                    q.removeLast()
                }
                q.addLast(i)
                // remove first element if it's outside the window
                if (q.first() == i - k) {
                    q.removeFirst()
                }
                // if window has k elements add to results (first k-1 windows have < k elements because we start from
                // empty window and add 1 element each iteration)
                if (i >= k - 1) {
                    res.add(nums[q[0]])
                }
            }
            return res.toIntArray()
        }

    }
}