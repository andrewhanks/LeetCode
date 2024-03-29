package questions

import kotlin.math.pow

class Question_738_Monotone_Increasing_Digits {

    companion object {

        fun runQuestion() {
//            Input: n = 10
//            Output: 9
            val n = 10
            val result = monotoneIncreasingDigits(n)
            println("Question 738: $result")
        }

        fun monotoneIncreasingDigits(n: Int): Int {
            var count = n
            var list: MutableList<Int> = mutableListOf()
            var temp = count
            while (temp % 10 != 0 || temp / 10 != 0) {
                list.add(temp % 10)
                temp = temp / 10
            }
            list.reverse()
            var growLastPos = 0
            var decreasePos = -1
            for (i in 1..list.size - 1) {
                if (list[i] > list[i - 1]) {
                    growLastPos = i
                } else if (list[i] < list[i - 1]) {
                    decreasePos = i
                    break
                }
            }
            // println("growLastPos = $growLastPos, decreasePos = $decreasePos")
            if (decreasePos > 0) {
                list[growLastPos] = list[growLastPos] - 1
                for (i in growLastPos + 1..list.size - 1) {
                    list[i] = 9
                }
                var result: Double = 0.0
                for (j in 0..list.size - 1) {
                    // println("list[$j] = ${list[j]}")
                    result += list[j] * (10.toDouble().pow(list.size - 1 - j))
                }
                return result.toInt()
            }
            return count
        }
    }
}