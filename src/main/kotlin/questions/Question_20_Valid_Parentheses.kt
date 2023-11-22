package questions

class Question_20_Valid_Parentheses {

    companion object {

        fun runQuestion() {
//            Input: s = "()[]{}"
//            Output: true
            val s = "()[]{}"
            val result = isValid(s)
            println("Question 20: $result")
        }

        fun isValid(s: String): Boolean {
            val result: MutableList<Char> = mutableListOf()
            for (count in 0..s.length - 1) {
                if (s[count] == '(' || s[count] == '{' || s[count] == '[') {
                    result.add(s[count])
                } else if (result.size >= 1) {
                    if (s[count] == ')' && result[result.size - 1] == '(') {
                        result.removeAt(result.size - 1)
                    } else if (s[count] == '}' && result[result.size - 1] == '{') {
                        result.removeAt(result.size - 1)
                    } else if (s[count] == ']' && result[result.size - 1] == '[') {
                        result.removeAt(result.size - 1)
                    } else {
                        return false
                    }
                } else {
                    return false
                }
            }
            if (result.isEmpty()) {
                return true
            } else {
                return false
            }
        }
    }
}