package questions


class Question_829_Consecutive_Numbers_Sum {

    companion object {

        fun runQuestion() {
//            Input: n = 15
//            Output: 4
            val n = 15
            val result = consecutiveNumbersSum(n)
            println("Question 829: $result")
        }

        fun consecutiveNumbersSum(n: Int): Int {
            var ans = 0
            var count = 1
            while (n / count >= (count + 1) / 2) {
                if (count % 2 == 0 && (n * 2) % count == 0 && n % count != 0) {
                    ans++
                } else if (count % 2 == 1 && n % count == 0) {
                    ans++
                }
                count++
            }
            return ans
        }
    }
}