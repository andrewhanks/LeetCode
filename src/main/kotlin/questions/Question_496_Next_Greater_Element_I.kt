package questions

import java.util.*

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

        fun nextGreaterElementWithMonotonicStack(nums1: IntArray, nums2: IntArray): IntArray {
            val stack: Stack<Int> = Stack()
            val result: MutableMap<Int, Int> = mutableMapOf()
            for (count in nums2.size - 1 downTo 0) {
                while (!stack.isEmpty() && stack.peek() <= nums2[count]) {
                    stack.removeLast()
                }
                val ans = if (stack.isEmpty()) {
                    -1
                } else {
                    stack.peek()
                }
                result.put(nums2[count], ans)
                stack.add(nums2[count])
            }
            val finalResult = IntArray(nums1.size)
            for ((key, value) in result) {
                if (nums1.contains(key)) {
                    finalResult[nums1.indexOf(key)] = value
                }
            }
            return finalResult
        }
    }
}