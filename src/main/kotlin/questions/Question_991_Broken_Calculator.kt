package questions

class Question_991_Broken_Calculator {

    companion object {

        fun runQuestion991() {
            val number1 = 2
            val number2 = 3
            val result = brokenCalc(number1, number2).toString()
            println("Question 991: $result")
        }

        fun brokenCalc(startValue: Int, target: Int): Int {
            return when {
                target < startValue -> {
                    startValue - target
                }

                target == startValue -> {
                    0
                }

                else -> {
                    if (target % 2 == 0) {
                        brokenCalc(startValue, target / 2) + 1
                    } else {
                        brokenCalc(startValue, target + 1) + 1
                    }
                }
            }
        }
    }
}