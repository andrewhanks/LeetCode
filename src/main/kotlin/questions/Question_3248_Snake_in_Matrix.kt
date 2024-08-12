package questions

class Question_3248_Snake_in_Matrix {

    companion object {

        fun runQuestion() {
//            Input: n = 3, commands = ["DOWN","RIGHT","UP"]
//            Output: 1
            val n = 3
            val commands = listOf("DOWN", "RIGHT", "UP")
            val result = finalPositionOfSnake(n, commands)
            println("Question 3248: $result")
        }

        fun finalPositionOfSnake(n: Int, commands: List<String>): Int {
            val pos = IntArray(2) { 0 }
            for (count in 0..commands.size - 1) {
                if ("RIGHT" == commands[count]) {
                    pos[1]++
                } else if ("DOWN" == commands[count]) {
                    pos[0]++
                } else if ("UP" == commands[count]) {
                    pos[0]--
                } else {
                    pos[1]--
                }
            }
            return n * pos[0] + pos[1]
        }
    }
}