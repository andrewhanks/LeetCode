package questions

import kotlin.math.pow

class Question_1849_Splitting_a_String_Into_Descending_Consecutive_Values {

    companion object {

        fun runQuestion() {
//            Input: s = "050043"
//            Output: true
            val s = "050043"
            val result = splitString(s)
            println("Question 1849: $result")
        }

        fun splitString(s: String): Boolean {
            val max = ((2.0).pow(s.length - 1) - 1).toInt()
            for (i in 1..max) {
                var binary = Integer.toBinaryString(i)
                while (binary.length < s.length) {
                    binary = "0" + binary
                }
                val numbers: MutableList<Long> = mutableListOf()
                var currentPart = ""
                var current = 0L
                // println("binary = $binary")
                for (j in 0..binary.length - 1) {
                    if (currentPart == "") {
                        currentPart = binary[j].toString()
                        current = s[j].digitToInt().toLong()
                    } else if (currentPart == binary[j].toString()) {
                        current = current * 10 + s[j].digitToInt()
                    } else {
                        numbers.add(current)
                        currentPart = binary[j].toString()
                        current = s[j].digitToInt().toLong()
                    }
                }
                numbers.add(current)
                if (check(numbers)) {
                    return true
                }
            }
            return false
        }

        fun check(numbers: MutableList<Long>): Boolean {
            // println("numbers = $numbers")
            for (i in 1..numbers.size - 1) {
                if (numbers[i - 1] - numbers[i] != 1L) {
                    return false
                }
            }
            return true
        }
    }
}