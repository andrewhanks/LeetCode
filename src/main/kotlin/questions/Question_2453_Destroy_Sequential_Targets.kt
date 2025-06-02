package questions

import kotlin.math.min

class Question_2453_Destroy_Sequential_Targets {

    companion object {

        fun runQuestion() {
//            Input: nums = [3,7,8,1,1,5], space = 2
//            Output: 1
            val nums = intArrayOf(3, 7, 8, 1, 1, 5)
            val space = 2
            val result = destroyTargets(nums, space)
            println("Question 2453: $result")
        }

        fun destroyTargets(nums: IntArray, space: Int): Int {
            val result: MutableMap<Int, IntArray> = mutableMapOf()
            var max = 0
            var ans = Int.MAX_VALUE

            for (i in 0..nums.size - 1) {
                val item = result.getOrDefault(nums[i] % space, intArrayOf(Int.MAX_VALUE, 0))
                item[0] = min(item[0], nums[i])
                item[1]++
                val min = item[0]
                val times = item[1]
                result[nums[i] % space] = intArrayOf(min, times)
                if (times > max || (times == max && min < ans)) {
                    max = times
                    ans = min
                }
            }

            return ans
        }
    }
}