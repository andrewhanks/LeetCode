package questions

class Question_1359_Count_All_Valid_Pickup_and_Delivery_Options {

    companion object {

        fun runQuestion() {
//            Input: n = 3
//            Output: 90
            val n = 3
            val result = countOrders(n)
            println("Question 1359: $result")
        }

        fun countOrders(n: Int): Int {
            val mod = 1_000_000_007
            var ans = 1L
            for (i in 1..n - 1) {
                val space = 2 * i + 1
                ans = ans * ((1 + space) * space / 2)
                ans = ans % mod
            }
            return ans.toInt()
        }
    }
}