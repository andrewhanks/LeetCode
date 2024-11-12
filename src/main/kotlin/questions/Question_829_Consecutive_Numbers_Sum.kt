package questions


class Question_829_Consecutive_Numbers_Sum {

    companion object {

        fun runQuestion() {
//            Input: n = 15
//            Output: 4
            val n = 15
            val result = consecutiveNumbersSum(n)
            println("Question 829: $result")
        }

        fun consecutiveNumbersSum(n: Int): Int {
            var ans = 0
            var count = 1
            while (n / count >= (count + 1) / 2) {
                if (count % 2 == 0 && (n * 2) % count == 0 && n % count != 0) {
                    ans++
                } else if (count % 2 == 1 && n % count == 0) {
                    ans++
                }
                count++
            }
            return ans
        }

        // k, k+1, k+2, k+3, .., k+m-1
        // (k+k+m-1)*m/2 = n
        // k = (2n-m*(m-1))/2m, k is positive integer, m is positive integer
        // m*(m-1) < 2n
        fun consecutiveNumbersSumWithMath(n: Int): Int {
            var ans = 0
            var m = 1
            while (m * (m - 1) < 2 * n) {
                if ((2 * n - m * (m - 1)) / 2 % m == 0) {
                    ans++
                }
                m++
            }
            return ans
        }
    }
}