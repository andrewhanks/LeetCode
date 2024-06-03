package questions

import kotlin.math.min

class Question_132_Palindrome_Partitioning_II {

    companion object {

        fun runQuestion() {
//            Input: s = "aab"
//            Output: 1
            val s = "aab"
            val result = minCut(s)
            println("Question 132: $result")
        }

        fun minCut(s: String): Int {
            val result = Array(s.length) { IntArray(s.length) { Int.MAX_VALUE } }
            return getPalindrome(s, 0, s.length - 1, result)
        }

        fun getPalindrome(s: String, start: Int, end: Int, result: Array<IntArray>): Int {
            if (result[start][end] != Int.MAX_VALUE) {
                return result[start][end]
            }
            val string = s.substring(start..end)
            if (check(string)) {
                return 0
            }
            for (count in start..end) {
                val substring = s.substring(start..count)
                if (check(substring)) {
                    result[start][end] = min(
                        result[start][end],
                        getPalindrome(s, start, count, result) + getPalindrome(s, count + 1, end, result) + 1
                    )
                }
            }
            return result[start][end]
        }

        fun check(substring: String): Boolean {
            var i = 0
            var j = substring.length - 1
            while (i < j) {
                if (substring[i] != substring[j]) {
                    return false
                }
                i++
                j--
            }
            return true
        }
    }
}