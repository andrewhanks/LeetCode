package questions

import java.util.*
import kotlin.math.pow


class Question_1284_Minimum_Number_of_Flips_to_Convert_Binary_Matrix_to_Zero_Matrix {

    companion object {

        fun runQuestion() {
//            Input: mat = [[0,0],[0,1]]
//            Output: 3
            val mat = arrayOf(intArrayOf(0, 0), intArrayOf(0, 1))
            val result = minFlips(mat)
            println("Question 1284: $result")
        }

        fun minFlips(mat: Array<IntArray>): Int {
            val pos = listOf(listOf(0, 0), listOf(1, 0), listOf(-1, 0), listOf(0, 1), listOf(0, -1))
            var encode = 0
            for (i in 0..mat.size - 1) {
                for (j in 0..mat[0].size - 1) {
                    encode = encode * 2 + mat[i][j]
                }
            }
            if (encode == 0) {
                return 0
            }
            val queue: Queue<Pair<Int, Int>> = LinkedList()
            val visited: MutableList<Int> = mutableListOf(encode)
            queue.add(Pair(encode, 0))
            // println("encode = $encode")
            visited.add(encode)
            while (!queue.isEmpty()) {
                val item = queue.remove()
                for (i in 0..mat.size - 1) {
                    for (j in 0..mat[0].size - 1) {
                        // println("=========================== i = $i, j = $j")
                        var currEncode = item.first
                        for (p in pos) {
                            val x = i + p[0]
                            val y = j + p[1]
                            // println("x = $x, y = $y")
                            if (x < 0 || x > mat.size - 1 || y < 0 || y > mat[0].size - 1) {
                                continue
                            }
                            currEncode =
                                currEncode xor ((2.0).pow(mat.size * mat[0].size - x * mat[0].size - y - 1)).toInt()
                            // println("currEncode = $currEncode, mask = ${mat.size*mat[0].size-x*mat[0].size-y-1}")
                        }
                        if (currEncode == 0) {
                            return item.second + 1
                        }
                        if (!visited.contains(currEncode)) {
                            // println("final currEncode = $currEncode")
                            visited.add(currEncode)
                            queue.add(Pair(currEncode, item.second + 1))
                        }
                    }
                }
            }
            return -1
        }

        fun minFlipsWithBitwiseOperator(mat: Array<IntArray>): Int {
            val pos = listOf(listOf(0, 0), listOf(1, 0), listOf(-1, 0), listOf(0, 1), listOf(0, -1))
            var encode = 0
            for (i in 0..mat.size - 1) {
                for (j in 0..mat[0].size - 1) {
                    encode = encode * 2 + mat[i][j]
                }
            }
            if (encode == 0) {
                return 0
            }
            val queue: Queue<Pair<Int, Int>> = LinkedList()
            val visited: MutableList<Int> = mutableListOf(encode)
            queue.add(Pair(encode, 0))
            visited.add(encode)
            while (!queue.isEmpty()) {
                val item = queue.remove()
                for (i in 0..mat.size - 1) {
                    for (j in 0..mat[0].size - 1) {
                        var currEncode = item.first
                        for (p in pos) {
                            val x = i + p[0]
                            val y = j + p[1]
                            if (x < 0 || x > mat.size - 1 || y < 0 || y > mat[0].size - 1) {
                                continue
                            }
                            currEncode = currEncode xor (1 shl x * mat[0].size + y)
                        }
                        if (currEncode == 0) {
                            return item.second + 1
                        }
                        if (!visited.contains(currEncode)) {
                            visited.add(currEncode)
                            queue.add(Pair(currEncode, item.second + 1))
                        }
                    }
                }
            }
            return -1
        }

        fun minFlipsWithBitMask(mat: Array<IntArray>): Int {
            val dirs = listOf(listOf(0, 0), listOf(1, 0), listOf(-1, 0), listOf(0, 1), listOf(0, -1))
            val m = mat.size
            val n = mat[0].size
            var min = Int.MAX_VALUE
            for (i in 0..(1 shl m * n) - 1) {
                var mask = Integer.toBinaryString(i)
                while (mask.length < m * n) {
                    mask = "0" + mask
                }
                if (mask.count { it == '1' } >= min) {
                    continue
                }
                val temp = Array(m) { IntArray(n) { 0 } }
                for (i in 0..m - 1) {
                    for (j in 0..n - 1) {
                        temp[i][j] = mat[i][j]
                    }
                }
                for (i in 0..mask.length - 1) {
                    val char = mask[i]
                    if (char == '0') {
                        continue
                    }
                    for (dir in dirs) {
                        val x = i / n + dir[0]
                        val y = i % n + dir[1]
                        if (x < 0 || x > m - 1 || y < 0 || y > n - 1) {
                            continue
                        }
                        temp[x][y] = 1 - temp[x][y]
                    }
                }
                if (temp.flatMap { it.toList() }.count { it == 0 } == m * n) {
                    min = mask.count { it == '1' }
                }
            }
            return if (min == Int.MAX_VALUE) {
                -1
            } else {
                min
            }
        }
    }
}