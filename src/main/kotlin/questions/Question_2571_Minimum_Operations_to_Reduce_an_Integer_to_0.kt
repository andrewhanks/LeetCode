package questions

import kotlin.math.abs
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