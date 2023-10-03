package questions


class Question_200_Number_of_Islands {

    companion object {

        fun runQuestion() {
//            Input: grid = [
//            ["1","1","0","0","0"],
//            ["1","1","0","0","0"],
//            ["0","0","1","0","0"],
//            ["0","0","0","1","1"]
//            ]
//            Output: 3
            val charArray = arrayOf(
                charArrayOf('1', '1', '0', '0', '0'),
                charArrayOf('1', '1', '0', '0', '0'),
                charArrayOf('0', '0', '1', '0', '0'),
                charArrayOf('0', '0', '0', '1', '1')
            )
            val result = numIslands(charArray)
            println("Question 200: $result")
        }

        fun numIslands(grid: Array<CharArray>): Int {
            var count = 0
            for (x in 0..grid.size - 1) {
                for (y in 0..grid[0].size - 1) {
                    if (grid[x][y] == '1') {
                        dfs(grid, x, y)
                        count++
                    }
                }
            }
            return count
        }

        fun dfs(grid: Array<CharArray>, x: Int, y: Int) {
            if (x < 0 || y < 0 || x >= grid.size || y >= grid[0].size || grid[x][y] != '1') {
                return
            }
            grid[x][y] = '0'
            dfs(grid, x + 1, y)
            dfs(grid, x - 1, y)
            dfs(grid, x, y + 1)
            dfs(grid, x, y - 1)
        }
    }
}