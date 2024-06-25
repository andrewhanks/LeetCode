package questions

import java.util.*

class Question_394_Decode_String {

    companion object {

        fun runQuestion() {
//            Input: s = "3[a2[c]]"
//            Output: "accaccacc"
            val s = "3[a2[c]]"
            val result = decodeString(s)
            println("Question 394: $result")
        }

        fun decodeString(s: String): String {
            val count: Stack<Int> = Stack()
            val string: Stack<StringBuilder> = Stack()
            var current = StringBuilder()
            var total = 0
            for (ch in s) {
                if (ch.isDigit()) {
                    total = total * 10 + (ch - '0')
                } else if (ch == '[') {
                    count.add(total)
                    string.add(current)
                    total = 0
                    current = StringBuilder()
                } else if (ch == ']') {
                    val times = count.removeLast()
                    val decode = string.removeLast()
                    for (count in 0..times - 1) {
                        decode.append(current)
                    }
                    current = decode
                } else {
                    current.append(ch)
                }
            }
            return current.toString()
        }
    }
}