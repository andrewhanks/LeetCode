package questions


class Question_3025_Find_the_Number_of_Ways_to_Place_People_I {

    companion object {

        fun runQuestion() {
//            Input: points = [[6,2],[4,4],[2,6]]
//            Output: 2
            val grid = arrayOf(intArrayOf(6, 2), intArrayOf(4, 4), intArrayOf(2, 6))
            val result = numberOfPairs(grid)
            println("Question 3025: $result")
        }

        fun numberOfPairs(points: Array<IntArray>): Int {
            points.sortWith(Comparator { a, b ->
                if (a[0] != b[0]) {
                    b[0] - a[0]
                } else {
                    a[1] - b[1]
                }
            })
            var ans = 0
            for (i in 0..points.size - 1) {
                var y = Int.MAX_VALUE
                for (j in i + 1..points.size - 1) {
                    if (points[j][1] >= y || points[i][1] > points[j][1]) {
                        continue
                    }
                    ans++
                    y = points[j][1]
                }
            }
            return ans
        }
    }
}