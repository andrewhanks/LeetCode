package questions

import java.util.*


class Question_1738_Find_Kth_Largest_XOR_Coordinate_Value {

    companion object {

        fun runQuestion() {
//            Input: matrix = [[5,2],[1,6]], k = 1
//            Output: 7
            val matrix = arrayOf(intArrayOf(5, 2), intArrayOf(1, 6))
            val k = 1
            val result = kthLargestValue(matrix, k)
            println("Question 1738: $result")
        }

        fun kthLargestValue(matrix: Array<IntArray>, k: Int): Int {
            val result = Array(matrix.size) { IntArray(matrix[0].size) { 0 } }
            val queue: PriorityQueue<Int> = PriorityQueue { a, b -> b - a }
            for (i in 0..result.size - 1) {
                result[i][0] = matrix[i][0]
            }
            for (i in 0..result.size - 1) {
                for (j in 1..result[0].size - 1) {
                    result[i][j] = matrix[i][j] xor result[i][j - 1]
                }
            }
            for (i in 1..result.size - 1) {
                for (j in 0..result[0].size - 1) {
                    result[i][j] = result[i][j] xor result[i - 1][j]
                }
            }
            for (i in 0..result.size - 1) {
                for (j in 0..result[0].size - 1) {
                    queue.add(result[i][j])
                }
            }
            var ans = 0
            for (count in 1..k) {
                ans = queue.remove()
            }
            return ans
        }

        // 1 1 1 X X    2 2 1 X X    2 2 1 X X    3 3 1 X X
        // 1 1 1 X X    2 2 1 X X    2 2 1 X X    3 3 1 X X
        // 0 0 0 X X => 1 1 0 X X => 1 1 1 X X => 1 1 1 X X
        // X X X X X    X X X X X    X X X X X    X X X X X
        // X X X X X    X X X X X    X X X X X    X X X X X
        fun kthLargestValueAnotherSolution(matrix: Array<IntArray>, k: Int): Int {
            val result = Array(matrix.size) { IntArray(matrix[0].size) { 0 } }
            val queue: PriorityQueue<Int> = PriorityQueue { a, b -> b - a }
            result[0][0] = matrix[0][0]
            for (i in 1..result.size - 1) {
                result[i][0] = result[i - 1][0] xor matrix[i][0]
            }
            for (j in 1..result[0].size - 1) {
                result[0][j] = result[0][j - 1] xor matrix[0][j]
            }
            for (i in 1..result.size - 1) {
                for (j in 1..result[0].size - 1) {
                    result[i][j] = result[i - 1][j] xor result[i][j - 1] xor matrix[i][j] xor result[i - 1][j - 1]
                }
            }

            // binary search
            var left = 0
            var right = Int.MAX_VALUE
            while (left < right) {
                val mid = right - (right - left) / 2
                if (count(result, mid) < k) {
                    right = mid - 1
                } else {
                    left = mid
                }
            }
            return left
        }

        fun count(result: Array<IntArray>, mid: Int): Int {
            var ans = 0
            for (i in 0..result.size - 1) {
                for (j in 0..result[0].size - 1) {
                    if (result[i][j] >= mid) {
                        ans++
                    }
                }
            }
            return ans
        }
    }
}