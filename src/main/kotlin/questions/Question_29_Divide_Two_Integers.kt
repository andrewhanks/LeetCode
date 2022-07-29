package questions

class Question_29_Divide_Two_Integers {

    companion object {

        fun runQuestion29() {
            val number1 = 10
            val number2 = 3
            val result = divide(number1, number2)
            println("Question 29: $result")
        }

        fun divide(dividend: Int, divisor: Int): Int {
            var divideTimes = 0L
            var dividendRest: Long = if (dividend < 0) {
                -(dividend.toLong())
            } else {
                dividend.toLong()
            }

            val divisorModified: Long = if (divisor < 0) {
                -(divisor.toLong())
            } else {
                divisor.toLong()
            }
            println("dividendRest = $dividendRest, divisorModified = $divisorModified")
            while (dividendRest >= divisorModified) {
                if (1L == divisorModified) {
                    divideTimes = dividendRest
                    break
                }
                if (divideTimes > Int.MAX_VALUE) {
                    break
                }
                dividendRest -= divisorModified
                divideTimes++
            }
            return if (dividend < 0) {
                if (Int.MIN_VALUE == dividend) {
                    when {
                        -1 == divisor -> {
                            Int.MAX_VALUE
                        }

                        1 == divisor -> {
                            Int.MIN_VALUE
                        }

                        0 < divisor -> {
                            -(divideTimes.toInt())
                        }

                        else -> {
                            divideTimes.toInt()
                        }
                    }
                } else {
                    if (divisor > 0) {
                        -divideTimes.toInt()
                    } else {
                        divideTimes.toInt()
                    }
                }
            } else {
                if (divisor > 0) {
                    divideTimes.toInt()
                } else {
                    -(divideTimes.toInt())
                }
            }
        }
    }
}