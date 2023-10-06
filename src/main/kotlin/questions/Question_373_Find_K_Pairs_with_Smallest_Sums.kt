package questions

import java.util.*


class Question_373_Find_K_Pairs_with_Smallest_Sums {

    companion object {

        fun runQuestion() {
//            Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
//            Output: [[1,2],[1,4],[1,6]]
            val nums1 = intArrayOf(1, 7, 11)
            val nums2 = intArrayOf(2, 4, 6)
            val k = 3
            val resultList = kSmallestPairs(nums1, nums2, k)
            var result = "["
            resultList.forEachIndexed { firstIndex, firstI ->
                resultList[firstIndex].forEachIndexed { secondIndex, secondI ->
                    if (0 == secondIndex) {
                        result += "["
                    }
                    result += secondI
                    if (secondIndex == resultList[firstIndex].size - 1) {
                        result += "]"
                    } else {
                        result += ","
                    }
                }
                if (firstIndex == resultList.size - 1) {
                    result += "]"
                } else {
                    result += ","
                }
            }
            if (']' != result.last()) {
                result += "]"
            }
            println("Question 373: $result")
        }

        fun kSmallestPairs(nums1: IntArray, nums2: IntArray, k: Int): List<List<Int>> {
            val all: PriorityQueue<IntArray> = PriorityQueue { a, b -> a[0] - b[0] }
            for (i in 0..nums1.size - 1) {
                all.add(intArrayOf(nums1[i] + nums2[0], i, 0))
            }
            val result: MutableList<MutableList<Int>> = mutableListOf()
            while (result.size < k && !all.isEmpty()) {
                val item = all.remove()
                val i = item[1]
                val j = item[2]
                result.add(mutableListOf(nums1[i], nums2[j]))
                if (j < nums2.size - 1) {
                    all.add(intArrayOf(nums1[i] + nums2[j + 1], i, j + 1))
                }
            }
            return result
        }
    }
}