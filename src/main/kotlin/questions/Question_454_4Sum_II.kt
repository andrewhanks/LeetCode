package questions

class Question_454_4Sum_II {

    companion object {

        fun runQuestion() {
//            Input: nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
//            Output: 2
            val nums1 = intArrayOf(1, 2)
            val nums2 = intArrayOf(-2, -1)
            val nums3 = intArrayOf(-1, 2)
            val nums4 = intArrayOf(0, 2)
            val result = fourSumCount(nums1, nums2, nums3, nums4)
            println("Question 454: $result")
        }

        fun fourSumCount(nums1: IntArray, nums2: IntArray, nums3: IntArray, nums4: IntArray): Int {
            val temp1: MutableMap<Int, Int> = mutableMapOf()
            val temp2: MutableMap<Int, Int> = mutableMapOf()
            for (i in 0..nums1.size - 1) {
                for (j in 0..nums2.size - 1) {
                    val sum = nums1[i] + nums2[j]
                    if (!temp1.contains(sum)) {
                        temp1.put(sum, 1)
                    } else {
                        temp1[sum] = temp1[sum]!! + 1
                    }
                }
            }
            for (i in 0..nums3.size - 1) {
                for (j in 0..nums4.size - 1) {
                    val sum = nums3[i] + nums4[j]
                    if (!temp2.contains(sum)) {
                        temp2.put(sum, 1)
                    } else {
                        temp2[sum] = temp2[sum]!! + 1
                    }
                }
            }
            var result = 0
            for ((key1, value1) in temp1) {
                for ((key2, value2) in temp2) {
                    if (key1 + key2 == 0) {
                        result = result + (value1 * value2)
                    }
                }
            }
            return result
        }
    }
}