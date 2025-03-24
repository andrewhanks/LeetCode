package questions

import kotlin.math.min

class Question_2707_Extra_Characters_in_a_String {

    companion object {

        fun runQuestion() {
//            Input: s = "leetscode", dictionary = ["leet","code","leetcode"]
//            Output: 1
            val s = "leetscode"
            val dictionary = arrayOf("leet", "code", "leetcode")
            val result = minExtraChar(s, dictionary)
            println("Question 2707: $result")
        }

        fun minExtraChar(s: String, dictionary: Array<String>): Int {
            val set: MutableSet<String> = mutableSetOf()
            for (item in dictionary) {
                set.add(item)
            }
            val dp = IntArray(s.length + 1) { 0 }
            for (i in 1..dp.size - 1) {
                dp[i] = dp[i - 1] + 1
                for (j in 1..i) {
                    val substring = s.substring(i - j, i)
                    if (set.contains(substring)) {
                        dp[i] = min(dp[i], dp[i - j])
                    }
                }
            }
            return dp[dp.size - 1]
        }
    }
}