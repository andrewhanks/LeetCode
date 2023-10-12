package questions

class Question_151_Reverse_Words_in_a_String {

    companion object {

        fun runQuestion() {
//            Input: s = "a good   example "
//            Output: "example good a"
            val string = "a good   example "
            val result = reverseWords(string)
            println("Question 151: $result")
        }

        fun reverseWords(s: String): String {
            val temp = s.split(" ")
            var result = ""
            println(temp)
            for (count in temp.size - 1 downTo 0) {
                if (!temp[count].isEmpty()) {
                    result += temp[count]
                    result += " "
                }
            }
            return result.trim()
        }
    }
}