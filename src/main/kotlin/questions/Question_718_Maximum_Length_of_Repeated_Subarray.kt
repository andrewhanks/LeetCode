package questions

import kotlin.math.max


class Question_718_Maximum_Length_of_Repeated_Subarray {

    companion object {

        fun runQuestion() {
//            Input: nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
//            Output: 3
            val nums1 = intArrayOf(1, 2, 3, 2, 1)
            val nums2 = intArrayOf(3, 2, 1, 4, 7)
            val result = findLength(nums1, nums2)
            println("Question 718: $result")
        }

        fun findLength(nums1: IntArray, nums2: IntArray): Int {
            val result = Array(nums1.size) { IntArray(nums2.size) { 0 } }
            var max = 0
            for (i in 0..nums1.size - 1) {
                for (j in 0..nums2.size - 1) {
                    if (i == 0 || j == 0) {
                        if (nums1[i] == nums2[j]) {
                            result[i][j] = 1
                            max = max(max, result[i][j])
                        } else {
                            result[i][j] = 0
                        }
                    } else {
                        if (nums1[i] == nums2[j]) {
                            result[i][j] = result[i - 1][j - 1] + 1
                            max = max(max, result[i][j])
                        } else {
                            result[i][j] = 0
                        }
                    }
                }
            }
            return max
        }
    }
}