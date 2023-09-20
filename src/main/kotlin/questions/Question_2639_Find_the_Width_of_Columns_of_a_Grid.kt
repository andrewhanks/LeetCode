package questions

class Question_2639_Find_the_Width_of_Columns_of_a_Grid {

    companion object {

        fun runQuestion() {
            // [[-15,1,3],[15,7,12],[5,6,-2]]
            val intArray1 = intArrayOf(-15, 1, 3)
            val intArray2 = intArrayOf(15, 7, 12)
            val intArray3 = intArrayOf(5, 6, -2)
            val twoDimenIntArray = arrayOf(intArray1, intArray2, intArray3)
            val resultList = findColumnWidth(twoDimenIntArray)
            var result = "["
            resultList.forEachIndexed { index, i ->
                result += i
                if (index == resultList.size - 1) {
                    result += "]"
                } else {
                    result += ","
                }
            }
            println("Question 2639: $result")
        }

        fun findColumnWidth(grid: Array<IntArray>): IntArray {
            val resultArray: MutableList<Int> = mutableListOf()
            // println("grid.size = "+grid.size+", grid[0].size = "+grid[0].size)
            for (n in 0..grid[0].size - 1) {
                for (m in 0..grid.size - 1) {
                    // println("grid[m][n] = "+grid[m][n])
                    val tempLength = grid[m][n].toString().length
                    // println("tempLength = "+tempLength+", resultArray.size = "+resultArray.size+", n = "+n)
                    // if(resultArray.size>n) {
                    //     println("resultArray[n] = "+resultArray[n])
                    // }
                    if (resultArray.size > n && resultArray[n] < tempLength) {
                        resultArray[n] = tempLength
                    } else if (resultArray.size <= n) {
                        resultArray.add(tempLength)
                    }
                }
                // println("resultArray.size = "+resultArray.size)
            }
            return resultArray.toIntArray()
        }
    }
}