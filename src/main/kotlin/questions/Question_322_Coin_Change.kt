package questions

import kotlin.math.min


class Question_322_Coin_Change {

    companion object {

        fun runQuestion() {
//            Input: coins = [1,2,5], amount = 11
//            Output: 3
            val intArray = intArrayOf(1, 2, 5)
            val amount = 11
            val startTime = System.currentTimeMillis()
            val result = coinChange(intArray, amount)
            println("Question 322: $result, spent time = ${System.currentTimeMillis() - startTime}")
        }

        fun coinChange(coins: IntArray, amount: Int): Int {
            val result = IntArray(amount + 1) { 10001 }
            result[0] = 0
            for (count in 1..result.size - 1) {
                var min = 10001
                coins.forEach {
                    if (count >= it) {
                        min = min(min, result[count - it] + 1)
                    }
                }
                result[count] = min
            }
            return if (result[amount] == 10001) {
                return -1
            } else {
                result[amount]
            }
        }

        fun coinChangeWithTwoDimensionArray(coins: IntArray, amount: Int): Int {
            val result = Array(coins.size) { Array(amount + 1) { -1 } }
            val finalResult = dpWithTwoDimensionArray(coins, amount, coins.size - 1, result)
            if (finalResult != 100000) {
                return finalResult
            } else {
                return -1
            }
        }

        fun dpWithTwoDimensionArray(coins: IntArray, amount: Int, index: Int, result: Array<Array<Int>>): Int {
            // println("index = $index, amount = $amount")
            if (amount < 0) {
                return 100000
            }
            if (amount == 0) {
                result[index][amount] = 0
                return result[index][amount]
            }
            if (index == 0) {
                if (amount % coins[index] == 0) {
                    result[index][amount] = amount / coins[index]
                    return amount / coins[index]
                } else {
                    result[index][amount] = 100000
                    return 100000
                }
            }
            if (result[index][amount] != -1) {
                return result[index][amount]
            }
            val taken = dpWithTwoDimensionArray(coins, amount - coins[index], index, result) + 1
            val notTaken = dpWithTwoDimensionArray(coins, amount, index - 1, result)
            // println("taken = $taken, notTaken = $notTaken")
            result[index][amount] = min(taken, notTaken)
            return result[index][amount]
        }

        fun coinChangeTopDown(coins: IntArray, amount: Int): Int {
            val resultList = IntArray(amount) { -1 }
            val minCount = countNumber(coins, amount, resultList)
            if (minCount == 100000) {
                return -1
            } else {
                return minCount
            }
        }

        fun countNumber(coins: IntArray, amount: Int, resultList: IntArray): Int {
            if (amount == 0) {
                return 0
            }
            if (amount < 0) {
                return 100000
            }
            if (resultList[amount - 1] != -1) {
                return resultList[amount - 1]
            }
            var minCount = 100000
            coins.forEach { value ->
                val currentMin = countNumber(coins, amount - value, resultList)
                if (currentMin != 100000) {
                    minCount = min(minCount, currentMin + 1)
                }
            }
            resultList[amount - 1] = minCount
            return minCount
        }

        fun coinChangeBottomUp(coins: IntArray, amount: Int): Int {
            val resultList = IntArray(amount + 1) { 0 }
            for (count in 1..amount) {
                var min = 100000
                for (coin in coins) {
                    if (count - coin >= 0 && resultList[count - coin] != -1) {
                        val minTemp = resultList[count - coin] + 1
                        if (minTemp < min) {
                            min = minTemp
                        }
                    }
                }
                if (min == 100000) {
                    min = -1
                }
                resultList[count] = min
            }
            return resultList[amount]
        }
    }
}