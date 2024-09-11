package questions

class Question_1482_Minimum_Number_of_Days_to_Make_m_Bouquets {

    companion object {

        fun runQuestion() {
//            Input: bloomDay = [7,7,7,7,12,7,7], m = 2, k = 3
//            Output: 12
            val bloomDay = intArrayOf(7, 7, 7, 7, 12, 7, 7)
            val m = 2
            val k = 3
            val result = minDays(bloomDay, m, k)
            println("Question 1482: $result")
        }

        fun minDays(bloomDay: IntArray, m: Int, k: Int): Int {
            if (bloomDay.size < m.toLong() * k) {
                return -1
            }
            var start = 0
            var end = bloomDay.max()
            while (start < end) {
                val mid = start + (end - start) / 2
                if (check(bloomDay, m, k, mid)) {
                    end = mid
                } else {
                    start = mid + 1
                }
            }
            return start
        }

        fun check(bloomDay: IntArray, m: Int, k: Int, mid: Int): Boolean {
            var bouquet = 0
            var number = 0
            for (bloom in bloomDay) {
                if (bloom <= mid) {
                    number++
                } else {
                    number = 0
                }
                if (number / k >= 1) {
                    bouquet++
                }
                number = number % k
            }
            return bouquet >= m
        }
    }
}