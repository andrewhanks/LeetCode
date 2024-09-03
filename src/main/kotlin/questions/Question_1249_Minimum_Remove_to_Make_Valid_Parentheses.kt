package questions

import java.util.*

class Question_1249_Minimum_Remove_to_Make_Valid_Parentheses {

    companion object {

        fun runQuestion() {
//            Input: s = "lee(t(c)o)de)"
//            Output: "lee(t(c)o)de"
            val s = "lee(t(c)o)de)"
            val result = minRemoveToMakeValid(s)
            println("Question 1249: $result")
        }

        fun minRemoveToMakeValid(s: String): String {
            val temp = StringBuilder(s)
            var left = 0
            var right = 0
            var count = 0
            while (count <= temp.length - 1) {
                if (temp[count] == '(') {
                    left++
                } else if (temp[count] == ')') {
                    right++
                }
                if (right > left) {
                    temp.deleteAt(count)
                    right--
                    count--
                }
                count++
            }
            left = 0
            right = 0
            count = temp.length - 1
            while (count >= 0) {
                if (temp[count] == '(') {
                    left++
                } else if (temp[count] == ')') {
                    right++
                }
                if (left > right) {
                    temp.deleteAt(count)
                    left--
                }
                count--
            }
            return temp.toString()
        }

        fun minRemoveToMakeValidWithStack(s: String): String {
            val stack: Stack<Int> = Stack()
            for (count in 0..s.length - 1) {
                if (s[count] == '(') {
                    stack.add(count)
                } else if (s[count] == ')') {
                    if (!stack.isEmpty() && s[stack.peek()] == '(') {
                        stack.removeLast()
                    } else {
                        stack.add(count)
                    }
                }
            }
            val ans = StringBuilder()
            val set = stack.toMutableSet()
            for (count in 0..s.length - 1) {
                if (!set.contains(count)) {
                    ans.append(s[count])
                }
            }
            return ans.toString()
        }
    }
}