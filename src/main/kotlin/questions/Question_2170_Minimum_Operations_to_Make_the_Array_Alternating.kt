package questions

import kotlin.math.max

class Question_2170_Minimum_Operations_to_Make_the_Array_Alternating {

    companion object {

        fun runQuestion() {
//            Input: nums = [1,2,2,2,2]
//            Output: 2
            val array = intArrayOf(1, 2, 2, 2, 2)
            val result = minimumOperations(array)
            println("Question 2170: $result")
        }

        fun minimumOperations(nums: IntArray): Int {
            val oddMap: MutableMap<Int, Int> = mutableMapOf()
            val evenMap: MutableMap<Int, Int> = mutableMapOf()
            var oddTotal = 0
            var oddMax = 0
            var oddSecondMax = 0
            var evenTotal = 0
            var evenMax = 0
            var evenSecondMax = 0
            for (count in 0..nums.size - 1) {
                if (count % 2 == 1) {
                    oddMap[nums[count]] = oddMap.getOrDefault(nums[count], 0) + 1
                    oddTotal++
                    oddMax = max(oddMax, oddMap[nums[count]]!!)
                } else {
                    evenMap[nums[count]] = evenMap.getOrDefault(nums[count], 0) + 1
                    evenTotal++
                    evenMax = max(evenMax, evenMap[nums[count]]!!)
                }
            }
            val set: MutableSet<Int> = mutableSetOf()
            for ((key, value) in oddMap) {
                if (value == oddMax) {
                    set.add(key)
                }
                if (value != oddMax) {
                    oddSecondMax = max(oddSecondMax, value)
                }
            }
            for ((key, value) in evenMap) {
                if (value == evenMax) {
                    set.add(key)
                }
                if (value != evenMax) {
                    evenSecondMax = max(evenSecondMax, value)
                }
            }
            // println("oddMap = $oddMap, evenMap = $evenMap, oddMax = $oddMax, evenMax = $evenMax, oddTotal = $oddTotal, evenTotal = $evenTotal, oddSecondMax = $oddSecondMax, evenSecondMax = $evenSecondMax")
            if (set.size <= 1) {
                if (oddSecondMax >= evenSecondMax) {
                    return nums.size - (evenMax + oddSecondMax)
                } else {
                    return nums.size - (oddMax + evenSecondMax)
                }
            } else {
                return nums.size - oddMax - evenMax
            }
        }
    }
}