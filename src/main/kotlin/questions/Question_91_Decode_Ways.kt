package questions

class Question_91_Decode_Ways {

    companion object {

        fun runQuestion() {
//            Input: s = "226"
//            Output: 3
            val input = "226"
            val result = numDecodings(input)
            println("Question 91: $result")
        }

        fun numDecodings(s: String): Int {
            val result = IntArray(s.length) { -1 }
            val ret = dp(s, result, 0)
            // println(result.contentToString())
            return ret
        }

        fun dp(s: String, result: IntArray, index: Int): Int {
            if (index >= s.length - 1) {
                if (index == s.length - 1 && s[index] == '0') {
                    return 0
                } else {
                    return 1
                }
            }
            if (s[index] == '0') {
                return 0
            }
            if (result[index] != -1) {
                return result[index]
            }
            if (s[index] - '1' == 0 || (s[index] - '2' == 0 && s[index + 1] - '6' <= 0)) {
                result[index] = dp(s, result, index + 1) + dp(s, result, index + 2)
                return result[index]
            } else {
                result[index] = dp(s, result, index + 1)
                return result[index]
            }
        }
    }
}