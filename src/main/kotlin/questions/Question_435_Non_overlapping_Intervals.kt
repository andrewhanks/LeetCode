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