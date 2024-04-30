package questions

import java.util.*

class Question_503_Next_Greater_Element_II {

    companion object {

        fun runQuestion() {
//            Input: nums = [1,2,3,4,3]
//            Output: [2,3,4,-1,4]
            val nums = intArrayOf(1, 2, 3, 4, 3)
            val result = nextGreaterElements(nums)
            println("Question 503: ${result.contentToString()}")
        }

        fun nextGreaterElements(nums: IntArray): IntArray {
            val result = IntArray(nums.size) { -1 }
            for (i in 0..nums.size - 1) {
                for (j in i + 1..nums.size * 2 - 1) {
                    val finalJ = j % nums.size
                    if (nums[finalJ] > nums[i]) {
                        result[i] = nums[finalJ]
                        break
                    }
                }
            }
            return result
        }

        fun nextGreaterElementsWithStack(nums: IntArray): IntArray {
            val result = IntArray(nums.size) { -1 }
            val stack: Stack<Int> = Stack()
            for (i in 0..nums.size * 2 - 1) {
                val index = i % nums.size
                while (!stack.isEmpty() && nums[stack.peek()] < nums[index]) {
                    val temp = stack.removeLast()
                    result[temp] = nums[index]
                }
                stack.add(index)
            }
            return result
        }
    }
}