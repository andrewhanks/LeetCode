package questions

import kotlin.math.min

class Question_1758_Minimum_Changes_To_Make_Alternating_Binary_String {

    companion object {

        fun runQuestion() {
//            Input: s = "0100"
//            Output: 1
            val s = "0100"
            val result = minOperations(s)
            println("Question 1758: $result")
        }

        fun minOperations(s: String): Int {
            var temp = StringBuilder(s)
            var times = 0
            for (count in 1..temp.length - 1) {
                if (temp[count] == temp[count - 1]) {
                    if (temp[count] == '1') {
                        temp[count] = '0'
                    } else {
                        temp[count] = '1'
                    }
                    times++
                }
            }
            temp = StringBuilder(s)
            var times2 = 1
            if (temp[0] == '1') {
                temp[0] = '0'
            } else {
                temp[0] = '1'
            }
            for (count in 1..temp.length - 1) {
                if (temp[count] == temp[count - 1]) {
                    if (temp[count] == '1') {
                        temp[count] = '0'
                    } else {
                        temp[count] = '1'
                    }
                    times2++
                }
            }
            return min(times, times2)
        }
    }
}