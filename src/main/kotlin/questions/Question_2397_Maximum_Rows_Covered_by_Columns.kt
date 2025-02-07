package questions

import kotlin.math.max
import kotlin.math.pow


class Question_2397_Maximum_Rows_Covered_by_Columns {

    companion object {

        fun runQuestion() {
//            Input: matrix = [[0,0,0],[1,0,1],[0,1,1],[0,0,1]], numSelect = 2
//            Output: 3
            val matrix = arrayOf(intArrayOf(0, 0, 0), intArrayOf(1, 0, 1), intArrayOf(0, 1, 1), intArrayOf(0, 0, 1))
            val numSelect = 2
            val result = maximumRows(matrix, numSelect)
            println("Question 2397: $result")
        }

        fun maximumRows(matrix: Array<IntArray>, numSelect: Int): Int {
            val max = (2.0).pow(matrix[0].size).toInt()
            var ans = 0
            for (i in 0..max - 1) {
                var target = Integer.toBinaryString(i)
                if (target.filter { it == '1' }.count() != numSelect) {
                    continue
                }
                while (target.length < matrix[0].size) {
                    target = "0" + target
                }
                // println("target = $target")
                var ret = 0
                for (j in 0..matrix.size - 1) {
                    var covered = true
                    for (k in 0..matrix[j].size - 1) {
                        if (matrix[j][k] == 1 && target[k] != '1') {
                            covered = false
                            break
                        }
                    }
                    if (covered) {
                        ret++
                    }
                }
                // println("ret = $ret")
                ans = max(ans, ret)
            }
            return ans
        }
    }
}