package questions

import kotlin.math.abs
import kotlin.math.max

class Question_1073_Adding_Two_Negabinary_Numbers {

    companion object {

        fun runQuestion() {
//            Input: arr1 = [1,1,1,1,1], arr2 = [1,0,1]
//            Output: [1,0,0,0,0]
            val arr1 = intArrayOf(1, 1, 1, 1, 1)
            val arr2 = intArrayOf(1, 0, 1)
            val result = addNegabinary(arr1, arr2)
            println("Question 1073: ${result.contentToString()}")
        }

        fun addNegabinary(arr1: IntArray, arr2: IntArray): IntArray {
            arr1.reverse()
            arr2.reverse()
            var carry = 0
            val result: MutableList<Int> = mutableListOf()
            for (i in 0..max(arr1.size, arr2.size) - 1) {
                val a = if (i <= arr1.size - 1) {
                    arr1[i]
                } else {
                    0
                }
                val b = if (i <= arr2.size - 1) {
                    arr2[i]
                } else {
                    0
                }
                result.add(0, abs(a + b + carry) % (-2))
                if (a + b + carry >= 2) {
                    carry = -1
                } else if (a + b + carry < 0) {
                    carry = 1
                } else {
                    carry = 0
                }
            }
            while (carry != 0) {
                result.add(0, abs(carry) % (-2))
                if (carry >= 2) {
                    carry = -1
                } else if (carry < 0) {
                    carry = 1
                } else {
                    carry = 0
                }
            }
            var i = 0
            while (i <= result.size - 1) {
                if (result[i] == 1) {
                    break
                }
                if (result[i] == 0 && i != result.size - 1) {
                    result.removeAt(i)
                    i--
                }
                i++
            }
            return result.toIntArray()
        }
    }
}