package questions

import java.util.*

class Question_215_Kth_Largest_Element_in_an_Array {

    companion object {

        fun runQuestion() {
            val numberArray1 = intArrayOf(3, 2, 3, 1, 2, 4, 5, 5, 6)
            val number = 4
            val result = findKthLargest(numberArray1, number)
            println("Question 215: $result")
        }

        fun findKthLargest(nums: IntArray, k: Int): Int {
            nums.sort()
            nums.reverse()
            return nums[k - 1]
        }

        fun findKthLargestOldSolution(nums: IntArray, k: Int): Int {
            val numQueue: PriorityQueue<Int> = PriorityQueue { a, b ->
                b - a
            }
            nums.forEach { value ->
                numQueue.add(value)
            }
            var result = 0
            for (i in 1..k) {
                result = numQueue.remove()
            }
            return result
        }

        fun findKthLargestBaseOnBoundaries(nums: IntArray, k: Int): Int {
            var tempK = k
            val count = IntArray(2 * 10000 + 1)
            for (i in nums.indices) {
                // map -10000~10000 to 0~20000
                count[nums[i] + 10000]++
            }
            for (i in count.indices.reversed()) {
                tempK -= count[i]
                if (tempK <= 0) return i - 10000
            }
            return -10000
        }
    }
}