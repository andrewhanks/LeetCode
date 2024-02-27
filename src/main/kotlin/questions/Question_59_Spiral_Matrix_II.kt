package questions


class Question_59_Spiral_Matrix_II {

    companion object {

        fun runQuestion() {
//            Input: n = 3
//            Output: [[1,2,3],[8,9,4],[7,6,5]]
            val n = 3
            val resultList = generateMatrix(n)
            var result = "["
            resultList.forEachIndexed { firstIndex, firstI ->
                resultList[firstIndex].forEachIndexed { secondIndex, secondI ->
                    if (0 == secondIndex) {
                        result += "["
                    }
                    result += secondI
                    if (secondIndex == resultList[firstIndex].size - 1) {
                        result += "]"
                    } else {
                        result += ","
                    }
                }
                if (firstIndex == resultList.size - 1) {
                    result += "]"
                } else {
                    result += ","
                }
            }
            if (']' != result.last()) {
                result += "]"
            }
            println("Question 59: $result")
        }

        val RIGHT = 0
        val DOWN = 1
        val LEFT = 2
        val UP = 3
        fun generateMatrix(n: Int): Array<IntArray> {
            val result = Array(n) { IntArray(n) { 0 } }
            var x = 0
            var y = 0
            var dir = RIGHT
            for (count in 1..n * n) {
                //println("x = $x, y = $y")
                result[x][y] = count
                when (dir) {
                    RIGHT -> {
                        if (y < n - 1 && result[x][y + 1] == 0) {
                            y++
                        } else {
                            x++
                            dir = DOWN
                        }
                    }

                    DOWN -> {
                        if (x < n - 1 && result[x + 1][y] == 0) {
                            x++
                        } else {
                            y--
                            dir = LEFT
                        }
                    }

                    LEFT -> {
                        if (y > 0 && result[x][y - 1] == 0) {
                            y--
                        } else {
                            x--
                            dir = UP
                        }
                    }

                    UP -> {
                        if (y < n - 1 && result[x - 1][y] == 0) {
                            x--
                        } else {
                            y++
                            dir = RIGHT
                        }
                    }
                }
            }
            return result
        }
    }
}