package questions

import java.util.*

class Question_1047_Remove_All_Adjacent_Duplicates_In_String {

    companion object {

        fun runQuestion() {
            val string = "azxxzy"
            val result = removeDuplicates(string)
            println("Question 1047: $result")
        }

        fun removeDuplicates(s: String): String {
            val stack = mutableListOf<Char>()
            s.forEachIndexed { index, value ->
                if (stack.size > 0 && stack[stack.size - 1] == value) {
                    stack.removeLast()
                } else {
                    stack.add(value)
                }
            }
            var result: String = ""
            stack.forEach { value ->
                result += value
            }
            return result
        }

        fun removeDuplicatesWithStringBuilder(s: String): String {
            val stringBuilder = StringBuilder(s)
            var count = 0
            while (count < stringBuilder.length - 1) {
                if (stringBuilder[count] == stringBuilder[count + 1]) {
                    stringBuilder.deleteAt(count)
                    stringBuilder.deleteAt(count)
                    if (count > 0) {
                        count--
                    }
                } else {
                    count++
                }
            }
            return stringBuilder.toString()
        }

        fun removeDuplicatesSlow(s: String): String {
            var tempS = s
            var removeItem = true
            while (removeItem) {
                removeItem = false
                tempS.forEachIndexed { index, value ->
                    if (index + 1 > tempS.length - 1) {
                        return@forEachIndexed
                    }
                    if (tempS[index] == tempS[index + 1]) {
                        println("tempS[index] = " + tempS[index])
                        val tempString: String = tempS[index].toString() + tempS[index + 1]
                        println("tempString = " + tempString)
                        tempS = tempS.replace(tempString, "")
                        removeItem = true
                        return@forEachIndexed
                    }
                }
            }
            return tempS
        }

        fun removeDuplicatesWithStack(s: String): String {
            val stack: Stack<Char> = Stack()
            for (count in 0..s.length - 1) {
                if (!stack.isEmpty()) {
                    if (stack.peek() == s[count]) {
                        stack.pop()
                    } else {
                        stack.add(s[count])
                    }
                } else {
                    stack.add(s[count])
                }
            }
            val result: StringBuilder = StringBuilder("")
            while (!stack.isEmpty()) {
                result.append(stack.pop())
            }
            return result.reversed().toString()
        }
    }
}