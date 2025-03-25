package questions

import kotlin.math.sqrt


class Question_3044_Most_Frequent_Prime {

    companion object {

        fun runQuestion() {
//            Input: mat = [[1,1],[9,9],[1,1]]
//            Output: 19
            val mat = arrayOf(intArrayOf(1, 1), intArrayOf(9, 9), intArrayOf(1, 1))
            val result = mostFrequentPrime(mat)
            println("Question 3044: $result")
        }

        fun mostFrequentPrime(mat: Array<IntArray>): Int {
            val map: MutableMap<Int, Int> = mutableMapOf()
            val dirs = arrayOf(
                intArrayOf(0, 1),
                intArrayOf(1, 1),
                intArrayOf(1, 0),
                intArrayOf(-1, 1),
                intArrayOf(-1, 0),
                intArrayOf(-1, -1),
                intArrayOf(0, -1),
                intArrayOf(1, -1)
            )
            for (i in 0..mat.size - 1) {
                for (j in 0..mat[0].size - 1) {
                    for (dir in dirs) {
                        var x = i
                        var y = j
                        var number = 0
                        // println("enter: x = $x, y = $y")
                        while (x >= 0 && x <= mat.size - 1 && y >= 0 && y <= mat[0].size - 1) {
                            number = number * 10 + mat[x][y]
                            // println("number = $number")
                            map[number] = map.getOrDefault(number, 0) + 1
                            x = x + dir[0]
                            y = y + dir[1]
                            // println("x = $x, y = $y")
                        }
                    }
                }
            }
            var ans = -1
            var times = 0
            for ((key, value) in map) {
                if (key <= 10) {
                    continue
                }
                if (!isPrime(key)) {
                    continue
                }
                if ((value >= times && key > ans) || value > times) {
                    ans = key
                    times = value
                }
            }
            return ans
        }

        fun isPrime(number: Int): Boolean {
            val sqrt = sqrt(number.toDouble())
            for (i in 2..sqrt.toInt()) {
                // println("number = $number, sqrt = $sqrt, i = $i")
                if (number % i == 0) {
                    return false
                }
            }
            return true
        }
    }
}