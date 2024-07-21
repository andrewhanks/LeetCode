package questions

class Question_3228_Maximum_Number_of_Operations_to_Move_Ones_to_the_End {

    companion object {

        fun runQuestion() {
//            Input: s = "1001101"
//            Output: 4
            val s = "1001101"
            val result = maxOperations(s)
            println("Question 3228: $result")
        }

        fun maxOperations(s: String): Int {
            var oneNumber = 0
            var count = 0
            var ans = 0
            val stringBuilder = StringBuilder(s)
            while (count <= s.length - 2) {
                if (stringBuilder[count] == '1' && stringBuilder[count + 1] == '0') {
                    oneNumber++
                    ans += oneNumber
                    for (i in count + 1..stringBuilder.length - 2) {
                        if (stringBuilder[i] == '1') {
                            stringBuilder.setCharAt(i - 1, '1')
                            stringBuilder.setCharAt(count, '0')
                            count = i - 1
                            break
                        }
                    }
                } else if (stringBuilder[count] == '1') {
                    oneNumber++
                }
                count++
                // println("count = $count, oneNumber = $oneNumber, ans = $ans, stringBuilder = ${stringBuilder.toString()}")
            }
            return ans
        }
    }
}