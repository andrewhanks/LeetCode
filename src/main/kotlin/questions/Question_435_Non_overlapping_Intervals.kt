package questions


class Question_435_Non_overlapping_Intervals {

    companion object {

        fun runQuestion() {
//            Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
//            Output: 1
            val intervals = arrayOf(intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(3, 4), intArrayOf(1, 3))
            val result = eraseOverlapIntervals(intervals)
            println("Question 435: $result")
        }

        fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
            intervals.sortWith(Comparator { a, b ->
                if (a[0] == b[0]) {
                    a[1] - b[1]
                } else {
                    a[0] - b[0]
                }
            })
            println(intervals.contentDeepToString())
            val result: MutableList<IntArray> = mutableListOf()
            result.add(intervals[0])
            var drop = 0
            for (count in 1..intervals.size - 1) {
                val interval = intervals[count]
                val compared = result[result.size - 1]
                if (interval[0] < compared[1] && interval[1] >= compared[1]) {
                    drop++
                } else if (interval[0] < compared[1] && interval[1] < compared[1]) {
                    result[result.size - 1] = interval
                    drop++
                } else {
                    result.add(interval)
                }
                // println("result = ${result.toTypedArray().contentDeepToString()}, drop = $drop")
            }
            return drop
        }

        fun eraseOverlapIntervalsOld(intervals: Array<IntArray>): Int {
            intervals.sortBy { it[1] }
            val covered = IntArray(2) { 0 }
            var dropCount = 0
            for (count in 0..intervals.size - 1) {
                val temp = intervals[count]
                if (covered[0] == 0 && covered[1] == 0) {
                    covered[0] = temp[0]
                    covered[1] = temp[1]
                } else {
                    if (temp[0] < covered[1]) {
                        dropCount++
                    } else {
                        covered[1] = temp[1]
                    }
                }
            }
            return dropCount
        }
    }
}