package questions

class Question_2550_Count_Collisions_of_Monkeys_on_a_Polygon {

    companion object {

        fun runQuestion() {
//            Input: n = 4
//            Output: 14
            val n = 4
            val result = monkeyMove(n)
            println("Question 2550: $result")
        }

        val mod = 1000000007

        fun monkeyMove(n: Int): Int {
            var ans = calculate(n)
            if (ans - 2 < 0L) {
                ans = ans - 2 + mod
            } else {
                ans = ans - 2
            }
            return ans.toInt()
        }

        fun calculate(n: Int): Long {
            if (n == 1) {
                return 2
            }
            val ret = calculate(n / 2)
            if (n % 2 == 0) {
                return ret * ret % mod
            } else {
                return ret * ret * 2 % mod
            }
        }

        fun monkeyMoveWithMap(n: Int): Int {
            val map: MutableMap<Int, Long> = mutableMapOf()
            var ans = calculate(n, map)
            if (ans - 2 < 0L) {
                ans = ans - 2 + mod
            } else {
                ans = ans - 2
            }
            return ans.toInt()
        }

        fun calculate(n: Int, map: MutableMap<Int, Long>): Long {
            if (n == 1) {
                return 2
            }
            if (map[n] != null) {
                return map[n]!!
            }
            if (n % 2 == 0) {
                map[n] = calculate(n / 2, map) * calculate(n / 2, map) % mod
            } else {
                map[n] = calculate(n / 2, map) * calculate(n / 2 + 1, map) % mod
            }
            return map[n]!!
        }
    }
}