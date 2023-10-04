package questions

class Question_50_Pow {

    companion object {

        fun runQuestion() {
            val x = 2.0
            val n = -2147483648
            val result = myPow(x, n)
            println("Question 4: $result")
        }

        fun myPow(x: Double, n: Int): Double {
            if (n > 0) {
                return calculate(x, n)
            } else {
                return 1 / calculate(x, n)
            }
        }

        fun calculate(x: Double, n: Int): Double {
            if (n == 0) {
                return 1.0
            }
            val temp = calculate(x, n / 2)
            if (n % 2 != 0) {
                return temp * temp * x
            }
            return temp * temp
        }
    }
}