package questions


class Question_2745_Construct_the_Longest_New_String {

    companion object {

        fun runQuestion() {
//            Input: x = 2, y = 5, z = 1
//            Output: 12
            val x = 2
            val y = 5
            val z = 1
            val result = longestString(x, y, z)
            println("Question 2745: $result")
        }

        fun longestString(x: Int, y: Int, z: Int): Int {
            var total = 0
            if (x > y) {
                total += y + y + 1
            } else if (x < y) {
                total += x + x + 1
            } else {
                total += x + y
            }
            total += z
            return total * 2
        }
    }
}