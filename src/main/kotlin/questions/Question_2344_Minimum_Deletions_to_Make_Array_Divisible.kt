package questions

import kotlin.math.max
import kotlin.math.min

class Question_2344_Minimum_Deletions_to_Make_Array_Divisible {

    companion object {

        fun runQuestion() {
//            Input: nums = [2,3,2,4,3], numsDivide = [9,6,9,3,15]
//            Output: 2
            val nums = intArrayOf(2, 3, 2, 4, 3)
            val numsDivide = intArrayOf(9, 6, 9, 3, 15)
            val result = minOperations(nums, numsDivide)
            println("Question 2344: $result")
        }

        fun minOperations(nums: IntArray, numsDivide: IntArray): Int {
            val tempNums = nums.sorted().toMutableList()
            var lcm = numsDivide[0]
            for (num in 1..numsDivide.size - 1) {
                val num1 = min(lcm, numsDivide[num])
                val num2 = max(lcm, numsDivide[num])
                lcm = calculateLcm(num1, num2)
            }
            var count = 0
            while (count <= tempNums.size - 1 && lcm % tempNums[count] != 0) {
                count++
            }
            if (count > nums.size - 1) {
                return -1
            }
            return count
        }

        fun calculateLcm(num1: Int, num2: Int): Int {
            val times = num2 / num1
            val res = num2 % num1
            if (res == 0) {
                return num1
            } else {
                return calculateLcm(num2 - num1 * times, num1)
            }
        }
    }
}