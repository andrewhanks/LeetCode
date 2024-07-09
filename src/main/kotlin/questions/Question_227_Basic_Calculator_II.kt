package questions

import java.util.*

class Question_227_Basic_Calculator_II {

    companion object {

        fun runQuestion() {
//            Input: s = "3+2*2"
//            Output: 7
            val input = "3+2*2"
            val result = calculate(input)
            println("Question 227: $result")
        }

        fun calculate(s: String): Int {
            val temp = s.replace(" ", "")
            val stack: Stack<Int> = Stack()
            var number = 0
            var prevOp = '+'
            for (count in 0..temp.length - 1) {
                if (temp[count].isDigit()) {
                    number = number * 10 + (temp[count] - '0')
                }
                if (count == temp.length - 1 || !temp[count].isDigit()) {
                    when (prevOp) {
                        '+' -> {
                            stack.add(number)
                        }

                        '-' -> {
                            stack.add(-number)
                        }

                        '*' -> {
                            val num = stack.removeLast()
                            stack.add(num * number)
                        }

                        '/' -> {
                            val num = stack.removeLast()
                            stack.add(num / number)
                        }
                    }
                    prevOp = temp[count]
                    number = 0
                }
            }
            // println(stack)
            var ans = 0
            while (!stack.isEmpty()) {
                ans += stack.removeLast()
            }
            return ans
        }

        fun calculateUglySolution(s: String): Int {
            val temp = s.replace(" ", "")
            // println(temp)
            val numberQueue: Queue<Int> = LinkedList()
            val operationQueue: Queue<Char> = LinkedList()
            var number1 = 0
            var number2 = 0
            var operation = ' '
            // println("================================")
            for (char in temp) {
                if (char.isDigit()) {
                    if (operation == '*' || operation == '/') {
                        number2 = number2 * 10 + (char - '0')
                    } else {
                        number1 = number1 * 10 + (char - '0')
                    }
                } else {
                    if (char != ' ' && operation == '*') {
                        number1 = number1 * number2
                        number2 = 0
                        operation = ' '
                    } else if (char != ' ' && operation == '/') {
                        number1 = number1 / number2
                        number2 = 0
                        operation = ' '
                    }
                    if (char == '+') {
                        numberQueue.add(number1)
                        operationQueue.add(char)
                        number1 = 0
                    } else if (char == '-') {
                        numberQueue.add(number1)
                        operationQueue.add(char)
                        number1 = 0
                    } else if (char == '*') {
                        operation = char
                    } else if (char == '/') {
                        operation = char
                    }
                }
                // println("numberQueue = $numberQueue, operationQueue = $operationQueue")
            }
            if (operation == '*') {
                numberQueue.add(number1 * number2)
            } else if (operation == '/') {
                numberQueue.add(number1 / number2)
            } else {
                numberQueue.add(number1)
            }
            // println("numberQueue = $numberQueue, operationQueue = $operationQueue")
            var ans = numberQueue.remove()
            while (!numberQueue.isEmpty()) {
                var oper = operationQueue.remove()
                if (oper == '+') {
                    ans = ans + numberQueue.remove()
                } else if (oper == '-') {
                    ans = ans
                    ans = ans - numberQueue.remove()
                }
            }
            return ans
        }
    }
}