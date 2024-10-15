package questions

class Question_1922_Count_Good_Numbers {

    companion object {

        fun runQuestion() {
//            Input: n = 50
//            Output: 564908303
            val n = 50L
            val result = countGoodNumbers(n)
            println("Question 1922: $result")
        }

        val mod = 1000000007
        fun countGoodNumbers(n: Long): Int {
            return (myPow(5, (n + 1) / 2) * myPow(4, n / 2) % mod).toInt()
        }

        fun myPow(base: Long, exponent: Long): Long {
            if (exponent == 0L) {
                return 1L
            }
            if (exponent == 1L) {
                return base
            }
            val value = myPow(base, exponent / 2)
            val ret = if (exponent % 2 == 1L) {
                base * value % mod * value
            } else {
                value * value
            }
            return ret % mod
        }

        fun countGoodNumbersWithIterative(n: Long): Int {
            var ans = myPowWithIterative(5, (n + 1) / 2) * myPowWithIterative(4, n / 2)
            return (ans % mod).toInt()
        }

        fun myPowWithIterative(base: Long, exponent: Long): Long {
            var ret = 1L
            var acc = base
            var currExpo = exponent
            while (currExpo != 0L) {
                if (currExpo % 2 == 1L) {
                    ret = ret * acc % mod
                }
                acc = acc * acc % mod
                currExpo = currExpo / 2
            }
            return ret
        }
    }
}