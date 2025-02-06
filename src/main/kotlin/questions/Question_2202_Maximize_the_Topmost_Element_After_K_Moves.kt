package questions

import java.util.*


class Question_2202_Maximize_the_Topmost_Element_After_K_Moves {

    companion object {

        fun runQuestion() {
//            Input: nums = [5,2,2,4,0,6], k = 4
//            Output: 5
            val nums = intArrayOf(5, 2, 2, 4, 0, 6)
            val k = 4
            val result = maximumTop(nums, k)
            println("Question 2202: $result")
        }

        fun maximumTop(nums: IntArray, k: Int): Int {
            if (k == 0) {
                return nums[0]
            }
            if (k == 1) {
                if (nums.size == 1) {
                    return -1
                }
                return nums[1]
            }
            if (nums.size == 1) {
                if (k % 2 == 1) {
                    return -1
                } else {
                    return nums[0]
                }
            }
            val queue = PriorityQueue<Int> { a, b ->
                b - a
            }
            if (nums.size > k) {
                for (i in 0..k - 2) {
                    queue.add(nums[i])
                }
                val item = queue.remove()
                if (nums[k] > item) {
                    return nums[k]
                } else {
                    return item
                }
            } else if (nums.size == k) {
                for (i in 0..nums.size - 2) {
                    queue.add(nums[i])
                }
                return queue.remove()
            } else {
                for (i in 0..nums.size - 1) {
                    queue.add(nums[i])
                }
                return queue.remove()
            }
        }
    }
}