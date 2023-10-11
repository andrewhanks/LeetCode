package questions

class Question_88_Merge_Sorted_Array {

    companion object {

        fun runQuestion() {
//            Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//            Output: [1,2,2,3,5,6]
            val nums1 = intArrayOf(1, 2, 3, 0, 0, 0)
            val m = 3
            val nums2 = intArrayOf(2, 5, 6)
            val n = 3
            merge(nums1, m, nums2, n)
            var result = "["
            nums1.forEachIndexed { index, i ->
                result += i
                if (index == nums1.size - 1) {
                    result += "]"
                } else {
                    result += ","
                }
            }
            println("Question 88: $result")
        }

        fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
            var x = 0
            var y = 0
            while (x < nums1.size) {
                if (x > m - 1) {
                    nums1[x] = nums2[y]
                    y++
                }
                x++
            }
            nums1.sort()
        }
    }
}