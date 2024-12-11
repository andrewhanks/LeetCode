package questions


class Question_1017_Convert_to_Base_Neg_2 {

    companion object {

        fun runQuestion() {
//            Input: n = 3
//            Output: "111"
            val n = 3
            val result = baseNeg2(n)
            println("Question 1017: $result")
        }

        fun baseNeg2(n: Int): String {
            var result = StringBuilder("")
            calculate(n, result)
            // println("result = ${result.toString()}")
            return result.toString()
        }

        fun calculate(n: Int, result: StringBuilder) {
            var temp = n
            val neg2 = -2
            while (temp != 1 && temp != 0) {
                if (temp % neg2 == 0) {
                    temp = temp / neg2
                    result.insert(0, 0)
                } else {
                    temp = (temp - 1) / neg2
                    result.insert(0, 1)
                }
            }
            if (temp == 0) {
                result.insert(0, 0)
            }
            if (temp == 1) {
                result.insert(0, 1)
            }
        }
    }
}