package questions

import java.util.*

class Question_795_Number_of_Subarrays_with_Bounded_Maximum {

    companion object {

        fun runQuestion() {
//            Input: nums = [2,9,2,5,6], left = 2, right = 8
//            Output: 7
            val nums = intArrayOf(2, 9, 2, 5, 6)
            val left = 2
            val right = 8
            val result = numSubarrayBoundedMax(nums, left, right)
            println("Question 795: $result")
        }

        fun numSubarrayBoundedMax(nums: IntArray, left: Int, right: Int): Int {
            val curSub = mutableListOf<Int>()
            var i = 0
            var j = 0
            var ans = 0
            for (cur in 0..nums.size - 1) {
                if (nums[cur] > right) {
                    i = cur + 1
                    j = cur + 1
                } else {
                    if (nums[i] < left) {
                        if (i == j && nums[cur] < left) {
                            continue
                        }
                    }
                    if (nums[cur] >= left) {
                        j = cur
                    }
                    ans = ans + j - i + 1
                }
            }
            return ans
        }

        fun numSubarrayBoundedMaxAnotherSolution(nums: IntArray, left: Int, right: Int): Int {
            val size = nums.size
            val stack = Stack<Int>()
            val preGreaterOrEqual = IntArray(size) { -1 }
            val nextGreater = IntArray(size) { size }
            for (i in 0..size - 1) {
                while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                    nextGreater[stack.peek()] = i
                    stack.removeLast()
                }
                stack.add(i)
            }
            stack.clear()
            for (i in size - 1 downTo 0) {
                while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                    preGreaterOrEqual[stack.peek()] = i
                    stack.removeLast()
                }
                stack.add(i)
            }
            var ans = 0
            for (i in 0..size - 1) {
                if (nums[i] >= left && nums[i] <= right) {
                    val j = preGreaterOrEqual[i]
                    val k = nextGreater[i]
                    ans += (i - j) * (k - i)
                }
            }
            return ans
        }
    }
}