package questions

import kotlin.math.max

class Question_3_Longest_Substring_Without_Repeating_Characters {

    companion object {

        fun runQuestion() {
//            Input: s = "abcabcbb"
//            Output: 3
            val inputString = "abcabcbb"
            val result = lengthOfLongestSubstring(inputString)
            println("Question 3: $result")
        }

        fun lengthOfLongestSubstring(s: String): Int {
            if (s.length == 0) {
                return 0
            }
            var start = 0
            var end = 0
            var max = 0
            for (count in 1..s.length - 1) {
                val string = s.substring(start..count - 1)
                if (!string.contains(s[count])) {
                    end++
                } else {
                    max = max(max, end - start + 1)
                    start = s.substring(0..count - 1).lastIndexOf(s[count]) + 1
                    // println("start = $start")
                    end = count
                }
            }
            max = max(max, end - start + 1)
            return max
        }

        fun lengthOfLongestSubstringOldSolution(s: String): Int {
            var position = 0
            var length = 0
            if (s.length <= 1) {
                return s.length
            }
            var temp = s[0].toString()
            for (count in 1 until s.length) {
                var isRepeated = false
                var repeatPosition = 0
                for (n in 0 until temp.length) {
                    if (s[count] == temp[n]) {
                        isRepeated = true
                        repeatPosition = n
                    }
                }
                if (isRepeated) {
                    if (length < temp.length) {
                        length = temp.length
                        position = count - 1
                    }
                    if (repeatPosition < temp.length - 1) {
                        temp = temp.substring(repeatPosition + 1) + s[count].toString()
                    } else {
                        temp = s[count].toString()
                    }
                } else {
                    temp = temp + s[count].toString()
                    if (count == s.length - 1) {
                        if (length < temp.length) {
                            length = temp.length
                            position = count
                        }
                    }
                }
            }

            return length
        }
    }
}