package questions

import java.util.*
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

        fun videoStitchingNewSolutionByMySelf(clips: Array<IntArray>, time: Int): Int {
            val queue = PriorityQueue<IntArray> { a, b ->
                if (a[0] == b[0]) {
                    b[1] - a[1]
                } else {
                    a[0] - b[0]
                }
            }

            var start = -1
            var end = -1
            var current = -1
            var ans = 0

            for (clip in clips) {
                queue.add(clip)
            }

            if (!queue.isEmpty()) {
                val clip = queue.remove()
                // println("clip = ${clip.contentToString()}")
                if (start == -1 && end == -1) {
                    start = clip[0]
                    end = clip[1]
                    current = clip[1]
                    ans++
                }
            }

            while (!queue.isEmpty()) {
                if (current >= time) {
                    if (start > 0) {
                        return -1
                    } else {
                        return ans
                    }
                }
                if (queue.peek()[0] > end) {
                    return -1
                }
                while (!queue.isEmpty() && queue.peek()[0] <= current) {
                    val anotherClip = queue.remove()
                    // println("anotherClip = ${anotherClip.contentToString()}")
                    end = max(end, anotherClip[1])
                }
                current = end
                ans++
            }

            if (end < time || start > 0) {
                return -1
            } else {
                return ans
            }
        }
    }
}