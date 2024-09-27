package questions

class Question_70_Climbing_Stairs {

    companion object {

        fun runQuestion() {
//            Input: n = 45
//            Output: 1836311903
            val input = 45
            val result = climbStairs(input)
            println("Question 70: $result")
        }

        fun climbStairs(n: Int): Int {
            val result = IntArray(n + 1) { 0 }
            result[0] = 1
            for (i in 1..result.size - 1) {
                var count = 0
                for (j in 1..2) {
                    if (i - j < 0) {
                        continue
                    }
                    count += result[i - j]
                }
                result[i] = count
            }
            return result[result.size - 1]
        }

        fun climbStairsOldSolution(n: Int): Int {
            if (n <= 2) {
                return n
            }
            val record: MutableList<Int> = MutableList(n + 1) { -1 }
            record[0] = 0
            record[1] = 1
            record[2] = 2
            for (count in 3..n) {
                record[count] = record[count - 1] + record[count - 2]
            }
            return record[n]
        }

        fun climbStairsDp(n: Int): Int {
            val record: MutableList<Int> = MutableList(n + 1) { -1 }
            record[0] = 0
            record[1] = 1
            record[2] = 2
            return dp(n, record)
        }

        fun dp(n: Int, record: MutableList<Int>): Int {
            if (n == 0) {
                return 0
            }
            if (n == 1) {
                return 1
            }
            if (n == 2) {
                return 2
            }
            if (record[n] != -1) {
                return record[n]
            }
            record[n] = dp(n - 1, record) + dp(n - 2, record)
            return record[n]
        }
    }
}