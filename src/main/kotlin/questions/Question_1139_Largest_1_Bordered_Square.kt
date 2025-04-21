package questions

import kotlin.math.max
import kotlin.math.min
import kotlin.math.sqrt


class Question_1139_Largest_1_Bordered_Square {

    companion object {

        fun runQuestion() {
//            Input: grid = [[1,1,1],[1,0,1],[1,1,1]]
//            Output: 9
            val intArray = arrayOf(intArrayOf(1, 1, 1), intArrayOf(1, 0, 1), intArrayOf(1, 1, 1))
            val result = largest1BorderedSquare(intArray)
            println("Question 1139: $result")
        }

        fun largest1BorderedSquare(grid: Array<IntArray>): Int {
            var ans = 0
            for (i in 0..grid.size - 1) {
                for (j in 0..grid[0].size - 1) {
                    if (grid[i][j] != 1) {
                        continue
                    }
                    if (sqrt(ans.toDouble()).toInt() >= grid.size - i || sqrt(ans.toDouble()).toInt() >= grid[0].size - j) {
                        continue
                    }
                    val maxItem = getMax(grid, i, j, ans)
                    ans = max(ans, maxItem)
                }
            }
            return ans
        }

        fun getMax(grid: Array<IntArray>, i: Int, j: Int, ans: Int): Int {
            var min = min(grid.size - i, grid[0].size - j)
            var sqrtAns = sqrt(ans.toDouble()).toInt()
            for (k in min downTo 1) {
                if (sqrtAns >= k) {
                    continue
                }
                if (check(grid, i, j, k)) {
                    return k * k
                }
            }
            return 0
        }

        fun check(grid: Array<IntArray>, i: Int, j: Int, size: Int): Boolean {
            // println("i = $i, j = $j, size = $size")
            for (l in i..i + size - 1) {
                if (grid[l][j] != 1) {
                    return false
                }
            }
            for (l in j..j + size - 1) {
                if (grid[i][l] != 1) {
                    return false
                }
            }
            for (l in i..i + size - 1) {
                if (grid[l][j + size - 1] != 1) {
                    return false
                }
            }
            for (l in j..j + size - 1) {
                if (grid[i + size - 1][l] != 1) {
                    return false
                }
            }
            return true
        }

        fun largest1BorderedSquareFaster(grid: Array<IntArray>): Int {
            val n = grid.size + 1
            val m = grid[0].size + 1
            var res = 0
            val dpRow = Array(n) { IntArray(m) }
            val dpCol = Array(n) { IntArray(m) }
            for (i in 1..n - 1) {
                for (j in 1..m - 1) {
                    if (grid[i - 1][j - 1] != 0) {
                        // prefix sum row and col
                        dpRow[i][j] = dpRow[i][j - 1] + 1
                        dpCol[i][j] = dpCol[i - 1][j] + 1
                        // check square
                        val side = min(dpRow[i][j], dpCol[i][j])
                        for (k in side downTo res + 1) {
                            if (i >= k && j >= k && dpRow[i - k + 1][j] >= k && dpCol[i][j - k + 1] >= k) {
                                res = k
                                break
                            }
                        }
                    }
                }
            }
            return res * res
        }
    }
}