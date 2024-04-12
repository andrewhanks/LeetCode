package questions


class Question_63_Unique_Paths_II {

    companion object {

        fun runQuestion() {
//            Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
//            Output: 2
            val obstacleGrid = arrayOf(intArrayOf(0, 0, 0), intArrayOf(0, 1, 0), intArrayOf(0, 0, 0))
            val result = uniquePathsWithObstacles(obstacleGrid)
            println("Question 63: $result")
        }

        fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
            if (obstacleGrid[0][0] == 1) {
                return 0
            }
            val m = obstacleGrid.size
            val n = obstacleGrid[0].size
            if (obstacleGrid[m - 1][n - 1] == 1) {
                return 0
            }
            val result = Array(m) { IntArray(n) { 0 } }
            dp(m, n, obstacleGrid, result)
            return result[m - 1][n - 1]
        }

        fun dp(m: Int, n: Int, obstacleGrid: Array<IntArray>, result: Array<IntArray>): Int {
            if (result[m - 1][n - 1] != 0) {
                return result[m - 1][n - 1]
            }
            if (m == 1 || n == 1) {
                var hasObstacle = false
                if (m == 1) {
                    for (count in 0..n - 1) {
                        if (obstacleGrid[m - 1][count] == 1) {
                            hasObstacle = true
                            break
                        }
                    }
                }
                if (n == 1) {
                    for (count in 0..m - 1) {
                        if (obstacleGrid[count][n - 1] == 1) {
                            hasObstacle = true
                            break
                        }
                    }
                }
                if (hasObstacle) {
                    result[m - 1][n - 1] = 0
                } else {
                    result[m - 1][n - 1] = 1
                }
                return result[m - 1][n - 1]
            }
            if (obstacleGrid[m - 1][n - 2] == 1 && obstacleGrid[m - 2][n - 1] != 1) {
                result[m - 1][n - 1] = dp(m - 1, n, obstacleGrid, result)
            } else if (obstacleGrid[m - 2][n - 1] == 1 && obstacleGrid[m - 1][n - 2] != 1) {
                result[m - 1][n - 1] = dp(m, n - 1, obstacleGrid, result)
            } else if (obstacleGrid[m - 2][n - 1] != 1 && obstacleGrid[m - 1][n - 2] != 1) {
                result[m - 1][n - 1] = dp(m - 1, n, obstacleGrid, result) + dp(m, n - 1, obstacleGrid, result)
            } else {
                result[m - 1][n - 1] = 0
            }
            return result[m - 1][n - 1]
        }

        fun uniquePathsWithObstaclesIterative(obstacleGrid: Array<IntArray>): Int {
            val resultList: Array<IntArray> = Array(obstacleGrid.size) { IntArray(obstacleGrid[0].size) { 0 } }
            for (j in 0..obstacleGrid[0].size - 1) {
                for (i in 0..obstacleGrid.size - 1) {
                    if (obstacleGrid[i][j] == 1) {
                        resultList[i][j] = 0
                    } else if (i == 0 && j == 0) {
                        resultList[i][j] = 1
                    } else if (i < 1 || j < 1) {
                        if (i < 1) {
                            if (obstacleGrid[i][j - 1] != 1) {
                                resultList[i][j] = resultList[i][j - 1]
                            } else {
                                resultList[i][j] = 0
                            }
                        } else if (j < 1) {
                            if (obstacleGrid[i - 1][j] != 1) {
                                resultList[i][j] = resultList[i - 1][j]
                            } else {
                                resultList[i][j] = 0
                            }
                        }
                    } else {
                        if (obstacleGrid[i][j - 1] != 1 && obstacleGrid[i - 1][j] != 1) {
                            resultList[i][j] = resultList[i - 1][j] + resultList[i][j - 1]
                        } else if (obstacleGrid[i][j - 1] == 1 && obstacleGrid[i - 1][j] != 1) {
                            resultList[i][j] = resultList[i - 1][j]
                        } else if (obstacleGrid[i][j - 1] != 1 && obstacleGrid[i - 1][j] == 1) {
                            resultList[i][j] = resultList[i][j - 1]
                        } else {
                            resultList[i][j] = 0
                        }
                    }
                    //println("resultList[$i][$j] = ${resultList[i][j]}")
                }
            }
            return resultList[resultList.size - 1][resultList[0].size - 1]
        }
    }
}