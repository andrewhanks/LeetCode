package questions

import kotlin.math.max

class Question_1024_Video_Stitching {

    companion object {

        fun runQuestion() {
            // clips = [[0,2],[4,6],[8,10],[1,9],[1,5],[5,9]], time = 10
            val inpuArray = arrayOf(
                intArrayOf(0, 2),
                intArrayOf(4, 6),
                intArrayOf(8, 10),
                intArrayOf(1, 9),
                intArrayOf(1, 5),
                intArrayOf(5, 9)
            )
            val time = 10
            val result = videoStitching(inpuArray, time)
            println("Question 1024: $result")
        }

        fun videoStitching(clips: Array<IntArray>, time: Int): Int {
            clips.sortBy { it[0] }
            val maxDistanceArray = IntArray(time + 1) { 0 }
            clips.forEachIndexed { index, value ->
                if (value[0] < time + 1 && maxDistanceArray[value[0]] < value[1]) {
                    maxDistanceArray[value[0]] = value[1]
                }
            }
            var curEnd = maxDistanceArray[0]
            var count = 1
            var result = 1
            while (curEnd < time) {
                var maxCoverEnd = 0
                for (n in count..curEnd) {
                    maxCoverEnd = max(maxCoverEnd, maxDistanceArray[n])
                }
                if (maxCoverEnd <= curEnd) {
                    return -1
                }
                count = curEnd + 1
                curEnd = maxCoverEnd
                result++
            }
            return result
        }
    }
}