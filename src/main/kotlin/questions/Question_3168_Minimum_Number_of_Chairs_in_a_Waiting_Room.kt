package questions

import kotlin.math.max

class Question_3168_Minimum_Number_of_Chairs_in_a_Waiting_Room {

    companion object {

        fun runQuestion() {
//            Input: s = "ELELEEL"
//            Output: 2
            val s = "ELELEEL"
            val result = minimumChairs(s)
            println("Question 3168: $result")
        }

        fun minimumChairs(s: String): Int {
            var result = 0
            var max = 0
            for (count in 0..s.length - 1) {
                if (s[count] == 'E') {
                    result++
                } else if (s[count] == 'L') {
                    result--
                }
                max = max(max, result)
            }
            return max
        }
    }
}