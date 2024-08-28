package questions

class Question_278_First_Bad_Version {

    companion object {

        val bad = 4
        fun runQuestion() {
//            Input: n = 5, bad = 4
//            Output: 4
            val n = 5
            val result = firstBadVersion(n)
            println("Question 278: $result")
        }

        fun firstBadVersion(n: Int): Int {
            var start = 0
            var end = n
            while (start < end) {
                val mid = start + (end - start) / 2
                if (isBadVersion(mid)) {
                    end = mid
                } else {
                    start = mid + 1
                }
            }
            return start
        }

        fun isBadVersion(version: Int): Boolean {
            return version == bad
        }
    }
}