package questions

class Question_349_Intersection_of_Two_Arrays {

    companion object {

        fun runQuestion() {
//            Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//            Output: [9,4]
            val nums1 = intArrayOf(4, 9, 5)
            val nums2 = intArrayOf(9, 4, 9, 8, 4)
            val resultList = intersection(nums1, nums2)
            var result = "["
            resultList.forEachIndexed { index, i ->
                result += i
                if (index == resultList.size - 1) {
                    result += "]"
                } else {
                    result += ","
                }
            }
            println("Question 349: $result")
        }

        fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
            val result: MutableList<Int> = mutableListOf()
            for (count in 0..1000) {
                if (nums1.contains(count) && nums2.contains(count)) {
                    result.add(count)
                }
            }
            return result.toIntArray()
        }
    }
}