package questions

class Question_74_Search_a_2D_Matrix {

    companion object {

        fun runQuestion() {
//            Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//            Output: true
            val numberArray = arrayOf(intArrayOf(1, 3, 5, 7), intArrayOf(10, 11, 16, 20), intArrayOf(23, 30, 34, 60))
            val target = 3
            val result = searchMatrix(numberArray, target)
            println("Question 74: $result")
        }

        fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
            for (count in 0..matrix.size - 1) {
                if (matrix[count].contains(target)) {
                    return true
                }
            }
            return false
        }
    }
}