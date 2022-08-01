package questions

class Question_3_Longest_Substring_Without_Repeating_Characters {

    companion object {

        fun runQuestion() {
            val inputString = "abcabcbb"
            val result = lengthOfLongestSubstring(inputString)
            println("Question 3: $result")
        }

        fun lengthOfLongestSubstring(s: String): Int {
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