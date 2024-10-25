package questions

import kotlin.math.pow

class Question_2457_Minimum_Addition_to_Make_Integer_Beautiful {

    companion object {

        fun runQuestion() {
//            Input: n = 467, target = 6
//            Output: 33
            val n = 467L
            val target = 6
            val result = makeIntegerBeautiful(n, target)
            println("Question 2457: $result")
        }

        fun makeIntegerBeautiful(n: Long, target: Int): Long {
            var current = n
            var ans = 0L
            var exponent = 10L
            while (!check(current, target)) {
                if (current % exponent == 0L) {
                    exponent *= 10
                    continue
                }
                current = (current / exponent + 1) * exponent
                exponent *= 10
                ans = current - n
                // println("current = $current")
            }
            return ans
        }

        fun check(x: Long, target: Int): Boolean {
            var current = x
            var sum = 0L
            while (current != 0L) {
                sum += current % 10
                current = current / 10
            }
            return sum <= target.toLong()
        }
    }
}