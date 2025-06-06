package questions

import java.util.*
import kotlin.math.abs
import kotlin.math.max


class Question_3143_Maximum_Points_Inside_the_Square {

    companion object {

        fun runQuestion() {
//            Input: points = [[2,2],[-1,-2],[-4,4],[-3,1],[3,-3]], s = "abdca"
//            Output: 2
            val points =
                arrayOf(intArrayOf(2, 2), intArrayOf(-1, -2), intArrayOf(-4, 4), intArrayOf(-3, 1), intArrayOf(3, -3))
            val s = "abdca"
            val result = maxPointsInsideSquare(points, s)
            println("Question 3143: $result")
        }

        fun maxPointsInsideSquare(points: Array<IntArray>, s: String): Int {
            val result: TreeMap<Int, MutableList<Char>> = TreeMap()
            for (i in 0..points.size - 1) {
                val max = max(abs(points[i][0]), abs(points[i][1]))
                val list = result.getOrDefault(max, mutableListOf())
                list.add(s[i])
                result[max] = list
            }
            var ans = 0
            var used: MutableSet<Char> = mutableSetOf()
            // println("result = $result")
            for ((key, value) in result) {
                val item = value
                var contained = false
                for (ch in item) {
                    ans++
                    if (used.contains(ch)) {
                        contained = true
                    } else {
                        used.add(ch)
                    }
                }
                if (contained) {
                    ans = ans - item.size
                    break
                }
            }
            return ans
        }

        fun maxPointsInsideSquareByBinarySearch(points: Array<IntArray>, s: String): Int {
            var start = 0
            var end = Int.MAX_VALUE
            while (start < end) {
                val mid = end - (end - start) / 2
                val temp = check(points, s, mid)
                if (temp < 0) {
                    end = mid - 1
                } else {
                    start = mid
                }
            }
            val ans = check(points, s, start)
            return ans
        }

        fun check(points: Array<IntArray>, s: String, mid: Int): Int {
            val set: MutableSet<Char> = mutableSetOf()
            var ret = 0
            for (i in 0..points.size - 1) {
                val max = max(abs(points[i][0]), abs(points[i][1]))
                if (max <= mid) {
                    if (set.contains(s[i])) {
                        return -1
                    }
                    set.add(s[i])
                    ret++
                }
            }
            return ret
        }
    }
}