package questions

import java.math.BigInteger


class Question_62_Unique_Paths {

    companion object {

        fun runQuestion() {
            val m = 3
            val n = 7
            val result = uniquePaths(m, n)
            println("Question 62: $result")
        }

        fun uniquePaths(m: Int, n: Int): Int {
            var result: BigInteger = BigInteger.ONE
            if (m == 1 || n == 1) {
                return result.toInt()
            }
            for (count in 1..m + n - 2) {
                result = result.times(count.toBigInteger())
            }
            println("result 1 = $result")
            for (count in 1..m - 1) {
                result = result.divide(count.toBigInteger())
            }
            println("result 2 = $result")
            for (count in 1..n - 1) {
                result = result.divide(count.toBigInteger())
            }
            println("result 3 = $result")
            return result.toInt()
        }

        fun uniquePathsRecording(m: Int, n: Int): Int {
            val resultArray: Array<IntArray> = Array(n) { IntArray(m) { 0 } }
            println("resultArray.size = " + resultArray.size + ", resultArray[0].size = " + resultArray[0].size)
            for (x in 0..m - 1) {
                for (y in 0..n - 1) {
                    if (x == 0 && y == 0) {
                        resultArray[y][x] = 1
                    } else if (x == 1 && y == 0) {
                        resultArray[y][x] = 1
                    } else if (x == 0 && y == 1) {
                        resultArray[y][x] = 1
                    } else {
                        var left = 0
                        var up = 0
                        if (x - 1 >= 0) {
                            left = resultArray[y][x - 1]
                        }
                        if (y - 1 >= 0) {
                            up = resultArray[y - 1][x]
                        }
                        println("left = $left, up = $up")
                        resultArray[y][x] = left + up
                    }
                    println("x = $x, y = $y, resultArray[y][x] = ${resultArray[y][x]}")
                }
            }
            return resultArray[n - 1][m - 1]
        }

        fun uniquePathsDp(m: Int, n: Int): Int {
            if (m == 1) {
                return 1
            }
            if (n == 1) {
                return 1
            }
            return uniquePathsDp(m - 1, n) + uniquePathsDp(m, n - 1)
        }
    }
}