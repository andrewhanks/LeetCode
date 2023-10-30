package questions

class Question_69_Sqrtx {

    companion object {

        fun runQuestion() {
//            Input: x = 8
//            Output: 2
            val x = 8
            val result = mySqrt(x)
            println("Question 69: $result")
        }

        fun mySqrt(x: Int): Int {
            for (count in 0..65536) {
                if (count * count > x || count * count < 0) {
                    return count - 1
                }
            }
            return 0
        }
    }
}