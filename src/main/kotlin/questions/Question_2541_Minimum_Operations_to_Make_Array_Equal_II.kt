package questions


class Question_2541_Minimum_Operations_to_Make_Array_Equal_II {

    companion object {

        fun runQuestion() {
//            Input: nums1 = [4,3,1,4], nums2 = [1,3,7,1], k = 3
//            Output: 2
            val nums1 = intArrayOf(4, 3, 1, 4)
            val nums2 = intArrayOf(1, 3, 7, 1)
            val k = 3
            val result = minOperations(nums1, nums2, k)
            println("Question 2541: $result")
        }

        fun minOperations(nums1: IntArray, nums2: IntArray, k: Int): Long {
            var addNum = 0L
            var minusNum = 0L
            for (count in 0..nums1.size - 1) {
                if (nums1[count] > nums2[count]) {
                    addNum += nums1[count] - nums2[count]
                } else if (nums2[count] > nums1[count]) {
                    minusNum += nums2[count] - nums1[count]
                }
                if (k != 0 && (nums1[count] - nums2[count]) % k != 0) {
                    return -1
                }
            }
            // println("addNum = $addNum, minusNum = $minusNum")
            if (addNum == minusNum && k != 0 && addNum % k == 0L && minusNum % k == 0L) {
                return addNum / k
            } else if (k == 0 && addNum == 0L && minusNum == 0L) {
                return 0
            } else {
                return -1
            }
        }

        fun minOperationsAnotherSolution(nums1: IntArray, nums2: IntArray, k: Int): Long {
            if (k == 0) {
                for (count in 0..nums1.size - 1) {
                    if (nums1[count] - nums2[count] != 0) {
                        return -1
                    }
                }
                return 0
            }
            var positive = 0L
            var negative = 0L
            for (count in 0..nums1.size - 1) {
                if (nums1[count] > nums2[count]) {
                    val diff = nums1[count] - nums2[count]
                    if (diff % k != 0) {
                        return -1
                    }
                    positive += diff
                } else if (nums1[count] < nums2[count]) {
                    val diff = nums2[count] - nums1[count]
                    if (diff % k != 0) {
                        return -1
                    }
                    negative += diff
                }
            }
            if (positive == negative) {
                return positive / k
            } else {
                return -1
            }
        }
    }
}