package questions

class Question_58_Length_of_Last_Word {

    companion object {

        fun runQuestion() {
//            Input: s = "   fly me   to   the moon  "
//            Output: 4
            val s = "   fly me   to   the moon  "
            val result = lengthOfLastWord(s)
            println("Question 58: $result")
        }

        fun lengthOfLastWord(s: String): Int {
            val result = s.split(" ")
            for (count in result.size - 1 downTo 0) {
                val length = result[count].length
                if (length != 0) {
                    return length
                }
            }
            return 0
        }
    }
}