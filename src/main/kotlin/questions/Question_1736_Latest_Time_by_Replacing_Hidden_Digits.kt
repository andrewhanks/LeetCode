package questions

class Question_1736_Latest_Time_by_Replacing_Hidden_Digits {

    companion object {

        fun runQuestion() {
//            Input: time = "2?:?0"
//            Output: "23:50"
            val time = "2?:?0"
            val result = maximumTime(time)
            println("Question 1736: $result")
        }

        fun maximumTime(time: String): String {
            val result = StringBuilder(time)
            for (count in 0..result.length - 1) {
                if (count == 0 && result[count] == '?') {
                    if (result[count + 1] == '0' || result[count + 1] == '1' ||
                        result[count + 1] == '2' || result[count + 1] == '3' ||
                        result[count + 1] == '?'
                    ) {
                        result[count] = '2'
                    } else {
                        result[count] = '1'
                    }
                } else if (count == 1 && result[count] == '?') {
                    if (result[count - 1] == '2') {
                        result[count] = '3'
                    } else {
                        result[count] = '9'
                    }
                } else if (count == 3 && result[count] == '?') {
                    result[count] = '5'
                } else if (count == 4 && result[count] == '?') {
                    result[count] = '9'
                } else {
                }
            }
            return result.toString()
        }
    }
}