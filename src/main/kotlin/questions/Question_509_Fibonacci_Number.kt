package questions

class Question_509_Fibonacci_Number {

    companion object {

        fun runQuestion() {
//            Input: n = 4
//            Output: 3
            val n = 4
            val result = fibIterative(n)
            println("Question 509: $result")
        }

        fun fibIterative(n: Int): Int {
            val result: MutableList<Int> = mutableListOf()
            for (count in 0..n) {
                if (count == 0) {
                    result.add(0)
                } else if (count == 1) {
                    result.add(1)
                } else {
                    result.add(result[count - 1] + result[count - 2])
                }
            }
            return result[result.size - 1]
        }

        fun fibRecursive(n: Int): Int {
            if (n == 0) {
                return 0
            }
            if (n == 1) {
                return 1
            }
            return fibRecursive(n - 1) + fibRecursive(n - 2)
        }
    }
}