package questions

import java.util.*

class Question_870_Advantage_Shuffle {

    companion object {

        fun runQuestion() {
            val numberArray1 = intArrayOf(12, 24, 8, 32)
            val numberArray2 = intArrayOf(13, 25, 32, 11)
            val resultList = advantageCount(numberArray1, numberArray2)
            var result = "["
            resultList.forEachIndexed { index, i ->
                result += i
                if (index == resultList.size - 1) {
                    result += "]"
                } else {
                    result += ","
                }
            }
            println("Question 870: $result")
        }

        fun advantageCount(nums1: IntArray, nums2: IntArray): IntArray {
            // 0: index, 1: value
            val nums2PQ: PriorityQueue<IntArray> = PriorityQueue { a, b ->
                b[1] - a[1]
            }
            nums2.forEachIndexed { index, value ->
                nums2PQ.add(intArrayOf(index, value))
            }
            val nums1SortedDescending = nums1.sortedDescending().toMutableList()
            val result = IntArray(nums1.size)
            for (i in 0..nums2.size - 1) {
                val tempNum2 = nums2PQ.remove()
                if (tempNum2[1] >= nums1SortedDescending[0]) {
                    result[tempNum2[0]] = nums1SortedDescending.removeAt(nums1SortedDescending.size - 1)
                } else {
                    result[tempNum2[0]] = nums1SortedDescending.removeAt(0)
                }
            }
            return result
        }
    }
}