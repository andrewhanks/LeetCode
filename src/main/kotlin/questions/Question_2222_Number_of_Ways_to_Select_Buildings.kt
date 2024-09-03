package questions

class Question_2222_Number_of_Ways_to_Select_Buildings {

    companion object {

        fun runQuestion() {
//            Input: s = "0001100100"
//            Output: 38
            val inputString = "0001100100"
            val result = numberOfWays(inputString)
            println("Question 2222: $result")
        }

        fun numberOfWays(s: String): Long {
            val cumulativeZero = IntArray(s.length) { 0 }
            val cumulativeOne = IntArray(s.length) { 0 }
            if (s[0] == '0') {
                cumulativeZero[0] = 1
            } else {
                cumulativeOne[0] = 1
            }
            for (count in 1..s.length - 1) {
                if (s[count] == '0') {
                    cumulativeZero[count] = cumulativeZero[count - 1] + 1
                    cumulativeOne[count] = cumulativeOne[count - 1]
                } else {
                    cumulativeOne[count] = cumulativeOne[count - 1] + 1
                    cumulativeZero[count] = cumulativeZero[count - 1]
                }
            }
            var ans = 0L
            for (count in 1..s.length - 2) {
                val prev = if (s[count] == '0') {
                    cumulativeOne[count - 1].toLong()
                } else {
                    cumulativeZero[count - 1].toLong()
                }
                val next = if (s[count] == '0') {
                    cumulativeOne[cumulativeOne.size - 1].toLong() - cumulativeOne[count - 1]
                } else {
                    cumulativeZero[cumulativeZero.size - 1].toLong() - cumulativeZero[count - 1]
                }
                ans += (prev * next)
            }
            return ans
        }
    }
}