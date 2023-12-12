package questions

import kotlin.math.sign

class Question_2381_Shifting_Letters_II {

    companion object {

        fun runQuestion() {
//            Input: s = "dztz", shifts = [[0,0,0],[1,1,1]]
//            Output: "catz"
            val s = "dztz"
            val intArray1 = intArrayOf(0, 0, 0)
            val intArray2 = intArrayOf(1, 1, 1)
            val shifts = arrayOf(intArray1, intArray2)
            val result = shiftingLetters(s, shifts)
            println("Question 2381: $result")
        }

        fun shiftingLetters(s: String, shifts: Array<IntArray>): String {
            val result = StringBuilder(s)
            val temp = IntArray(s.length) { 0 }
            for (count in 0..shifts.size - 1) {
                val start = shifts[count][0]
                val end = shifts[count][1]
                val dir = shifts[count][2]
                if (dir == 0) {
                    for (count in start..end) {
                        temp[count]--
                    }
                } else {
                    for (count in start..end) {
                        temp[count]++
                    }
                }
            }
            for (count in 0..result.length - 1) {
                var newChar = ((result[count] - 'a') + temp[count]) % 26
                if (newChar < 0) {
                    newChar += 26
                }
                result[count] = (newChar.toInt() + 'a'.toInt()).toChar()
            }
            return result.toString()
        }
    }
}