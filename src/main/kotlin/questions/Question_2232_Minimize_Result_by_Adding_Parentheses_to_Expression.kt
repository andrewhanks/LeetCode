package questions

class Question_2232_Minimize_Result_by_Adding_Parentheses_to_Expression {

    companion object {

        fun runQuestion() {
//            Input: expression = "247+38"
//            Output: "2(47+38)"
            val expression = "247+38"
            val result = minimizeResult(expression)
            println("Question 2232: $result")
        }

        fun minimizeResult(expression: String): String {
            var leftPos = 1
            var rightPos = 1
            val num1 = expression.split("+")[0]
            val num2 = expression.split("+")[1]
            var min = Int.MAX_VALUE
            for (i in 0..num1.length - 1) {
                var number1 = if (i >= 1) {
                    num1.substring(0..i - 1).toInt()
                } else {
                    1
                }
                var number2 = num1.substring(i..num1.length - 1).toInt()
                for (j in 1..num2.length) {
                    var number3 = num2.substring(0..j - 1).toInt()
                    var number4 = if (j <= num2.length - 1) {
                        num2.substring(j..num2.length - 1).toInt()
                    } else {
                        1
                    }
                    val result = number1 * (number2 + number3) * number4
                    // println("number1 = $number1, number2 = $number2, number3 = $number3, number4 = $number4, result = $result, min = $min")
                    if (result < min) {
                        min = result
                        leftPos = i
                        rightPos = num1.length + j + 2
                    }
                }
            }
            val ans = StringBuilder(expression)
            ans.insert(leftPos, "(")
            ans.insert(rightPos, ")")
            return ans.toString()
        }
    }
}