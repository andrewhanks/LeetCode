package questions

import kotlin.math.min

class Question_2712_Minimum_Cost_to_Make_All_Characters_Equal {

    companion object {

        fun runQuestion() {
//            Input: s = "010101"
//            Output: 9
            val s = "010101"
            val result = minimumCost(s)
            println("Question 2712: $result")
        }

        fun minimumCost(s: String): Long {
            if (s.length == 1) {
                return 0L
            }
            var ans = 0L
            val len = s.length
            if (len % 2 == 0) {
                ans = min(calculate(s, len / 2 - 1, '0'), calculate(s, len / 2 - 1, '1'))
            } else {
                ans = min(
                    min(calculate(s, len / 2 - 1, '0'), calculate(s, len / 2 - 1, '1')),
                    min(calculate(s, len / 2, '0'), calculate(s, len / 2, '1'))
                )
            }
            return ans
        }

        fun calculate(s: String, center: Int, target: Char): Long {
            var sum = 0L
            var prev = s[center]
            var change = if (s[center] != target) {
                sum++
                1
            } else {
                0
            }
            for (i in center - 1 downTo 0) {
                if (s[i] != prev) {
                    change++
                    sum += change
                } else {
                    sum += change
                }
                prev = s[i]
            }
            prev = s[center + 1]
            change = if (s[center + 1] != target) {
                sum++
                1
            } else {
                0
            }
            for (i in center + 2..s.length - 1) {
                if (s[i] != prev) {
                    change++
                    sum += change
                } else {
                    sum += change
                }
                prev = s[i]
            }
            return sum
        }
    }
}