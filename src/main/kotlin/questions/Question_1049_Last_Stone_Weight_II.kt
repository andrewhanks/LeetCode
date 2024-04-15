package questions

class Question_1049_Last_Stone_Weight_II {

    companion object {

        fun runQuestion() {
//            Input: stones = [31,26,33,21,40]
//            Output: 5
            val stones = intArrayOf(31, 26, 33, 21, 40)
            val result = lastStoneWeightII(stones)
            println("Question 1049: $result")
        }

        fun lastStoneWeightII(stones: IntArray): Int {
            val sum = stones.sum()
            val half = sum / 2
            val result = Array(stones.size + 1) { Array(half + 1) { false } }
            for (i in 0..result.size - 1) {
                result[i][0] = true
            }
            for (i in 1..result.size - 1) {
                for (j in 1..result[0].size - 1) {
                    if (stones[i - 1] <= j) {
                        result[i][j] = result[i - 1][j - stones[i - 1]] || result[i - 1][j]
                    } else {
                        result[i][j] = result[i - 1][j]
                    }
                }
            }
            var finalValue = 0
            for (count in result[result.size - 1].size - 1 downTo 0) {
                if (result[result.size - 1][count]) {
                    finalValue = count
                    break
                }
            }
            return sum - finalValue - finalValue
        }
    }
}