package questions

import kotlin.math.min

class Question_3132_Find_the_Integer_Added_to_Array_II {

    companion object {

        fun runQuestion() {
//            Input: nums1 = [4,20,16,12,8], nums2 = [14,18,10]
//            Output: -2
            val nums1 = intArrayOf(4, 20, 16, 12, 8)
            val nums2 = intArrayOf(14, 18, 10)
            val result = minimumAddedInteger(nums1, nums2)
            println("Question 3132: $result")
        }

        fun minimumAddedInteger(nums1: IntArray, nums2: IntArray): Int {
            nums1.sort()
            nums2.sort()
            // println("nums1 = ${nums1.contentToString()}, nums2 = ${nums2.contentToString()}")
            var ans = Int.MAX_VALUE
            for (n1 in 0..nums1.size - 1) {
                for (n2 in n1 + 1..nums1.size - 1) {
                    val temp = nums1.filterIndexed { index, value ->
                        index != n1 && index != n2
                    }
                    // println("temp = $temp, nums2 = ${nums2.contentToString()}")
                    val diff1: MutableList<Int> = mutableListOf()
                    val diff2: MutableList<Int> = mutableListOf()
                    for (count in 1..temp.size - 1) {
                        diff1.add(temp[count] - temp[count - 1])
                    }
                    for (count in 1..nums2.size - 1) {
                        diff2.add(nums2[count] - nums2[count - 1])
                    }
                    // println("diff1 = $diff1, diff2 = $diff2")
                    if (diff1 == diff2) {
                        val min = if (n1 == 0 && n2 == 1) {
                            2
                        } else if (n1 == 0) {
                            1
                        } else {
                            0
                        }
                        // println("nums2[0] = ${nums2[0]}, nums1[$min] = ${nums1[min]}")
                        ans = min(ans, nums2[0] - nums1[min])
                    }
                }
            }
            return ans
        }
    }
}