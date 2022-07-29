package questions

class Question_22_Generate_Parentheses {

    companion object {

        fun runQuestion22() {
            val input = 3
            val resultList = generateParenthesisWebSolution(input)
            var result = "["
            resultList.forEachIndexed { index, string ->
                result += "\""
                result += string
                if (index == resultList.size - 1) {
                    result += "\"]"
                } else {
                    result += "\","
                }
            }
            println("Question 22: $result")
        }

        private val mResultString = ArrayList<String>()

        fun generateParenthesis(n: Int): List<String> {

            for (count in 0..2) {
                printParenthesis("()", n - 1, count)
            }

            println("resultString size = ${mResultString.size}")

            return mResultString
        }

        private fun printParenthesis(completedParenthesis: String, n: Int, insertPosition: Int) {
            if (0 == n) {
                if (!mResultString.contains(completedParenthesis)) {
                    mResultString.add(completedParenthesis)
                }
                return
            }
            val tempParenthesis = completedParenthesis.substring(0, insertPosition) + "()" +
                    completedParenthesis.substring(insertPosition, completedParenthesis.length)
            for (count in 0..tempParenthesis.length) {
                printParenthesis(tempParenthesis, n - 1, count)
            }
        }

        fun generateParenthesisWebSolution(n: Int): List<String> {
            val list = ArrayList<String>()
            backtrack(list, "", 0, 0, n)
            System.out.println("list size = ${list.size}")
            return list
        }

        fun backtrack(list: MutableList<String>, str: String, open: Int, close: Int, max: Int) {
            if (str.length == max * 2) {
                list.add(str)
                return
            }

            if (open < max) {
                backtrack(list, "$str(", open + 1, close, max)
            }
            if (close < open) {
                backtrack(list, "$str)", open, close + 1, max)
            }
        }
    }
}