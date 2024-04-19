package questions

import kotlin.math.max

class Question_474_Ones_and_Zeroes {

    companion object {

        fun runQuestion() {
//            Input: strs = ["10","0001","111001","1","0"], m = 5, n = 3
//            Output: 4
            val strs = arrayOf("10", "0001", "111001", "1", "0")
            val m = 5
            val n = 3
            val result = findMaxForm(strs, m, n)
            println("Question 474: $result")
        }

        fun findMaxForm(strs: Array<String>, m: Int, n: Int): Int {
            val result = Array(m + 1) { Array(n + 1) { 0 } }
            for (str in strs) {
                var number0 = 0
                var number1 = 0
                for (count in 0..str.length - 1) {
                    if (str[count] == '0') {
                        number0++
                    } else {
                        number1++
                    }
                }
                for (i in m downTo number0) {
                    for (j in n downTo number1) {
                        result[i][j] = max(result[i][j], result[i - number0][j - number1] + 1)
                    }
                }
            }
            return result[m][n]
        }
    }
}