package questions

import kotlin.math.min

class Question_3194_Minimum_Average_of_Smallest_and_Largest_Elements {

    companion object {

        fun runQuestion() {
//            Input: nums = [7,8,3,4,15,13,4,1]
//            Output: 5.5
            val array = intArrayOf(7, 8, 3, 4, 15, 13, 4, 1)
            val result = minimumAverage(array)
            println("Question 3194: $result")
        }

        fun minimumAverage(nums: IntArray): Double {
            var ans = 50.0
            nums.sort()
            var i = 0
            var j = nums.size - 1
            while (i < j) {
                ans = min(ans, ((nums[i].toDouble() + nums[j].toDouble()) / 2))
                i++
                j--
            }
            return ans
        }
    }
}