package questions

import kotlin.math.max

class Question_1402_Reducing_Dishes {

    companion object {

        fun runQuestion() {
//            Input: satisfaction = [-1,-8,0,5,-9]
//            Output: 14
            val array = intArrayOf(-1, -8, 0, 5, -9)
            val result = maxSatisfaction(array)
            println("Question 1402: $result")
        }

        fun maxSatisfaction(satisfaction: IntArray): Int {
            satisfaction.sort()
            var ans = 0
            for (i in 0..satisfaction.size) {
                var time = 1
                var current = 0
                for (j in i..satisfaction.size - 1) {
                    current += satisfaction[j] * time
                    time++
                }
                // println("currrent = $current")
                ans = max(ans, current)
            }
            return ans
        }
    }
}