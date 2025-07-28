package questions

import kotlin.math.max


class Question_2321_Maximum_Score_Of_Spliced_Array {

    companion object {

        fun runQuestion() {
//            Input: nums1 = [20,40,20,70,30], nums2 = [50,20,50,40,20]
//            Output: 220
            val nums1 = intArrayOf(20, 40, 20, 70, 30)
            val nums2 = intArrayOf(50, 20, 50, 40, 20)
            val result = maximumsSplicedArray(nums1, nums2)
            println("Question 2321: $result")
        }

        fun maximumsSplicedArray(nums1: IntArray, nums2: IntArray): Int {
            val size = nums1.size
            val dp1 = Array(3) { IntArray(size) { 0 } }
            dp1[0][0] = nums1[0]
            dp1[1][0] = nums2[0]
            dp1[2][0] = 0
            for (i in 1..size - 1) {
                dp1[0][i] = dp1[0][i - 1] + nums1[i]
            }
            for (j in 1..size - 1) {
                for (i in 1..2) {
                    if (i == 1) {
                        dp1[i][j] = max(dp1[i - 1][j - 1] + nums2[j], dp1[i][j - 1] + nums2[j])
                    } else if (i == 2) {
                        dp1[i][j] = max(dp1[i - 1][j - 1] + nums1[j], dp1[i][j - 1] + nums1[j])
                    }
                }
            }
            val dp2 = Array(3) { IntArray(size) { 0 } }
            dp2[0][0] = nums2[0]
            dp2[1][0] = nums1[0]
            dp2[2][0] = 0
            for (i in 1..size - 1) {
                dp2[0][i] = dp2[0][i - 1] + nums2[i]
            }
            for (j in 1..size - 1) {
                for (i in 1..2) {
                    if (i == 1) {
                        dp2[i][j] = max(dp2[i - 1][j - 1] + nums1[j], dp2[i][j - 1] + nums1[j])
                    } else if (i == 2) {
                        dp2[i][j] = max(dp2[i - 1][j - 1] + nums2[j], dp2[i][j - 1] + nums2[j])
                    }
                }
            }
            return max(max(dp1[0][size - 1], dp1[2][size - 1]), max(dp2[0][size - 1], dp2[2][size - 1]))
        }
    }
}