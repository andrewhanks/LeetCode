package questions

import kotlin.math.max


class Question_1035_Uncrossed_Lines {

    companion object {

        fun runQuestion() {
//            Input: nums1 = [1,4,2], nums2 = [1,2,4]
//            Output: 2
            val nums1 = intArrayOf(1, 4, 2)
            val nums2 = intArrayOf(1, 2, 4)
            val result = maxUncrossedLines(nums1, nums2)
            println("Question 1035: $result")
        }

        fun maxUncrossedLines(nums1: IntArray, nums2: IntArray): Int {
            val result = Array(nums1.size) { IntArray(nums2.size) { 0 } }
            for (i in 0..nums1.size - 1) {
                for (j in 0..nums2.size - 1) {
                    if (i == 0 || j == 0) {
                        if (nums1[i] == nums2[j]) {
                            result[i][j] = 1
                        } else {
                            var max = 0
                            if (i == 0 && j >= 1) {
                                max = result[i][j - 1]
                            } else if (j == 0 && i >= 1) {
                                max = result[i - 1][j]
                            } else {
                                max = 0
                            }
                            result[i][j] = max
                        }
                    } else {
                        var max = 0
                        if (nums1[i] == nums2[j]) {
                            max = max(result[i - 1][j], result[i][j - 1])
                            max = max(max, result[i - 1][j - 1] + 1)
                        } else {
                            max = max(result[i - 1][j], result[i][j - 1])
                            max = max(max, result[i - 1][j - 1])
                        }
                        result[i][j] = max
                    }
                }
            }
            println(result.contentDeepToString())
            return result[nums1.size - 1][nums2.size - 1]
        }
    }
}