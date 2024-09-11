package questions

import kotlin.math.max
import kotlin.math.min

class Question_1201_Ugly_Number_III {

    companion object {

        fun runQuestion() {
//            Input: n = 4, a = 2, b = 3, c = 4
//            Output: 6
            val n = 4
            val a = 2
            val b = 3
            val c = 4
            val result = nthUglyNumber(n, a, b, c)
            println("Question 1201: $result")
        }

        var aLong = 0L
        var bLong = 0L
        var cLong = 0L
        var ab = 0L
        var ac = 0L
        var bc = 0L
        var abc = 0L

        fun nthUglyNumber(n: Int, a: Int, b: Int, c: Int): Int {
            aLong = a.toLong()
            bLong = b.toLong()
            cLong = c.toLong()
            ab = lcm(aLong, bLong)
            ac = lcm(aLong, cLong)
            bc = lcm(bLong, cLong)
            abc = lcm(aLong, bc)
            var start = 0
            var end = 2 * 1000000000
            while (start < end) {
                val mid = start + (end - start) / 2
                if (check(n, mid)) {
                    end = mid
                } else {
                    start = mid + 1
                }
            }
            return start
        }

        fun check(n: Int, target: Int): Boolean {
            val order = target / aLong + target / bLong + target / cLong -
                    (target / ab + target / ac + target / bc) + target / abc
            return order >= n
        }

        fun lcm(a: Long, b: Long): Long {
            val big = max(a, b)
            val small = min(a, b)
            return a.toLong() * b / gcd(small, big)
        }

        fun gcd(small: Long, big: Long): Long {
            if (big % small == 0L) {
                return small
            } else {
                return gcd(big % small, small)
            }
        }
    }
}