package questions

import kotlin.math.abs

class Question_1131_Maximum_of_Absolute_Value_Expression {

    companion object {

        fun runQuestion() {
            // arr1 = [1,-2,-5,0,10], arr2 = [0,-2,-1,-7,-4]
            val numberArray1 = intArrayOf(1, -2, -5, 0, 10)
            val numberArray2 = intArrayOf(0, -2, -1, -7, -4)
            val result = maxAbsValExpr(numberArray1, numberArray2)
            println("Question 1131: $result")
        }

        fun maxAbsValExpr(arr1: IntArray, arr2: IntArray): Int {
            var maxResult = 0
            for (x in 0..arr1.size - 1) {
                for (y in x + 1..arr1.size - 1) {
                    val tempResult = abs(arr1[x] - arr1[y]) + abs(arr2[x] - arr2[y]) + abs(y - x)
                    if (tempResult > maxResult) {
                        maxResult = tempResult
                    }
                }
            }
            return maxResult
        }
    }
}