package questions

import java.util.*
import kotlin.math.pow

class Question_2191_Sort_the_Jumbled_Numbers {

    companion object {

        fun runQuestion() {
//            Input: mapping = [8,9,4,0,2,1,3,5,7,6], nums = [991,338,38]
//            Output: [338,38,991]
            val mapping = intArrayOf(8, 9, 4, 0, 2, 1, 3, 5, 7, 6)
            val nums = intArrayOf(991, 338, 38)
            val resultList = sortJumbled(mapping, nums)
            var result = "["
            resultList.forEachIndexed { index, i ->
                result += i
                if (index == resultList.size - 1) {
                    result += "]"
                } else {
                    result += ","
                }
            }
            println("Question 2191: $result")
        }

        fun sortJumbled(mapping: IntArray, nums: IntArray): IntArray {
            val result: MutableList<MutableList<Int>> = mutableListOf()
            for (count in 0..nums.size - 1) {
                val currentChar = StringBuilder(nums[count].toString())
                var mappedValue = 0
                for (pos in 0..currentChar.length - 1) {
                    val digit = Character.getNumericValue(currentChar[pos])
                    mappedValue += (mapping[digit] * 10f.pow(currentChar.length - 1 - pos)).toInt()
                }
                result.add(mutableListOf(nums[count], mappedValue.toInt()))
            }
            val sorted = result.sortedBy { it[1] }
            val finalResult: MutableList<Int> = mutableListOf()
            for ((key, value) in sorted) {
                finalResult.add(key)
            }
            return finalResult.toIntArray()
        }
    }
}