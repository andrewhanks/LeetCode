package questions

class Question_2698_Find_the_Punishment_Number_of_an_Integer {

    companion object {

        fun runQuestion() {
//            Input: n = 37
//            Output: 1478
            val n = 37
            val result = punishmentNumber(n)
            println("Question 2698: $result")
        }

        fun punishmentNumber(n: Int): Int {
            var ans = 0
            for (i in 1..n) {
                val square = i * i
                if (isPunishmentNumber(i, square, 0)) {
                    ans += square
                }
            }
            return ans
        }

        fun isPunishmentNumber(target: Int, current: Int, preSum: Int): Boolean {
            if (preSum + current == target) {
                return true
            }
            var delimiter = 10
            while (delimiter <= current) {
                val remainder = current % delimiter
                val quotient = current / delimiter
                // println("delimiter = $delimiter, remainder = $remainder, quotient = $quotient")
                if (isPunishmentNumber(target, quotient, preSum + remainder)) {
                    return true
                }
                delimiter *= 10
            }
            return false
        }
    }
}