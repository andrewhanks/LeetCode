package questions

import kotlin.math.max

class Question_1558_Minimum_Numbers_of_Function_Calls_to_Make_Target_Array {

    companion object {

        fun runQuestion() {
//            Input: nums = [1,5]
//            Output: 5
            val nums = intArrayOf(1, 5)
            val result = minOperations(nums)
            println("Question 1558: $result")
        }

        fun minOperations(nums: IntArray): Int {
            val result = Array(nums.size) { IntArray(2) { 0 } }
            for (count in 0..nums.size - 1) {
                result[count] = calculate(nums[count])
            }
            // println("result = ${result.contentDeepToString()}")
            var ans = 0
            var maxSub = 0
            for (count in 0..result.size - 1) {
                maxSub = max(maxSub, result[count][0])
                ans += result[count][1]
            }
            ans += maxSub
            return ans
        }

        fun calculate(num: Int): IntArray {
            val ret = IntArray(2) { 0 }
            var tempNum = num
            while (tempNum != 0) {
                val sub = tempNum / 2
                val res = tempNum % 2
                if (sub != 0) {
                    ret[0]++
                }
                if (res != 0) {
                    ret[1]++
                }
                tempNum = sub
            }
            return ret
        }
    }
}