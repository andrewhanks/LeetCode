package questions

import kotlin.math.max
import kotlin.math.min


class Question_2580_Count_Ways_to_Group_Overlapping_Ranges {

    companion object {

        fun runQuestion() {
//            Input: ranges = [[1,3],[10,20],[2,5],[4,8]]
//            Output: 4
            val grid = arrayOf(intArrayOf(1, 3), intArrayOf(10, 20), intArrayOf(2, 5), intArrayOf(4, 8))
            val result = countWays(grid)
            println("Question 2580: $result")
        }

        fun countWays(ranges: Array<IntArray>): Int {
            if (ranges.size == 1) {
                return 2
            }
            ranges.sortWith(Comparator { a, b ->
                a[0] - b[0]
            })
//            println("ranges = ${ranges.contentDeepToString()}")
            var group = 0
            var curRange = intArrayOf()
            for (count in 0..ranges.size - 1) {
                if (count == 0) {
                    curRange = ranges[count]
                    group++
                } else {
                    if (ranges[count][0] <= curRange[1]) {
                        curRange[0] = min(ranges[count][0], curRange[0])
                        curRange[1] = max(ranges[count][1], curRange[1])
                    } else {
                        curRange = ranges[count]
                        group++
                    }
                }
            }
            return calTotalCom(group)
        }

        fun calTotalCom(group: Int): Int {
            var mod = 1000000007
            var total = 1L
            for (count in 1..group) {
                total = total * 2 % mod
            }
            return total.toInt()
        }
    }
}