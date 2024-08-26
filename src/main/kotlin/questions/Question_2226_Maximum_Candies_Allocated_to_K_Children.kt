package questions


class Question_2226_Maximum_Candies_Allocated_to_K_Children {

    companion object {

        fun runQuestion() {
//            Input: candies = [5,8,6], k = 3
//            Output: 5
            val candies = intArrayOf(5, 8, 6)
            val k = 3L
            val result = maximumCandies(candies, k)
            println("Question 2226: $result")
        }

        fun maximumCandies(candies: IntArray, k: Long): Int {
            var start = 1
            var end = candies.max()
            var ans = 0
            while (start <= end) {
                val mid = start + (end - start) / 2
                var totalDivide = 0L
                for (count in 0..candies.size - 1) {
                    totalDivide += candies[count] / mid
                }
                if (totalDivide < k) {
                    end = mid - 1
                } else {
                    ans = mid
                    start = mid + 1
                }
            }
            return ans
        }
    }
}