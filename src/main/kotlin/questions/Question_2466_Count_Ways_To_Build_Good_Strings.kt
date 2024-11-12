package questions


class Question_2466_Count_Ways_To_Build_Good_Strings {

    companion object {

        fun runQuestion() {
//            Input: low = 2, high = 3, zero = 1, one = 2
//            Output: 5
            val low = 2
            val high = 3
            val zero = 1
            val one = 2
            val result = countGoodStrings(low, high, zero, one)
            println("Question 2466: $result")
        }

        fun countGoodStrings(low: Int, high: Int, zero: Int, one: Int): Int {
            val mod = 1000000007
            val result = Array(2) { LongArray(high + 1) { 0L } }
            for (j in 1..result[0].size - 1) {
                if (j == zero) {
                    result[0][j] = 1
                } else if (j - zero > 0) {
                    result[0][j] = (result[0][j - zero] + result[1][j - zero]) % mod
                }
                if (j == one) {
                    result[1][j] = 1
                } else if (j - one > 0) {
                    result[1][j] = (result[1][j - one] + result[0][j - one]) % mod
                }
            }
            // println("result = ${result.contentDeepToString()}")
            var ans = 0L
            for (count in low..high) {
                ans += result[0][count]
                ans = ans % mod
                ans += result[1][count]
                ans = ans % mod
            }
            return ans.toInt()
        }
    }
}