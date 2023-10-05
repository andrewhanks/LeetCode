package questions

class Question_201_Bitwise_AND_of_Numbers_Range {

    companion object {

        fun runQuestion() {
            val left = 600000000
            val right = 2147483645
            val result = rangeBitwiseAndFromRight(left, right)
            println("Question 201: $result")
        }

        fun rangeBitwiseAndFromRight(left: Int, right: Int): Int {
            var result = right
            var count = right - 1
            while (count >= left) {
                println("$count, $result")
                result = result and count
                if (count == result) {
                    count--
                } else {
                    count = result
                }
            }
            return result
        }

        fun rangeBitwiseAndFromLeft(left: Int, right: Int): Int {
            if (left == right) {
                return left
            }
            var result = left
            for (count in left + 1..right) {
                result = result and count
                if (result == 0) {
                    return 0
                }
            }
            return result
        }
    }
}