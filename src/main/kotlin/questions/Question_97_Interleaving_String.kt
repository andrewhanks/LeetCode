package questions

class Question_97_Interleaving_String {

    companion object {

        fun runQuestion() {
//            Input: s1 = "aabcc", s2 = "dbbca", s3 = "dbbca"
//            Output: true
            val s1 = "aabcc"
            val s2 = "dbbca"
            val s3 = "dbbca"
            val result = isInterleave(s1, s2, s3)
            println("Question 97: $result")
        }

        fun isInterleave(s1: String, s2: String, s3: String): Boolean {
            val result: Array<IntArray> = Array(s1.length + 1) { IntArray(s2.length + 1) { -1 } }
            val final = dpWith2DArray(s1, s2, s3, s1.length, s2.length, s3.length, result)
            if (final == 1) {
                return true
            } else {
                return false
            }
        }

        fun dpWith2DArray(
            s1: String,
            s2: String,
            s3: String,
            s1Length: Int,
            s2Length: Int,
            s3Length: Int,
            result: Array<IntArray>
        ): Int {
            if (s1Length == 0 && s2Length == 0 && s3Length == 0) {
                return 1
            }
            if (result[s1Length][s2Length] != -1) {
                return result[s1Length][s2Length]
            }
            val a = if (s1Length >= 1 && s3Length >= 1 && s1[s1Length - 1] == s3[s3Length - 1]) {
                dpWith2DArray(s1, s2, s3, s1Length - 1, s2Length, s3Length - 1, result)
            } else {
                0
            }
            val b = if (s2Length >= 1 && s3Length >= 1 && s2[s2Length - 1] == s3[s3Length - 1]) {
                dpWith2DArray(s1, s2, s3, s1Length, s2Length - 1, s3Length - 1, result)
            } else {
                0
            }
            result[s1Length][s2Length] = if (a == 1 || b == 1) {
                1
            } else {
                0
            }
            return result[s1Length][s2Length]
        }

        fun isInterleaveWith1DArray(s1: String, s2: String, s3: String): Boolean {
            if (s1.length + s2.length != s3.length) {
                return false
            }
            val dp = BooleanArray(s2.length + 1)
            for (i in 0..s1.length) {
                for (j in 0..s2.length) {
                    if (i == 0 && j == 0) {
                        dp[j] = true
                    } else if (i == 0) {
                        dp[j] = dp[j - 1] && s2[j - 1] == s3[i + j - 1]
                    } else if (j == 0) {
                        dp[j] = dp[j] && s1[i - 1] == s3[i + j - 1]
                    } else {
                        dp[j] = dp[j] && s1[i - 1] == s3[i + j - 1] || dp[j - 1] && s2[j - 1] == s3[i + j - 1]
                    }
                }
            }
            return dp[s2.length]
        }

        fun isInterleaveDp(s1: String, s2: String, s3: String): Boolean {
            return dp(s1, s2, s3)
        }

        fun dp(s1: String, s2: String, s3: String): Boolean {
            if (s3.length == 0 && s1.length == 0 && s2.length == 0) {
                return true
            } else if (s3.length == 0 && (s1.length != 0 || s2.length != 0)) {
                return false
            }
            if ((s1.length >= 1 && s1[0] == s3[0]) && (s2.length >= 1 && s2[0] == s3[0])) {
                return dp(s1.substring(1..s1.length - 1), s2, s3.substring(1..s3.length - 1)) ||
                        dp(s1, s2.substring(1..s2.length - 1), s3.substring(1..s3.length - 1))
            } else if (s1.length >= 1 && s1[0] == s3[0]) {
                return dp(s1.substring(1..s1.length - 1), s2, s3.substring(1..s3.length - 1))
            } else if (s2.length >= 1 && s2[0] == s3[0]) {
                return dp(s1, s2.substring(1..s2.length - 1), s3.substring(1..s3.length - 1))
            } else {
                return false
            }
        }
    }
}