package questions


class Question_354_Russian_Doll_Envelopes {

    companion object {

        fun runQuestion() {
//            Input: envelopes = [[5,4],[6,4],[6,7],[2,3]]
//            Output: 3
            val envelopes = arrayOf(intArrayOf(5, 4), intArrayOf(6, 4), intArrayOf(6, 7), intArrayOf(2, 3))
            val result = maxEnvelopes(envelopes)
            println("Question 354: $result")
        }

        fun maxEnvelopes(envelopes: Array<IntArray>): Int {
            envelopes.sortWith(Comparator { a, b ->
                if (a[0] == b[0]) {
                    b[1] - a[1]
                } else {
                    a[0] - b[0]
                }
            })

            val dp = IntArray(envelopes.size)
            var size = 0
            for (e in envelopes) {
                var left = 0
                var right = size
                while (left < right) {
                    val mid = left + (right - left) / 2
                    if (dp[mid] < e[1]) {
                        left = mid + 1
                    } else {
                        right = mid
                    }
                }
                dp[left] = e[1]
                if (left == size) {
                    size++
                }
            }
            return size
        }
    }
}