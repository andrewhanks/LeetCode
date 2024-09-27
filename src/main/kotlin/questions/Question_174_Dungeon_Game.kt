package questions

import kotlin.math.max
import kotlin.math.min


class Question_174_Dungeon_Game {

    companion object {

        fun runQuestion() {
//            Input: dungeon = [[-2,-3,3],[-5,-10,1],[10,30,-5]]
//            Output: 7
            val dungeon = arrayOf(intArrayOf(-2, -3, 3), intArrayOf(-5, -10, 1), intArrayOf(10, 30, -5))
            val result = calculateMinimumHP(dungeon)
            println("Question 174: $result")
        }

        fun calculateMinimumHP(dungeon: Array<IntArray>): Int {
            val result = Array(dungeon.size) { IntArray(dungeon[0].size) { 0 } }
            for (i in result.size - 1 downTo 0) {
                for (j in result[0].size - 1 downTo 0) {
                    if (i == result.size - 1 && j == result[0].size - 1) {
                        result[i][j] = 1
                    } else if (i == result.size - 1) {
                        result[i][j] = result[i][j + 1] - dungeon[i][j + 1]
                    } else if (j == result[0].size - 1) {
                        result[i][j] = result[i + 1][j] - dungeon[i + 1][j]
                    } else {
                        result[i][j] = min(result[i][j + 1] - dungeon[i][j + 1], result[i + 1][j] - dungeon[i + 1][j])
                    }
                    result[i][j] = max(result[i][j], 1)
                }
            }
            result[0][0] = result[0][0] - dungeon[0][0]
            result[0][0] = max(result[0][0], 1)
            return result[0][0]
        }
    }
}