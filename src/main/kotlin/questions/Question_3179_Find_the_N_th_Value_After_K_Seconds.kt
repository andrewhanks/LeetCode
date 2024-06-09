package questions

class Question_3179_Find_the_N_th_Value_After_K_Seconds {

    companion object {

        fun runQuestion() {
//            Input: n = 4, k = 5
//            Output: 56
            val n = 4
            val k = 5
            val result = valueAfterKSeconds(n, k)
            println("Question 3179: $result")
        }

        fun valueAfterKSeconds(n: Int, k: Int): Int {
            val result = Array(n) { 1L }
            for (count in 1..k) {
                var temp = 1L
                for (i in 1..n - 1) {
                    result[i] += temp
                    result[i] = result[i] % (1000000000 + 7)
                    temp = result[i]
                }
            }
            return (result[n - 1] % (1000000000 + 7)).toInt()
        }
    }
}