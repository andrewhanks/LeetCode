package questions

import kotlin.math.min

class Question_72_Edit_Distance {

    companion object {

        fun runQuestion() {
//            Input: word1 = "horse", word2 = "ros"
//            Output: 3
            val word1 = "horse"
            val word2 = "ros"
            val result = minDistance(word1, word2)
            println("Question 72: $result")
        }

        fun minDistance(word1: String, word2: String): Int {
            val result: Array<IntArray> = Array(word1.length + 1) { IntArray(word2.length + 1) { 0 } }
            for (x in 0..word1.length) {
                result[x][0] = x
            }
            for (y in 0..word2.length) {
                result[0][y] = y
            }
            for (x in 1..word1.length) {
                for (y in 1..word2.length) {
                    if (word1[x - 1] == word2[y - 1]) {
                        result[x][y] = result[x - 1][y - 1]
                    } else {
                        val insert = result[x - 1][y] + 1
                        val delete = result[x][y - 1] + 1
                        val replace = result[x - 1][y - 1] + 1
                        result[x][y] = min(min(insert, delete), replace)
                    }
                }
            }
            return result[word1.length][word2.length]
        }

        fun minDistanceDp(word1: String, word2: String): Int {
            return dp(word1, word2)
        }

        fun dp(word1: String, word2: String): Int {
            if (word1.length <= 0) {
                return word2.length
            } else if (word2.length <= 0) {
                return word1.length
            }
            if (word1[0] == word2[0]) {
                return dp(word1.substring(1..word1.length - 1), word2.substring(1..word2.length - 1))
            }
            val insert = dp(word1, word2.substring(1..word2.length - 1)) + 1
            val delete = dp(word1.substring(1..word1.length - 1), word2) + 1
            val replace = dp(word1.substring(1..word1.length - 1), word2.substring(1..word2.length - 1)) + 1
            return min(min(insert, delete), replace)
        }
    }
}