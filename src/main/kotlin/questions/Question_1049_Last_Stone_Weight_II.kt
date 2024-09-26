package questions

import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

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
            val half = stones.sum() / 2
            val result = Array(half + 1) { false }
            result[0] = true
            var max = 0
            for (stone in stones) {
                val temp = result.toMutableList()
                for (i in 0..result.size - 1) {
                    if (i - stone < 0) {
                        continue
                    }
                    if (temp[i - stone]) {
                        result[i] = true
                        max = max(max, i)
                    }
                }
            }
            // println("result = ${result.contentToString()}")
            return abs(max - (stones.sum() - max))
        }

        fun lastStoneWeightIIWithWebSolution(stones: IntArray): Int {
            val set: MutableSet<Int> = mutableSetOf(0)
            for (stone in stones) {
                val tempSet = set.toMutableSet()
                set.clear()
                for (item in tempSet) {
                    set.add(item + stone)
                    set.add(item - stone)
                }
            }
            // println("set = $set")
            var min = Int.MAX_VALUE
            for (item in set) {
                if (item >= 0) {
                    min = min(min, item)
                }
            }
            return min
        }

        fun lastStoneWeightIIAnotherSolution(stones: IntArray): Int {
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