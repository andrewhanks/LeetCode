package questions

class Question_2320_Count_Number_of_Ways_to_Place_Houses {

    companion object {

        fun runQuestion() {
//            Input: n = 2
//            Output: 9
            val n = 2
            val result = countHousePlacements(n)
            println("Question 2320: $result")
        }

        fun countHousePlacements(n: Int): Int {
            val mod = 1000000007
            var ans = 1L
            var prev = 1L
            for (count in 1..n) {
                val temp = ans % mod
                ans = (ans + prev) % mod
                prev = temp % mod
            }
            return ((ans * ans) % mod).toInt()
        }
    }
}