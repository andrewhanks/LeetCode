package questions

import kotlin.math.min

class Question_76_Minimum_Window_Substring {

    companion object {

        fun runQuestion() {
//            Input: s = "ADOBECODEBANC", t = "ABC"
//            Output: "BANC"
            val s = "ADOBECODEBANC"
            val t = "ABC"
            val result = minWindow(s, t)
            println("Question 76: $result")
        }

        fun minWindow(s: String, t: String): String {
            val storedT = IntArray(52) { 0 }
            for (count in 0..t.length - 1) {
                storedT[getIndex(t[count])]++
            }
            val storedS = IntArray(52) { 0 }
            var start = 0
            var min = Int.MAX_VALUE
            var minStr = ""
            for (end in 0..s.length - 1) {
                storedS[getIndex(s[end])]++
                var isAllLarge = true
                for (count in 0..51) {
                    if (storedS[count] < storedT[count]) {
                        isAllLarge = false
                        break
                    }
                }
                if (isAllLarge) {
                    var startCharNum = storedS[getIndex(s[start])]
                    while ((startCharNum - 1 >= storedT[getIndex(s[start])] && storedT[getIndex(s[start])] > 0) ||
                        (storedT[getIndex(s[start])] == 0)
                    ) {
                        storedS[getIndex(s[start])]--
                        start++
                        startCharNum = storedS[getIndex(s[start])]
                    }
                    if (min > end - start + 1) {
                        minStr = s.substring(start..end)
                        min = min(min, end - start + 1)
                    }
                }
            }
            return minStr
        }

        fun getIndex(char: Char): Int {
            if (char - 'a' >= 0) {
                return char - 'a' + 26
            } else {
                return char - 'A'
            }
        }
    }
}