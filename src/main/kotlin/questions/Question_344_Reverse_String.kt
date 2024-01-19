package questions


class Question_344_Reverse_String {

    companion object {

        fun runQuestion() {
//            Input: s = ["h","e","l","l","o"]
//            Output: ["o","l","l","e","h"]
            val s = charArrayOf('h', 'e', 'l', 'l', 'o')
            val result = reverseString(s)
            println("Question 621: ${s.joinToString()}")
        }

        fun reverseString(s: CharArray): Unit {
            s.reverse()
        }
    }
}