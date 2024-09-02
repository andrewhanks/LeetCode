package questions


class Question_1155_Number_of_Dice_Rolls_With_Target_Sum {

    companion object {

        fun runQuestion() {
//            Input: n = 30, k = 30, target = 500
//            Output: 222616187
            val n = 30
            val k = 30
            val target = 500
            val result = numRollsToTarget(n, k, target)
            println("Question 1155: $result")
        }

        fun numRollsToTarget(n: Int, k: Int, target: Int): Int {
            val result = Array(n + 1) { IntArray(target + 1) { -1 } }
            return calculate(n, k, target, result)
        }

        fun calculate(n: Int, k: Int, target: Int, result: Array<IntArray>): Int {
            val mod = 1000000007
            if (n < 0 || target < 0) {
                return 0
            }
            if (n == 0 && target == 0) {
                return 1
            }
            if (result[n][target] != -1) {
                return result[n][target]
            }
            var total = 0L
            for (count in 1..k) {
                total += calculate(n - 1, k, target - count, result)
            }
            result[n][target] = (total % mod).toInt()
            return result[n][target]
        }

        fun numRollsToTargetIterative(n: Int, k: Int, target: Int): Int {
            val mod = 1000000007
            val result = Array(n + 1) { IntArray(target + 1) { 0 } }
            result[0][0] = 1
            for (i in 1..n) {
                for (j in 1..target) {
                    var ans = 0L
                    for (count in 1..k) {
                        if (j - count >= 0) {
                            ans += result[i - 1][j - count]
                        }
                    }
                    result[i][j] = (ans % mod).toInt()
                }
            }
            return result[n][target]
        }
    }
}