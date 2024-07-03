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

        fun numDecodingsIterative(s: String): Int {
            val result = IntArray(s.length + 1) { 0 }
            result[0] = 1
            result[1] = if (s[0] == '0') {
                0
            } else {
                1
            }
            for (count in 2..result.size - 1) {
                val oneDigit = s.substring(count - 1..count - 1).toInt()
                val twoDigit = s.substring(count - 2..count - 1).toInt()
                if (oneDigit != 0) {
                    result[count] += result[count - 1]
                }
                if (twoDigit <= 26 && twoDigit >= 10) {
                    result[count] += result[count - 2]
                }
            }
            return result[result.size - 1]
        }
    }
}