package questions


class Question_1260_Shift_2D_Grid {

    companion object {

        fun runQuestion() {
            val intArray = arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9))
            val resultList = shiftGrid(intArray, 1)
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
            println("Question 1260: $result")
        }

        fun shiftGrid(grid: Array<IntArray>, k: Int): List<List<Int>> {
            val resultArray: MutableList<MutableList<Int>> = MutableList(grid.size) { MutableList(grid[0].size) { 0 } }
            for (x in 0..grid.size - 1) {
                for (y in 0..grid[0].size - 1) {
                    val resultX = (x + ((y + k) / grid[0].size)) % grid.size
                    val resultY = (y + k) % grid[0].size
                    resultArray[resultX][resultY] = grid[x][y]
                    println("grid[$x][$y] = " + grid[x][y] + ", resultArray[$resultX][$resultY] = " + grid[resultX][resultY])
                }
            }
            return resultArray
        }
    }
}