package questions


class Question_2048_Next_Greater_Numerically_Balanced_Number {

    companion object {

        fun runQuestion() {
//            Input: n = 1000000
//            Output: 1224444
            val n = 1000000
            val result = nextBeautifulNumber(n)
            println("Question 2048: $result")
        }

        fun nextBeautifulNumber(n: Int): Int {
            for (i in n + 1..1300000) {
                if (isBalanced(i)) {
                    return i
                }
            }
            return -1
        }

        fun isBalanced(n: Int): Boolean {
            val digits = IntArray(10) { 0 }
            var temp = n
            while (temp > 0) {
                val rest = temp % 10
                if (rest == 0) {
                    return false
                }
                digits[rest]++
                if (digits[rest] > temp % 10) {
                    return false
                }
                temp = temp / 10
            }
            for (i in 1..digits.size - 1) {
                if (digits[i] != 0 && digits[i] != i) {
                    return false
                }
            }
            return true
        }
    }
}