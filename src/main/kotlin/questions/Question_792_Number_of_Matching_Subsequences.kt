package questions

class Question_792_Number_of_Matching_Subsequences {

    companion object {

        fun runQuestion() {
//            Input: s = "abcde", words = ["a","bb","acd","ace"]
//            Output: 3
            val s = "abcde"
            val words = arrayOf("a", "bb", "acd", "ace")
            val result = numMatchingSubseq(s, words)
            println("Question 792: $result")
        }

        fun numMatchingSubseq(s: String, words: Array<String>): Int {
            var ans = 0
            for (item in words) {
                if (check(s, item)) {
                    ans++
                }
            }
            return ans
        }

        fun check(s: String, word: String): Boolean {
            var i = 0
            var j = 0
            while (i <= s.length - 1 && j <= word.length - 1) {
                if (s[i] != word[j]) {
                    i++
                } else {
                    i++
                    j++
                    if (j > word.length - 1) {
                        return true
                    }
                }
            }
            return false
        }
    }
}