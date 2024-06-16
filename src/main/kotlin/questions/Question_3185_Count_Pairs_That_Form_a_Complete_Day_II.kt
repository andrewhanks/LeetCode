package questions

class Question_3185_Count_Pairs_That_Form_a_Complete_Day_II {

    companion object {

        fun runQuestion() {
//            Input: hours = [12,12,30,24,24]
//            Output: 2
            val array = intArrayOf(12, 12, 30, 24, 24)
            val result = countCompleteDayPairs(array)
            println("Question 3185: $result")
        }

        fun countCompleteDayPairs(hours: IntArray): Long {
            val result = IntArray(25) { 0 }
            for (count in 0..hours.size - 1) {
                val rest = hours[count] % 24
                result[rest] = result[rest]!! + 1
            }
            var finalResult = 0L
            println(result.contentToString())
            for (count in 0..result.size - 1) {
                if (count == 0 || count == 12) {
                    finalResult += (result[count].toLong() * (result[count].toLong() - 1)) / 2
                } else if (count < 12) {
                    finalResult += result[count] * result[24 - count]
                }
            }
            return finalResult
        }
    }
}