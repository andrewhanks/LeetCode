package questions


class Question_1301_Number_of_Paths_with_Max_Score {

    companion object {

        fun runQuestion1301() {
            val stringArray = arrayOf("E12", "1X1", "21S").toList()
            val resultArray = pathsWithMaxScoreWebSolution(stringArray)
            var result = "["
            resultArray.forEachIndexed { index, i ->
                result += i
                if (index == resultArray.size - 1) {
                    result += "]"
                } else {
                    result += ","
                }
            }
            println("Question 1301: $result")
        }

        var mMod = 1000000000 + 7

        private val mDirections = arrayOf(intArrayOf(1, 0), intArrayOf(0, 1), intArrayOf(1, 1))

        fun pathsWithMaxScoreWebSolution(board: List<String>): IntArray {
            val rows = board.size
            val columns = board[0].length
            val dp = Array(rows) { Array(columns) { IntArray(2) } }
            for (r in rows - 1 downTo 0) {
                for (c in columns - 1 downTo 0) {
                    val current = board[r][c]
                    if (current == 'S') {
                        dp[r][c][0] = 0
                        dp[r][c][1] = 1
                    } else if (current != 'X') {
                        var maxScore = 0
                        var paths = 0
                        val currentScore = if (current == 'E') 0 else current - '0'
                        for (dir in mDirections) {
                            val nextR = r + dir[0]
                            val nextC = c + dir[1]
                            if (nextR < rows && nextC < columns && dp[nextR][nextC][1] > 0) {
                                if (dp[nextR][nextC][0] + currentScore > maxScore) {
                                    maxScore = dp[nextR][nextC][0] + currentScore
                                    paths = dp[nextR][nextC][1]
                                } else if (dp[nextR][nextC][0] + currentScore == maxScore) {
                                    paths = (paths + dp[nextR][nextC][1]) % mMod
                                }
                            }
                        }
                        dp[r][c][0] = maxScore
                        dp[r][c][1] = paths
                    }
                }
            }
            return intArrayOf(dp[0][0][0], dp[0][0][1])
        }

        var mIsOneFromStartPoint = false
        var mPathNumberTotal = 0

        //TODO: Need to check whether the answer is right or not
        fun pathsWithMaxScore(board: List<String>): IntArray {
            mIsOneFromStartPoint = false
            mPathNumberTotal = 0
            val tempBoard = Array(board.size) { IntArray(board[0].length) }

            val maxValue = getPathSum(board, 0, 0, tempBoard)
            tempBoard.forEachIndexed { index1, i1 ->
                i1.forEachIndexed { index2, i2 ->
                    println("tempBoard[$index2][$index1] = $i2")
                }
            }
            return if (!mIsOneFromStartPoint) {
                arrayOf(0, 0).toIntArray()
            } else {
                mPathNumberTotal = 1
                val maxPathNumber = calculateTotalPath(board, tempBoard, 0, 0) % mMod
                println("maxPathNumber = $maxPathNumber")
                arrayOf(maxValue, maxPathNumber).toIntArray()
            }
        }

        private fun getPathSum(board: List<String>, x: Int, y: Int, tempBoard: Array<IntArray>): Int {
            println(
                "isPathAvailable(board, ${x + 1}, $y) = ${isPathAvailable(board, x + 1, y)}, " +
                        "isPathAvailable(board, $x, ${y + 1}) = ${isPathAvailable(board, x, y + 1)}, " +
                        "isPathAvailable(board, ${x + 1}, ${y + 1}) = ${isPathAvailable(board, x + 1, y + 1)}"
            )

            val currentPointValue = if (board[y][x].isDigit()) {
                board[y][x].toString().toInt()
            } else if (isStartOrEndPoint(board, x, y)) {
                0
            } else {
                -1
            }

            val valueFromRight = if (isPathAvailable(board, x + 1, y)) {
                if (!board[y][x].isDigit()) {
                    getPathSum(board, x + 1, y, tempBoard)
                } else {
                    getPathSum(board, x + 1, y, tempBoard) + currentPointValue
                }
            } else {
                -1
            }
            val valueFromDown = if (isPathAvailable(board, x, y + 1)) {
                if (!board[y][x].isDigit()) {
                    getPathSum(board, x, y + 1, tempBoard)
                } else {
                    getPathSum(board, x, y + 1, tempBoard) + currentPointValue
                }
            } else {
                -1
            }
            val valueFromRightDown = if (isPathAvailable(board, x + 1, y + 1)) {
                if (!board[y][x].isDigit()) {
                    getPathSum(board, x + 1, y + 1, tempBoard)
                } else {
                    getPathSum(board, x + 1, y + 1, tempBoard) + currentPointValue
                }
            } else {
                -1
            }

            println(
                "($x, $y) = $currentPointValue, valueFromRight = $valueFromRight, " +
                        "valueFromDown = $valueFromDown, " +
                        "valueFromRightDown = $valueFromRightDown"
            )

            if (!isPathAvailable(board, x + 1, y) &&
                !isPathAvailable(board, x, y + 1) &&
                !isPathAvailable(board, x + 1, y + 1)
            ) {
                println(
                    "x + 1 = ${x + 1}, " +
                            "board[0].length = ${board[0].length}, " +
                            "y + 1 = ${y + 1}, " +
                            "board.size = ${board.size}"
                )

                if ((x + 1 == board[0].length && y + 1 == board.size) ||
                    (x + 1 == board[0].length && y == board.size) ||
                    (x == board[0].length && y + 1 == board.size)
                ) {
                    mIsOneFromStartPoint = true
                } else {
                    if (!mIsOneFromStartPoint) {
                        mIsOneFromStartPoint = false
                    }
                }
                println("mIsOneFromStartPoint = $mIsOneFromStartPoint")
                return if (board[y][x].isDigit()) {
                    tempBoard[y][x] = currentPointValue
                    currentPointValue
                } else {
                    tempBoard[y][x] = 0
                    0
                }
            }

            return if (valueFromRight > valueFromRightDown) {
                if (valueFromRight > valueFromDown) {
                    tempBoard[y][x] = valueFromRight
                    valueFromRight
                } else {
                    tempBoard[y][x] = valueFromDown
                    valueFromDown
                }
            } else {
                if (valueFromRightDown > valueFromDown) {
                    tempBoard[y][x] = valueFromRightDown
                    valueFromRightDown
                } else {
                    tempBoard[y][x] = valueFromDown
                    valueFromDown
                }
            }
        }

        private fun isPathAvailable(board: List<String>, x: Int, y: Int): Boolean {
            return y < board.size && x < board[0].length && board[y][x] != 'X'
        }

        private fun isStartOrEndPoint(board: List<String>, x: Int, y: Int): Boolean {
            return y < board.size && x < board[0].length && (board[y][x] == 'S' || board[y][x] == 'E')
        }

        private fun calculateTotalPath(board: List<String>, tempBoard: Array<IntArray>, x: Int, y: Int): Int {
            if (!isPathAvailable(board, x, y)) {
                return 0
            }
            if (x == board[0].length - 1 && y == board.size - 1) {
                println("($x, $y) return 1")
                return 1
            } else if (x >= board[0].length || y >= board.size) {
                return 0
            }

            val sumFromRight = if (x + 1 < tempBoard[0].size && y < tempBoard.size) {
                tempBoard[y][x + 1]
            } else {
                -1
            }
            val sumFromDown = if (x < tempBoard[0].size && y + 1 < tempBoard.size) {
                tempBoard[y + 1][x]
            } else {
                -1
            }
            val sumFromRightDown = if (x + 1 < tempBoard[0].size && y + 1 < tempBoard.size) {
                tempBoard[y + 1][x + 1]
            } else {
                -1
            }

            println("($x, $y): sumFromRight = $sumFromRight, sumFromDown = $sumFromDown, sumFromRightDown = $sumFromRightDown")

            return if (sumFromRight == sumFromRightDown && sumFromRightDown == sumFromDown && sumFromRight >= 0) {
                calculateTotalPath(board, tempBoard, x + 1, y) + calculateTotalPath(
                    board,
                    tempBoard,
                    x,
                    y + 1
                ) + calculateTotalPath(board, tempBoard, x + 1, y + 1)
            } else if (sumFromRight == sumFromRightDown && sumFromRight > sumFromDown && sumFromRight >= 0) {
                calculateTotalPath(board, tempBoard, x + 1, y) + calculateTotalPath(board, tempBoard, x + 1, y + 1)
            } else if (sumFromRightDown == sumFromDown && sumFromRightDown > sumFromRight && sumFromRightDown >= 0) {
                calculateTotalPath(board, tempBoard, x, y + 1) + calculateTotalPath(board, tempBoard, x + 1, y + 1)
            } else if (sumFromRight == sumFromDown && sumFromRight > sumFromRightDown && sumFromRight >= 0) {
                calculateTotalPath(board, tempBoard, x + 1, y) + calculateTotalPath(board, tempBoard, x, y + 1)
            } else {
                if (sumFromRight > sumFromRightDown) {
                    if (sumFromRight > sumFromDown) {
                        calculateTotalPath(board, tempBoard, x + 1, y)
                    } else {
                        calculateTotalPath(board, tempBoard, x, y + 1)
                    }
                } else {
                    if (sumFromRightDown > sumFromDown) {
                        calculateTotalPath(board, tempBoard, x + 1, y + 1)
                    } else {
                        calculateTotalPath(board, tempBoard, x, y + 1)
                    }
                }
            }
        }
    }
}