package questions

import kotlin.math.min

class Question_1638_Count_Substrings_That_Differ_by_One_Character {

    companion object {

        fun runQuestion() {
//            Input: s = "aba", t = "baba"
//            Output: 6
            val s = "aba"
            val t = "baba"
            val result = countSubstrings(s, t)
            println("Question 1638: $result")
        }

        fun countSubstrings(s: String, t: String): Int {
            var ans = 0
            val min = min(s.length, t.length)
            for (i in 1..min) {
                for (j in 0..s.length - i) {
                    for (k in 0..t.length - i) {
                        val subs = s.substring(j..j + i - 1)
                        val subt = t.substring(k..k + i - 1)
                        if (check(subs, subt)) {
                            ans++
                        }
                    }
                }
            }
            return ans
        }

        fun check(subs: String, subt: String): Boolean {
            var diffCount = 0
            for (i in 0..subs.length - 1) {
                if (subs[i] != subt[i]) {
                    diffCount++
                }
            }
            return if (diffCount == 1) {
                true
            } else {
                false
            }
        }
    }
}