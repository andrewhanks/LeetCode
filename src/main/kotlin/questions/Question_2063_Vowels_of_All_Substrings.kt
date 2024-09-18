package questions

class Question_2063_Vowels_of_All_Substrings {

    companion object {

        fun runQuestion() {
//            Input: word = "aba"
//            Output: 6
            val string = "aba"
            val result = countVowels(string)
            println("Question 2063: $result")
        }

        fun countVowels(word: String): Long {
            var ans = 0L
            for (count in 0..word.length - 1) {
                if (word[count] == 'a' || word[count] == 'e' || word[count] == 'i' || word[count] == 'o' || word[count] == 'u') {
                    ans += (count + 1).toLong() * (word.length - 1 - count + 1)
                }
            }
            return ans
        }
    }
}