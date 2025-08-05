package questions

import kotlin.math.min


class Question_3376_Minimum_Time_to_Break_Locks_I {

    companion object {

        fun runQuestion() {
//            Input: strength = [7,3,6,18,22,50], k = 4
//            Output: 12
            val strength = listOf(7, 3, 6, 18, 22, 50)
            val k = 4
            val result = findMinimumTime(strength, k)
            println("Question 3376: $result")
        }

        fun findMinimumTime(strength: List<Int>, k: Int): Int {
            val broken = Array(strength.size) { false }
            return dfs(strength, k, 1, broken)
        }

        fun dfs(strength: List<Int>, k: Int, x: Int, broken: Array<Boolean>): Int {
            if (broken.filter { it == true }.size == broken.size) {
                return 0
            }
            var min = Int.MAX_VALUE
            for (i in 0..strength.size - 1) {
                if (broken[i]) {
                    continue
                }
                broken[i] = true
                val time = if (strength[i] % x == 0) {
                    strength[i] / x
                } else {
                    strength[i] / x + 1
                }
                min = min(min, dfs(strength, k, x + k, broken) + time)
                broken[i] = false
            }
            return min
        }
    }
}