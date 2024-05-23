package questions

class Question_115_Distinct_Subsequences {

    companion object {

        fun runQuestion() {
//            Input: s = "babgbag", t = "bag"
//            Output: 5
            val s = "babgbag"
            val t = "bag"
            val result = numDistinct(s, t)
            println("Question 115: $result")
        }

        fun numDistinct(s: String, t: String): Int {
            val result = Array(s.length + 1) { IntArray(t.length + 1) { 0 } }
            for (count in 1..t.length) {
                result[0][count] = 0
            }
            for (count in 0..s.length) {
                result[count][0] = 1
            }
            for (i in 1..s.length) {
                for (j in 1..t.length) {
                    if (s[i - 1] == t[j - 1]) {
                        result[i][j] = result[i - 1][j - 1] + result[i - 1][j]
                    } else {
                        result[i][j] = result[i - 1][j]
                    }
                }
            }
            return result[s.length][t.length]
        }
    }
}