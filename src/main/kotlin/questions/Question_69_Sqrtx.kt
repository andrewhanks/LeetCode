package questions

class Question_69_Sqrtx {

    companion object {

        fun runQuestion() {
//            Input: x = 8
//            Output: 2
            val x = 8
            val result = mySqrt(x)
            println("Question 69: $result")
        }

        fun mySqrt(x: Int): Int {
            var start = 0
            var end = x
            if (x <= 1) {
                return x
            }
            while (start < end) {
                val mid = start.toLong() + (end - start) / 2
                if (mid * mid <= x) {
                    start = mid.toInt() + 1
                } else {
                    end = mid.toInt()
                }
            }
            return start - 1
        }

        fun mySqrtWithBruteForce(x: Int): Int {
            for (count in 0..65536) {
                if (count * count > x || count * count < 0) {
                    return count - 1
                }
            }
            return 0
        }

        fun mySqrtBinarySearch(x: Int): Int {
            if (x == 0) {
                return 0
            }
            var start = 1L
            var end = x.toLong()
            while (start < end) {
                val mid = start + (end - start) / 2
                println("start = $start, end = $end, mid = $mid")
                if (x.toLong() == mid * mid) {
                    return mid.toInt()
                }
                if (x.toLong() > mid * mid && x.toLong() < (mid + 1) * (mid + 1)) {
                    return mid.toInt()
                }
                if (x.toLong() > mid * mid) {
                    start = mid + 1
                } else {
                    end = mid - 1
                }
            }
            return start.toInt()
        }
    }
}