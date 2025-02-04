package questions

import kotlin.math.pow

class Question_3315_Construct_the_Minimum_Bitwise_Array_II {

    companion object {

        fun runQuestion() {
//            Input: nums = [2,3,5,7,11,13,17,19,23,29,31]
//            Output: [-1,1,4,3,9,12,16,17,19,28,15]
            val nums = listOf(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31)
            val result = minBitwiseArray(nums)
            println("Question 3315: ${result.contentToString()}")
        }

        fun minBitwiseArray(nums: List<Int>): IntArray {
            val list: MutableList<Int> = mutableListOf()
            for (num in nums) {
                var binary = Integer.toBinaryString(num)
                if (binary.filter { it == '1' }.count() == binary.length) {
                    list.add((num - 1) / 2)
                }
                for (i in binary.length - 1 downTo 0) {
                    if (i == binary.length - 1 && binary[i] == '0') {
                        list.add(-1)
                        break
                    } else if (binary[i] == '0') {
                        val exponent = binary.length - 1 - i - 1
                        list.add(num - (2.0).pow(exponent).toInt())
                        break
                    }
                }
            }
            return list.toIntArray()
        }
    }
}