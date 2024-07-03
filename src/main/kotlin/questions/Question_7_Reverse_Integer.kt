package questions

class Question_7_Reverse_Integer {

    companion object {

        fun runQuestion() {
//            Input: x = -123
//            Output: -321
            val x = -123
            val result = reverse(x)
            println("Question 7: $result")
        }

        fun reverse(x: Int): Int {
            var reversedLong = 0L
            var tempX = x
            while (tempX != 0) {
                val remain = tempX % 10
                reversedLong = reversedLong * 10 + remain
                tempX = tempX / 10
            }
            if (reversedLong < Int.MIN_VALUE || reversedLong > Int.MAX_VALUE) {
                return 0
            } else {
                return reversedLong.toInt()
            }
        }

        fun reverseAnotherSolution(x: Int): Int {
            var stringX = x.toString()
            val smallThanZero = stringX[0] == '-'
            val reversedLong = if (smallThanZero) {
                -(stringX.substring(1..stringX.length - 1).reversed().toLong())
            } else {
                stringX.reversed().toLong()
            }
            if (reversedLong < Int.MIN_VALUE || reversedLong > Int.MAX_VALUE) {
                return 0
            } else {
                return reversedLong.toInt()
            }
        }
    }
}