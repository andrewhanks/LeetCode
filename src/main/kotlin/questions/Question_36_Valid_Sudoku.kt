package questions


class Question_36_Valid_Sudoku {

    companion object {

        fun runQuestion() {
//            [["5","3",".",".","7",".",".",".","."]
//            ,["6",".",".","1","9","5",".",".","."]
//            ,[".","9","8",".",".",".",".","6","."]
//            ,["8",".",".",".","6",".",".",".","3"]
//            ,["4",".",".","8",".","3",".",".","1"]
//            ,["7",".",".",".","2",".",".",".","6"]
//            ,[".","6",".",".",".",".","2","8","."]
//            ,[".",".",".","4","1","9",".",".","5"]
//            ,[".",".",".",".","8",".",".","7","9"]]
            val charArray = arrayOf(
                charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
                charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
                charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
                charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
                charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
                charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
                charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
                charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
                charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9'),
            )
            val result = isValidSudoku(charArray)
            println("Question 36: $result")
        }

        fun isValidSudoku(board: Array<CharArray>): Boolean {
            val elements: MutableSet<String> = mutableSetOf()
            for (x in 0..8) {
                for (y in 0..8) {
                    val current = board[x][y]
                    if (current == '.') {
                        continue
                    }
                    if (!elements.add(current + " in row " + x) ||
                        !elements.add(current + " in column " + y) ||
                        !elements.add(current + " in block " + x / 3 + "," + y / 3)
                    ) {
                        println("x = $x, y = $y, current = $current")
                        return false
                    }
                }
            }
            return true
        }

        fun isValidSudokuNormal(board: Array<CharArray>): Boolean {
            val tempArray: MutableList<Char> = mutableListOf()
            for (x in 0..8) {
                for (y in 0..8) {
                    val count = board[x].filter { it == board[x][y] && it != '.' }.count()
                    println("row = " + count)
                    if (count >= 2) {
                        return false
                    }
                }
            }
            for (x in 0..8) {
                tempArray.clear()
                for (y in 0..8) {
                    tempArray.add(board[y][x])
                }
                println(tempArray)
                for (y in 0..8) {
                    val count = tempArray.filter { it == tempArray[y] && it != '.' }.count()
                    println("column = " + count)
                    if (count >= 2) {
                        return false
                    }
                }
            }
            tempArray.clear()
            for (times in 1..9) {
                for (x in 0..6 step 3) {
                    for (y in 0..6 step 3) {
                        tempArray.add(board[x][y])
                        tempArray.add(board[x][y + 1])
                        tempArray.add(board[x][y + 2])
                        tempArray.add(board[x + 1][y])
                        tempArray.add(board[x + 1][y + 1])
                        tempArray.add(board[x + 1][y + 2])
                        tempArray.add(board[x + 2][y])
                        tempArray.add(board[x + 2][y + 1])
                        tempArray.add(board[x + 2][y + 2])
                        println(tempArray)
                        for (tempCount in 0..8) {
                            val count = tempArray.filter { it == tempArray[tempCount] && it != '.' }.count()
                            println("block = " + count)
                            if (count >= 2) {
                                return false
                            }
                        }
                        tempArray.clear()
                    }
                }
            }
            return true
        }
    }
}