package questions

class Question_541_Reverse_String_II {

    companion object {

        fun runQuestion() {
//            Input: s = "abcdefg", k = 2
//            Output: "bacdfeg"
            val s = "abcdefg"
            val k = 2
            val result = reverseStr(s, k)
            println("Question 541: $result")
        }

        fun reverseStr(s: String, k: Int): String {
            val result: StringBuilder = StringBuilder("")
            val splitted = s.chunked(k)
            for (count in 0..splitted.size - 1) {
                if (count % 2 == 0) {
                    result.append(splitted[count].reversed())
                } else {
                    result.append(splitted[count])
                }
            }
            return result.toString()
        }
    }
}