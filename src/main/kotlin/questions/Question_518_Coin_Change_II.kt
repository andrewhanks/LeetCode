package questions

class Question_518_Coin_Change_II {

    companion object {

        fun runQuestion() {
//            Input: amount = 5, coins = [1,2,5]
//            Output: 4
            val amount = 5
            val coins = intArrayOf(1, 2, 5)
            val result = change(amount, coins)
            println("Question 518: $result")
        }

        fun change(amount: Int, coins: IntArray): Int {
            val result: MutableMap<String, Int> = mutableMapOf()
            return dpWithMap(amount, coins, 0, result)
        }

        fun dpWithMap(amount: Int, coins: IntArray, start: Int, result: MutableMap<String, Int>): Int {
            if (amount < 0) {
                return 0
            }
            if (amount == 0) {
                return 1
            }
            val key = amount.toString() + "," + start.toString()
            if (result.contains(key)) {
                return result[key]!!
            }
            var sum = 0
            for (count in start..coins.size - 1) {
                sum += dpWithMap(amount - coins[count], coins, count, result)
            }
            result[key] = sum
            return result[key]!!
        }

        fun changeTopDown(amount: Int, coins: IntArray): Int {
            val result: Array<IntArray> = Array(coins.size) { IntArray(amount + 1) { -1 } }
            return dpWithTwoDimensionArray(amount, coins, 0, result)
        }

        fun dpWithTwoDimensionArray(amount: Int, coins: IntArray, start: Int, result: Array<IntArray>): Int {
            if (start > coins.size - 1) {
                return 0
            }
            if (amount < 0) {
                return 0
            }
            if (amount == 0) {
                return 1
            }
            if (result[start][amount] != -1) {
                return result[start][amount]
            }
            val taken = dpWithTwoDimensionArray(amount - coins[start], coins, start, result)
            val notTaken = dpWithTwoDimensionArray(amount, coins, start + 1, result)
            result[start][amount] = taken + notTaken
            return result[start][amount]
        }

        fun changeBottomUp(amount: Int, coins: IntArray): Int {
            val result: Array<IntArray> = Array(coins.size) { IntArray(amount + 1) { -1 } }
            for (count in 0..coins.size - 1) {
                result[count][0] = 1
            }
            for (coinCount in 0..coins.size - 1) {
                for (count in 1..amount) {
                    var taken = 0
                    if (coinCount >= 1) {
                        taken = result[coinCount - 1][count]
                    }
                    var notTaken = 0
                    if (coins[coinCount] <= count) {
                        notTaken = result[coinCount][count - coins[coinCount]]
                    }
                    result[coinCount][count] = taken + notTaken
                }
            }
            return result[coins.size - 1][amount]
        }
    }
}