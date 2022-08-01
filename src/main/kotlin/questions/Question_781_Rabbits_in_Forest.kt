package questions

class Question_781_Rabbits_in_Forest {

    companion object {

        fun runQuestion() {
            val numberArray = intArrayOf(1, 1, 2)
            val result = numRabbits(numberArray)
            println("Question 781: $result")
        }

        fun numRabbits(answers: IntArray): Int {
            val resultMap = mutableMapOf<Int, Int>()
            var totalMinNumber = 0
            for (number in answers) {
                if (0 != number) {
                    if (!resultMap.contains(number)) {
                        resultMap[number] = 1
                    } else {
                        resultMap[number] = resultMap[number]!! + 1
                    }
                } else if (0 == number) {
                    totalMinNumber += 1
                }
            }
            for ((key, value) in resultMap) {
                totalMinNumber += if (value <= key + 1) {
                    key + 1
                } else {
                    val group = (value / (key + 1))
                    if (0 == value % (key + 1)) {
                        group * (key + 1)
                    } else {
                        group * (key + 1) + (key + 1)
                    }
                }
            }
            return totalMinNumber
        }
    }
}