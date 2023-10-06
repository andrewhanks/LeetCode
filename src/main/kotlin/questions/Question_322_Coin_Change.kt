package questions

import java.util.*
import kotlin.math.min


class Question_322_Coin_Change {

    companion object {

        fun runQuestion() {
            val intArray = intArrayOf(186, 419, 83, 408)
            val amount = 6249
            val startTime = System.currentTimeMillis()
            val result = coinChangeBottomUp(intArray, amount)
            println("Question 322: $result, spent time = ${System.currentTimeMillis() - startTime}")
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