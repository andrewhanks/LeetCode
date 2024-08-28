package questions

import kotlin.math.abs
import kotlin.math.min
import kotlin.math.pow

class Question_2571_Minimum_Operations_to_Reduce_an_Integer_to_0 {

    companion object {

        fun runQuestion() {
//            Input: n = 39
//            Output: 3
            val n = 39
            val result = minOperations(n)
            println("Question 2571: $result")
        }

        fun minOperations(n: Int): Int {
            return calculate(n)
        }

        fun calculate(n: Int): Int {
            var preValue = 1
            var curValue = 1
            while (curValue <= n) {
                preValue = curValue
                curValue *= 2
            }
            val minDiff = min(n - preValue, curValue - n)
            if (minDiff == 0) {
                return 1
            } else {
                return calculate(minDiff) + 1
            }
        }

        fun minOperationsIterative(n: Int): Int {
            var result = n
            var operation = 0
            while (result != 0) {
                var power = 0
                var temp = result
                while (temp > abs(result - 2f.pow(power).toInt())) {
                    val currentTemp = result - 2f.pow(power).toInt()
                    println("power = $power, temp = $temp, 2f.pow(power) = ${2f.pow(power)}, currentTemp = ${currentTemp}")
                    temp = abs(currentTemp)
                    power++
                }
                result = temp
                println("result = $result")
                operation++
            }
            return operation
        }
    }
}