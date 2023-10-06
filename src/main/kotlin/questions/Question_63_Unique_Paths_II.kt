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