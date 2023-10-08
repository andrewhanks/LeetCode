package questions

import java.util.*

class Question_150_Evaluate_Reverse_Polish_Notation {

    companion object {

        fun runQuestion() {
//            Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
//            Output: 22
            val stringArray = arrayOf("10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+")
            val result = evalRPN(stringArray)
            println("Question 150: $result")
        }

        fun evalRPN(tokens: Array<String>): Int {
            val queue: Stack<Int> = Stack()
            tokens.forEach { value ->
                if (value.toIntOrNull() != null) {
                    queue.add(value.toInt())
                } else {
                    val secondNumber = queue.pop()
                    val firstNumber = queue.pop()
                    if (value == "+") {
                        queue.add(firstNumber + secondNumber)
                    } else if (value == "-") {
                        queue.add(firstNumber - secondNumber)
                    } else if (value == "*") {
                        queue.add(firstNumber * secondNumber)
                    } else if (value == "/") {
                        queue.add(firstNumber / secondNumber)
                    }
                }
            }
            return queue.pop()
        }
    }
}