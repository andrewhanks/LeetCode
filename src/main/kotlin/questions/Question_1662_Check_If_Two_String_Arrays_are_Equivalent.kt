package questions

class Question_1662_Check_If_Two_String_Arrays_are_Equivalent {

    companion object {

        fun runQuestion() {
            val word1 = arrayOf("ab", "c")
            val word2 = arrayOf("a", "bc")
            val result = arrayStringsAreEqual(word1, word2)
            println("Question 1662: $result")
        }

        fun arrayStringsAreEqual(word1: Array<String>, word2: Array<String>): Boolean {
            var concatWord1 = ""
            var concatWord2 = ""
            word1.forEach {
                concatWord1 += it
            }
            word2.forEach {
                concatWord2 += it
            }
            return concatWord1 == concatWord2
        }
    }
}