package questions

class Question_647_Palindromic_Substrings {

    companion object {

        fun runQuestion() {
//            Input: s = "aaa"
//            Output: 6
            val s = "aaa"
            val result = countSubstrings(s)
            println("Question 647: $result")
        }

        fun countSubstrings(s: String): Int {
            var count = 0
            for (i in 0..s.length - 1) {
                for (j in 0..i) {
                    val temp = s.substring(j..i)
                    if (check(temp)) {
                        count++
                    }
                }
            }
            return count
        }

        fun check(s: String): Boolean {
            var i = 0
            var j = s.length - 1
            while (i < j) {
                if (s[i] != s[j]) {
                    return false
                }
                i++
                j--
            }
            return true
        }
    }
}