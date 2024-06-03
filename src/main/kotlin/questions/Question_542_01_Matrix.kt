package questions


class Question_542_01_Matrix {

    companion object {

        fun runQuestion() {
//            Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
//            Output: [[0,0,0],[0,1,0],[1,2,1]]
            val people = arrayOf(
                intArrayOf(0, 0, 0),
                intArrayOf(0, 1, 0),
                intArrayOf(1, 1, 1)
            )
            val result = updateMatrix(people)
            println("Question 542: ${result.contentDeepToString()}")
        }

        fun updateMatrix(mat: Array<IntArray>): Array<IntArray> {
            val result = Array(mat.size) { IntArray(mat[0].size) { 0 } }
            for (i in 0..mat.size - 1) {
                for (j in 0..mat[0].size - 1) {
                    if (mat[i][j] == 0) {
                        count(mat, i - 1, j, 1, result)
                        count(mat, i + 1, j, 1, result)
                        count(mat, i, j - 1, 1, result)
                        count(mat, i, j + 1, 1, result)
                    }
                }
            }
            return result
        }

        fun count(mat: Array<IntArray>, i: Int, j: Int, count: Int, result: Array<IntArray>) {
            if (i < 0 || i > mat.size - 1 || j < 0 || j > mat[0].size - 1) {
                return
            }
            if (mat[i][j] == 0) {
                return
            }
            if (result[i][j] != 0 && result[i][j] <= count) {
                return
            }
            result[i][j] = count
            count(mat, i - 1, j, count + 1, result)
            count(mat, i + 1, j, count + 1, result)
            count(mat, i, j - 1, count + 1, result)
            count(mat, i, j + 1, count + 1, result)
        }
    }
}