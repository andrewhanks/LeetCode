package questions

class Question_2235_Add_Two_Integers {

    companion object {

        fun runQuestion() {
//            Input: num1 = 12, num2 = 5
//            Output: 17
            val numCarpets = 12
            val carpetLen = 5
            val result = sum(numCarpets, carpetLen)
            println("Question 2235: $result")
        }

        fun sum(num1: Int, num2: Int): Int {
            return num1 + num2
        }
    }
}