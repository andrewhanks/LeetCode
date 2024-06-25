package questions

import kotlin.math.max

class Question_525_Contiguous_Array {

    companion object {

        fun runQuestion() {
//            Input: nums = [0,0,1,0,0,0,1,1]
//            Output: 6
            val array = intArrayOf(0, 0, 1, 0, 0, 0, 1, 1)
            val result = findMaxLength(array)
            println("Question 525: $result")
        }

        fun findMaxLength(nums: IntArray): Int {
            val map: MutableMap<Int, MutableList<Int>> = mutableMapOf()
            val result = IntArray(nums.size + 1) { 0 }
            map.put(0, mutableListOf(0))
            for (count in 0..nums.size - 1) {
                result[count + 1] = if (nums[count] == 0) {
                    result[count] - 1
                } else {
                    result[count] + 1
                }
                if (!map.contains(result[count + 1])) {
                    map.put(result[count + 1], mutableListOf(count + 1))
                } else {
                    map[result[count + 1]]!!.add(count + 1)
                }
            }
            var max = 0
            for ((key, value) in map) {
                max = max(max, value[value.size - 1] - value[0])
            }
            return max
        }
    }
}