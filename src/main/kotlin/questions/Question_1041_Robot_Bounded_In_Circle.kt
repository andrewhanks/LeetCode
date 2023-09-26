package questions

class Question_1041_Robot_Bounded_In_Circle {

    companion object {

        fun runQuestion() {
            // "GLRLLGLL"
            val inputString = "GLRLLGLL"
            val result = isRobotBounded(inputString)
            println("Question 1041: $result")
        }

        fun isRobotBounded(instructions: String): Boolean {
            val pos: MutableList<Int> = mutableListOf(0, 0, 0)
            instructions.forEach {
                when (it) {
                    'G' -> {
                        when (pos[2]) {
                            0 -> pos[1]++
                            1 -> pos[0]++
                            2 -> pos[1]--
                            3 -> pos[0]--
                        }
                        println(pos)
                    }

                    'L' -> {
                        pos[2] = (pos[2] + 1) % 4
                        println(pos)
                    }

                    'R' -> {
                        pos[2] = (pos[2] + 3) % 4
                        println(pos)
                    }
                }
            }
            return (pos[0] == 0 && pos[1] == 0) || pos[2] != 0
        }
    }
}