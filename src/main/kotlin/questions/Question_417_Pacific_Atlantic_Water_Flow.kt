package questions


class Question_417_Pacific_Atlantic_Water_Flow {

    companion object {

        fun runQuestion() {
//            Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
//            Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
            val graph = arrayOf(
                intArrayOf(1, 2, 2, 3, 5),
                intArrayOf(3, 2, 3, 4, 4),
                intArrayOf(2, 4, 5, 3, 1),
                intArrayOf(6, 7, 1, 4, 5),
                intArrayOf(5, 1, 1, 2, 4)
            )
            val resultList = pacificAtlantic(graph)
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
            println("Question 417: $result")
        }

        fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
            val pac = Array(heights.size) { Array(heights[0].size) { false } }
            val atl = Array(heights.size) { Array(heights[0].size) { false } }
            for (i in 0..heights.size - 1) {
                for (j in 0..heights[0].size - 1) {
                    if (i == 0 || j == 0) {
                        dfs(heights, i, j, pac, 0)
                    }
                    if (i == heights.size - 1 || j == heights[0].size - 1) {
                        dfs(heights, i, j, atl, 0)
                    }
                }
            }
            val result: MutableList<MutableList<Int>> = mutableListOf()
            for (i in 0..heights.size - 1) {
                for (j in 0..heights[0].size - 1) {
                    if (pac[i][j] && atl[i][j]) {
                        result.add(mutableListOf(i, j))
                    }
                }
            }
            return result
        }

        fun dfs(heights: Array<IntArray>, i: Int, j: Int, ocean: Array<Array<Boolean>>, previous: Int) {
            if (i < 0 || i > heights.size - 1 || j < 0 || j > heights[0].size - 1) {
                return
            }
            if (ocean[i][j]) {
                return
            }
            if (heights[i][j] < previous) {
                return
            }
            ocean[i][j] = true
            dfs(heights, i - 1, j, ocean, heights[i][j])
            dfs(heights, i + 1, j, ocean, heights[i][j])
            dfs(heights, i, j - 1, ocean, heights[i][j])
            dfs(heights, i, j + 1, ocean, heights[i][j])
        }
    }
}