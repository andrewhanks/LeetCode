package questions

import kotlin.math.max
import kotlin.math.min


class Question_2447_Number_of_Subarrays_With_GCD_Equal_to_K {

    companion object {

        fun runQuestion() {
//            Input: nums = [9,3,1,2,6,3], k = 3
//            Output: 4
            val nums = intArrayOf(9, 3, 1, 2, 6, 3)
            val k = 3
            val result = subarrayGCD(nums, k)
            println("Question 2447: $result")
        }

        fun subarrayGCD(nums: IntArray, k: Int): Int {
            var currentGcd = 1
            var ans = 0
            for (i in 0..nums.size - 1) {
                if (nums[i] == k) {
                    ans++
                    // println("i = $i, ans = $ans")
                }
                for (j in i + 1..nums.size - 1) {
                    if (j == i + 1) {
                        currentGcd = calculateGcd(nums[i], nums[j])
                    } else {
                        currentGcd = calculateGcd(currentGcd, nums[j])
                    }
                    if (currentGcd == k) {
                        ans++
                        // println("i = $i, j = $j, ans = $ans")
                    } else if (currentGcd < k) {
                        break
                    }
                }
            }
            return ans
        }

        fun calculateGcd(num1: Int, num2: Int): Int {
            val max = max(num1, num2)
            val min = min(num1, num2)
            if (max % min == 0) {
                return min
            } else {
                return calculateGcd(min, max % min)
            }
        }
    }
}