package questions

import kotlin.math.max

class Question_424_Longest_Repeating_Character_Replacement {

    companion object {

        fun runQuestion() {
//            Input: s = "AABABBA", k = 1
//            Output: 4
            val s = "AABABBA"
            val k = 1
            val result = characterReplacement(s, k)
            println("Question 2522: $result")
        }

        fun characterReplacement(s: String, k: Int): Int {
            val record = IntArray(26) { 0 }
            var maxOriginalCount = 0
            var start = 0
            var maxResult = 0
            for (end in 0..s.length - 1) {
                // println("s[$end] = ${s[end]}, s[$start] = ${s[start]}, maxOriginalCount = $maxOriginalCount, maxResult = $maxResult")
                record[s[end] - 'A']++
                maxOriginalCount = max(maxOriginalCount, record[s[end] - 'A'])
                if ((end - start + 1) - maxOriginalCount > k) {
                    record[s[start] - 'A']--
                    start++
                }
                maxResult = max(maxResult, end - start + 1)
            }
            return maxResult
        }
    }
}