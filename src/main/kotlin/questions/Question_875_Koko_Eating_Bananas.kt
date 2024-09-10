package questions

class Question_875_Koko_Eating_Bananas {

    companion object {

        fun runQuestion() {
//            Input: piles = [3,6,7,11], h = 8
//            Output: 4
            val piles = intArrayOf(3, 6, 7, 11)
            val h = 8
            val result = minEatingSpeed(piles, h)
            println("Question 875: $result")
        }

        fun minEatingSpeed(piles: IntArray, h: Int): Int {
            var start = 1
            var end = piles.max()
            while (start < end) {
                val mid = start + (end - start) / 2
                if (check(piles, h, mid)) {
                    end = mid
                } else {
                    start = mid + 1
                }
            }
            return start
        }

        fun check(piles: IntArray, h: Int, k: Int): Boolean {
            var total = 0
            for (pile in piles) {
                if (pile % k != 0) {
                    total += pile / k + 1
                } else {
                    total += pile / k
                }
            }
            return total <= h
        }
    }
}