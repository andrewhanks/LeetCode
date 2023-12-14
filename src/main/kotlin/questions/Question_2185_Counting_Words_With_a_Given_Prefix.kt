package questions

class Question_2185_Counting_Words_With_a_Given_Prefix {

    companion object {

        fun runQuestion() {
//            Input: words = ["pay","attention","practice","attend"], pref = "at"
//            Output: 2
            val words = arrayOf("pay", "attention", "practice", "attend")
            val pref = "at"
            val result = prefixCount(words, pref)
            println("Question 2185: $result")
        }

        fun prefixCount(words: Array<String>, pref: String): Int {
            var number = 0
            words.forEach { if (it.startsWith(pref)) number++ }
            return number
        }
    }
}