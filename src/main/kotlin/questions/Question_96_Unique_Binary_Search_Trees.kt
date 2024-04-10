package questions

class Question_96_Unique_Binary_Search_Trees {

    companion object {

        fun runQuestion() {
//            Input: n = 3
//            Output: 5
            val n = 3
            val result = numTrees(n)
            println("Question 96: $result")
        }

        fun numTrees(n: Int): Int {
            if (n <= 1) {
                return 1
            }
            if (n == 2) {
                return 2
            }
            var sum = 0
            for (count in 1..n) {
                sum += numTrees(count - 1) * numTrees(n - count)
            }
            return sum
        }

        fun numTreesIterative(n: Int): Int {
            val result = IntArray(n + 1) { -1 }
            result[0] = 1
            result[1] = 1
            for (count in 2..n) {
                var sum = 0
                for (i in 0..count - 1) {
                    sum += result[i] * result[count - i - 1]
                }
                result[count] = sum
            }
            return result[n]
        }
    }
}