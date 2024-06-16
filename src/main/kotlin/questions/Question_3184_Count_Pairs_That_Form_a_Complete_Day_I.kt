package questions

class Question_3184_Count_Pairs_That_Form_a_Complete_Day_I {

    companion object {

        fun runQuestion() {
//            Input: hours = [12,12,30,24,24]
//            Output: 2
            val array = intArrayOf(12, 12, 30, 24, 24)
            val result = countCompleteDayPairs(array)
            println("Question 3184: $result")
        }

        fun countCompleteDayPairs(hours: IntArray): Int {
            var result = 0
            for (i in 0..hours.size - 1) {
                for (j in i + 1..hours.size - 1) {
                    if ((hours[i] + hours[j]) % 24 == 0) {
                        result++
                    }
                }
            }
            return result
        }
    }
}