package questions

class Question_5_Longest_Palindromic_Substring {

    companion object {

        fun runQuestion() {
            val inputString = "babad"
            val result = longestPalindromeWebSolution(inputString)
            println("Question 5: $result")
        }

        // Recording whether substrings of input are Palindrome from 1 to s.length characters
        fun longestPalindromeWebSolution(s: String): String {
            if (s.isEmpty()) {
                return ""
            }
            val n = s.length
            var longestBegin = 0
            var maxLen = 1
            val table = Array(1000) { Array(1000) { false } }
            for (i in 0..n - 1) {
                table[i][i] = true
            }
            for (i in 0..n - 2) {
                if (s[i] == s[i + 1]) {
                    table[i][i + 1] = true
                    longestBegin = i
                    maxLen = 2
                }
            }
            for (len in 3..n) {
                for (i in 0..n - len) {
                    val j = i + len - 1
                    if (s[i] == s[j] && table[i + 1][j - 1]) {
                        table[i][j] = true
                        longestBegin = i
                        maxLen = len
                    }
                }
            }
            return s.substring(longestBegin, longestBegin + maxLen)
        }
    }
}