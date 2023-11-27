package questions

import kotlin.math.max
import kotlin.math.min

class Question_1884_Egg_Drop_With_2_Eggs_and_N_Floors {

    companion object {

        fun runQuestion() {
//            Input: n = 100
//            Output: 14
            val n = 100
            val result = twoEggDrop(n)
            println("Question 1884: $result")
        }

        fun twoEggDrop(n: Int): Int {
            val result: Array<IntArray> = Array(2) { IntArray(n + 1) { 0 } }
            for (count in 1..n) {
                result[0][count] = count
            }
            for (x in 1..n) {
                var min = Int.MAX_VALUE
                for (y in 1..x) {
                    min = min(min, 1 + max(result[0][y - 1], result[1][x - y]))
                }
                result[1][x] = min
                //println("result[1][$x] = ${result[1][x]}")
            }
            return result[1][n]
        }
    }
}