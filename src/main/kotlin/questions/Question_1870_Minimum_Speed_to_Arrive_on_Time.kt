package questions

import kotlin.math.ceil

class Question_1870_Minimum_Speed_to_Arrive_on_Time {

    companion object {

        fun runQuestion() {
//            Input: dist = [1,3,2], hour = 6
//            Output: 1
            val dist = intArrayOf(1, 3, 2)
            val hour = 6.0
            val result = minSpeedOnTime(dist, hour)
            println("Question 1870: $result")
        }

        fun minSpeedOnTime(dist: IntArray, hour: Double): Int {
            if (ceil(hour) < dist.size) {
                return -1
            }
            var start = 1
            var end = 10000000
            while (start < end) {
                val mid = start + (end - start) / 2
                // println("start = $start, end = $end, mid = $mid")
                if (count(dist, mid) <= hour) {
                    end = mid
                } else {
                    start = mid + 1
                }
            }
            return start
        }

        fun count(dist: IntArray, mid: Int): Double {
            var ret = 0.0
            for (count in 0..dist.size - 1) {
                val realHour = dist[count] / mid.toDouble()
                if (count == dist.size - 1) {
                    ret += realHour
                } else {
                    ret += ceil(realHour)
                }
            }
            return ret
        }
    }
}