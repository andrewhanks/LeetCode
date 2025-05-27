package questions

import kotlin.math.max

class Question_2498_Frog_Jump_II {

    companion object {

        fun runQuestion() {
//            Input: stones = [0,2,5,6,7]
//            Output: 5
            val intArray = intArrayOf(0, 2, 5, 6, 7)
            val result = maxJump(intArray)
            println("Question 2498: $result")
        }

        fun maxJump(stones: IntArray): Int {
            if (stones.size <= 3) {
                return stones[stones.size - 1] - stones[0]
            }
            var ans = 0
            for (i in 0..stones.size - 3) {
                ans = max(ans, stones[i + 2] - stones[i])
            }
            return ans
        }
    }
}