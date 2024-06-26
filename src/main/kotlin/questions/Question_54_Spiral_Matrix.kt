package questions


class Question_54_Spiral_Matrix {

    companion object {

        fun runQuestion() {
//            Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//            Output: [1,2,3,4,8,12,11,10,9,5,6,7]
            val matrix = arrayOf(intArrayOf(1, 2, 3, 4), intArrayOf(5, 6, 7, 8), intArrayOf(9, 10, 11, 12))
            val result = spiralOrder(matrix)
            println("Question 54: $result")
        }

        fun spiralOrder(matrix: Array<IntArray>): List<Int> {
            val dir = arrayOf(intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(-1, 0))
            var curDir = 0
            val moved = Array(matrix.size) { Array(matrix[0].size) { false } }
            val result: MutableList<Int> = mutableListOf()
            var x = 0
            var y = 0
            for (count in 0..matrix.size * matrix[0].size - 1) {
                // println("x= $x, y = $y")
                result.add(matrix[x][y])
                moved[x][y] = true
                val doesNeedToTurn = doesNeedToTurn(x, y, matrix, dir, curDir, moved)
                // println("x+dir[curDir][0] = ${x+dir[curDir][0]}, y+dir[curDir][1] = ${y+dir[curDir][1]}, matrix.size-1 = ${matrix.size-1}, matrix[0].size-1 = ${matrix[0].size-1}, curDir = $curDir")
                // println("doesNeedToTurn = $doesNeedToTurn")
                if (doesNeedToTurn) {
                    curDir = (curDir + 1) % 4
                }
                x += dir[curDir][0]
                y += dir[curDir][1]
            }
            return result
        }

        fun doesNeedToTurn(
            x: Int,
            y: Int,
            matrix: Array<IntArray>,
            dir: Array<IntArray>,
            curDir: Int,
            moved: Array<Array<Boolean>>
        ): Boolean {
            return x + dir[curDir][0] > matrix.size - 1 || x + dir[curDir][0] < 0 ||
                    y + dir[curDir][1] > matrix[0].size - 1 || y + dir[curDir][1] < 0 ||
                    moved[x + dir[curDir][0]][y + dir[curDir][1]]
        }

        val RIGHT: Int = 1
        val DOWN: Int = 2
        val LEFT: Int = 3
        val UP: Int = 4
        var currentDirection = RIGHT
        val result: MutableList<Int> = mutableListOf()

        fun spiralOrderEasier(matrix: Array<IntArray>): List<Int> {
            generateResult(0, 0, matrix)
            return result
        }

        fun generateResult(x: Int, y: Int, matrix: Array<IntArray>) {
            if (x < 0 || x > matrix.size - 1 || y < 0 || y > matrix[0].size - 1 || matrix[x][y] == 101) {
                if (currentDirection == RIGHT) {
                    currentDirection = DOWN
                } else if (currentDirection == DOWN) {
                    currentDirection = LEFT
                } else if (currentDirection == LEFT) {
                    currentDirection = UP
                } else {
                    currentDirection = RIGHT
                }
                return
            }
            result.add(matrix[x][y])
            matrix[x][y] = 101
            if (currentDirection == RIGHT) {
                generateResult(x, y + 1, matrix)
            }
            if (currentDirection == DOWN) {
                generateResult(x + 1, y, matrix)
            }
            if (currentDirection == LEFT) {
                generateResult(x, y - 1, matrix)
            }
            if (currentDirection == UP) {
                generateResult(x - 1, y, matrix)
            }
        }

        fun spiralOrderOldSolution(matrix: Array<IntArray>): List<Int> {
            val result: MutableList<Int> = mutableListOf()
            var rightCount = 0
            var downCount = 0
            var leftCount = 0
            var upCount = 0
            var x = 0
            var y = 0
            var count = 0
            while (count < matrix.size * matrix[0].size) {
                when {
                    (rightCount == downCount && downCount == leftCount && leftCount == upCount && upCount == rightCount) -> {
                        println(matrix[x][y])
                        result.add(matrix[x][y])
                        if (y + downCount < matrix[0].size - 1) {
                            y++
                        } else {
                            x++
                        }
                        count++
                        if ((y + downCount) == matrix[0].size - 1) {
                            rightCount++
                        }
                    }

                    (downCount < rightCount) -> {
                        println(matrix[x][y])
                        result.add(matrix[x][y])
                        if (x + leftCount < matrix.size - 1) {
                            x++
                        } else {
                            y--
                        }
                        count++
                        if ((x + leftCount) == matrix.size - 1) {
                            downCount++
                        }
                    }

                    (leftCount < downCount) -> {
                        println(matrix[x][y])
                        result.add(matrix[x][y])
                        if (y - upCount > 0) {
                            y--
                        } else {
                            x--
                        }
                        count++
                        if ((y - upCount) == 0) {
                            leftCount++
                        }
                    }

                    (upCount < leftCount) -> {
                        println(matrix[x][y])
                        result.add(matrix[x][y])
                        if (x - rightCount > 0) {
                            x--
                        } else {
                            y++
                        }
                        count++
                        if ((x - rightCount) == 0) {
                            upCount++
                        }
                    }

                    else -> {

                    }
                }
            }
            return result.toList()
        }
    }
}