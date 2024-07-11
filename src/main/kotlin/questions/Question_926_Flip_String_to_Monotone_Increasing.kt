package questions

import kotlin.math.min

class Question_926_Flip_String_to_Monotone_Increasing {

    companion object {

        fun runQuestion() {
//            Input: s = "010110"
//            Output: 2
            val s = "010110"
            val result = minFlipsMonoIncr(s)
            println("Question 926: $result")
        }

        fun minFlipsMonoIncr(s: String): Int {
            var changeNumber = s.filter { it == '0' }.count()
            var min = changeNumber
            for (count in 0..s.length - 1) {
                if (s[count] != '1') {
                    changeNumber--
                } else {
                    changeNumber++
                }
                min = min(min, changeNumber)
            }
            return min
        }
    }
}