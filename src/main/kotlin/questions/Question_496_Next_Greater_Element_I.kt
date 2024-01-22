package questions

class Question_496_Next_Greater_Element_I {

    companion object {

        fun runQuestion() {
//            Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
//            Output: [-1,3,-1]
            val nums1 = intArrayOf(4, 1, 2)
            val nums2 = intArrayOf(1, 3, 4, 2)
            val resultList = nextGreaterElement(nums1, nums2)
            var result = "["
            resultList.forEachIndexed { index, i ->
                result += i
                if (index == resultList.size - 1) {
                    result += "]"
                } else {
                    result += ","
                }
            }
            println("Question 496: $result")
        }

        fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
            val result: MutableList<Int> = mutableListOf()
            for (nums1Count in 0..nums1.size - 1) {
                val target = nums1[nums1Count]
                var nums2Pos = nums2.indexOf(target)
                nums2Pos++
                while (nums2Pos < nums2.size && nums2[nums2Pos] < target) {
                    nums2Pos++
                }
                if (nums2Pos >= nums2.size) {
                    result.add(-1)
                } else {
                    result.add(nums2[nums2Pos])
                }
            }
            return result.toIntArray()
        }
    }
}