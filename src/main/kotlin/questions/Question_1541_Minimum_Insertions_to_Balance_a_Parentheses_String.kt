package questions

import java.util.*

class Question_1541_Minimum_Insertions_to_Balance_a_Parentheses_String {

    companion object {

        fun runQuestion() {
//            Input: s = "))())("
//            Output: 3
            val s = "))())("
            val result = minInsertions(s)
            println("Question 1541: $result")
        }

        fun minInsertions(s: String): Int {
            val stack: Stack<Char> = Stack()
            var ans = 0
            for (i in 0..s.length - 1) {
                if (s[i] == '(') {
                    if (!stack.isEmpty() && stack.peek() == '*') {
                        ans++
                        stack.pop()
                    }
                    stack.add(s[i])
                } else {
                    if (stack.isEmpty()) {
                        ans++
                        stack.add('(')
                    }
                    if (stack.peek() == '(') {
                        stack.pop()
                        stack.add('*')
                    } else {
                        stack.pop()
                    }
                }
            }
            while (!stack.isEmpty()) {
                val ch = stack.pop()
                if (ch == '*') {
                    ans++
                } else if (ch == '(') {
                    ans = ans + 2
                }
            }
            return ans
        }

        fun minInsertionsByCounting(s: String): Int {
            var count = 0
            var ans = 0
            var i = 0
            while (i <= s.length - 1) {
                if (s[i] == '(') {
                    count++
                } else {
                    if (i + 1 <= s.length - 1 && s[i + 1] == ')') {
                        count--
                        i++
                    } else {
                        ans++
                        count--
                    }
                }
                if (count < 0) {
                    ans -= count
                    count = 0
                }
                i++
            }
            if (count > 0) {
                ans += count * 2
            }
            return ans
        }
    }
}