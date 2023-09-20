package questions

import kotlin.math.max

class Question_1143_Longest_Common_Subsequence {

    companion object {

        fun runQuestion() {
            val string1 = "pmjghexybyrgzczy"
            val string2 = "hafcdqbgncrcbihkd"
            val result = longestCommonSubsequence(string1, string2)
            println("Question 1143: $result")
        }

        fun longestCommonSubsequence(text1: String, text2: String): Int {
            val resultArray = Array(text1.length) { Array(text2.length) { 0 } }
            for (x in 0..text1.length - 1) {
                for (y in 0..text2.length - 1) {
                    if (text2[y] == text1[x]) {
                        if (x - 1 >= 0 && y - 1 >= 0) {
                            resultArray[x][y] = resultArray[x - 1][y - 1] + 1
                        } else {
                            resultArray[x][y] = 1
                        }
                    } else {
                        var text2Minus = 0
                        if (y - 1 >= 0) {
                            text2Minus = resultArray[x][y - 1]
                        }
                        var text1Minus = 0
                        if (x - 1 >= 0) {
                            text1Minus = resultArray[x - 1][y]
                        }
                        resultArray[x][y] = max(text2Minus, text1Minus)
                    }
                }
            }
            return resultArray[text1.length - 1][text2.length - 1]
        }

        fun longestCommonSubsequenceDp(text1: String, text2: String): Int {
//            println("text1 = $text1, text2 = $text2")
            if (text1.length < 1 || text2.length < 1) {
                return 0
            } else if (text1[text1.length - 1] == text2[text2.length - 1]) {
//                println(text1[text1.length-1])
                if (text2.length - 2 >= 0 && text1.length - 2 >= 0) {
                    return 1 + longestCommonSubsequence(
                        text1.substring(0, text1.length - 1),
                        text2.substring(0, text2.length - 1)
                    )
                } else {
                    return 1
                }
            } else {
                var text2Minus = 0
                if (text2.length - 2 >= 0) {
                    text2Minus = longestCommonSubsequence(text1, text2.substring(0, text2.length - 1))
                }
                var text1Minus = 0
                if (text1.length - 2 >= 0) {
                    text1Minus = longestCommonSubsequence(text1.substring(0, text1.length - 1), text2)
                }
                return max(text2Minus, text1Minus)
            }
        }
    }
}