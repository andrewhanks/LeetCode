package questions


class Question_885_Spiral_Matrix_III {

    companion object {

        fun runQuestion() {
//            Input: rows = 3, cols = 3, rStart = 2, cStart = 0
//            Output: [[2,0],[2,1],[1,0],[1,1],[1,2],[2,2],[0,0],[0,1],[0,2]]
            val rows = 3
            val cols = 3
            val rStart = 2
            val cStart = 0
            val result = spiralMatrixIII(rows, cols, rStart, cStart)
            println("Question 885: ${result.contentDeepToString()}")
        }

        fun spiralMatrixIII(rows: Int, cols: Int, rStart: Int, cStart: Int): Array<IntArray> {
            val result: MutableList<IntArray> = mutableListOf()
            val visited = Array(rows) { Array(cols) { false } }
            val dirs = arrayOf(intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(-1, 0))
            visited[rStart][cStart] = true
            result.add(intArrayOf(rStart, cStart))
            var count = 1
            var currentX = rStart
            var currentY = cStart
            var currentDir = 0
            while (count < rows * cols) {
                val nextX = currentX + dirs[currentDir][0]
                val nextY = currentY + dirs[currentDir][1]
                if (nextX < 0 || nextX > rows - 1 || nextY < 0 || nextY > cols - 1) {
                    currentDir = (currentDir + 1) % 4
                    continue
                }
                // println("count = $count, nextX = $nextX, nextY = $nextY, visited[nextX][nextX] = ${visited[nextX][nextX]}")
                if (visited[nextX][nextY]) {
                    currentX = nextX
                    currentY = nextY
                    continue
                }
                if (!visited[nextX][nextY]) {
                    result.add(intArrayOf(nextX, nextY))
                    visited[nextX][nextY] = true
                    count++
                    currentX = nextX
                    currentY = nextY
                    val nextDir = (currentDir + 1) % 4
                    if (currentX + dirs[nextDir][0] < 0 || currentX + dirs[nextDir][0] > rows - 1 ||
                        currentY + dirs[nextDir][1] < 0 || currentY + dirs[nextDir][1] > cols - 1 ||
                        !visited[currentX + dirs[nextDir][0]][currentY + dirs[nextDir][1]]
                    ) {
                        currentDir = nextDir
                    }
                }
            }
            return result.toTypedArray()
        }

        // x x x x x x x
        // x 4 5 5 5 x x
        // x 4 o 1 6 x x
        // x 3 3 2 6 x x
        // x x x x 6 x x
        // x x x x x x x
        fun spiralMatrixIIIWebSolution(rows: Int, cols: Int, rStart: Int, cStart: Int): Array<IntArray> {
            val result: MutableList<IntArray> = mutableListOf()
            result.add(intArrayOf(rStart, cStart))
            val dirs = arrayOf(intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(-1, 0))
            var count = 1
            var steps = 0
            var currentX = rStart
            var currentY = cStart
            var currentDir = 0
            while (count < rows * cols) {
                for (step in 0..steps / 2) {
                    currentX += dirs[currentDir][0]
                    currentY += dirs[currentDir][1]
                    if (currentX >= 0 && currentX <= rows - 1 && currentY >= 0 && currentY <= cols - 1) {
                        result.add(intArrayOf(currentX, currentY))
                        count++
                    }
                }
                steps++
                currentDir = (currentDir + 1) % 4
            }
            return result.toTypedArray()
        }
    }
}