package questions


class Question_2187_Minimum_Time_to_Complete_Trips {

    companion object {

        fun runQuestion() {
//            Input: time = [1,2,3], totalTrips = 5
//            Output: 3
            val time = intArrayOf(1, 2, 3)
            val totalTrips = 5
            val result = minimumTime(time, totalTrips)
            println("Question 2187: $result")
        }

        fun minimumTime(time: IntArray, totalTrips: Int): Long {
            var start: Long = 1L
            var end: Long = totalTrips * time.max().toLong()
            while (start < end) {
                val mid = start + (end - start) / 2
                // println("start = $start, end = $end, mid = $mid")
                val trips = calculateTrips(time, mid)
                if (trips >= totalTrips) {
                    end = mid
                } else {
                    start = mid + 1
                }
            }
            return start
        }

        fun calculateTrips(time: IntArray, targetTime: Long): Long {
            var ans = 0L
            for (count in 0..time.size - 1) {
                ans += (targetTime / time[count])
            }
            return ans
        }
    }
}