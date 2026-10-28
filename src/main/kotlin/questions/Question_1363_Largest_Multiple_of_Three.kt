package questions

class Question_1363_Largest_Multiple_of_Three {

    companion object {

        fun runQuestion() {
//            Input: digits = [8,6,7,1,0]
//            Output: "8760"
            val digits = intArrayOf(8, 6, 7, 1, 0)
            val result = largestMultipleOfThree(digits)
            println("Question 1363: $result")
        }

        fun largestMultipleOfThree(digits: IntArray): String {
            val sum = digits.sum()
            digits.sort()
            var answer = ""
            when (sum % 3) {
                0 -> {
                    digits.reversed().forEach {
                        answer += it
                    }
                }

                1 -> {
                    var restOnePos = -1
                    var restTwoPos1 = -1
                    var restTwoPos2 = -1
                    val temp = digits.toMutableList()
                    for (i in 0..temp.size - 1) {
                        if (temp[i] % 3 == 1) {
                            restOnePos = i
                            break
                        }
                        if (restTwoPos1 != -1 && temp[i] % 3 == 2 && restTwoPos2 == -1) {
                            restTwoPos2 = i
                        } else if (temp[i] % 3 == 2 && restTwoPos1 == -1) {
                            restTwoPos1 = i
                        }
                    }
                    // println("restOnePos = $restOnePos, restTwoPos2 = $restTwoPos2, restTwoPos1 = $restTwoPos1")
                    if (restOnePos != -1) {
                        temp.removeAt(restOnePos)
                    } else {
                        temp.removeAt(restTwoPos2)
                        temp.removeAt(restTwoPos1)
                    }
                    temp.reversed().forEach {
                        answer += it
                    }
                }

                2 -> {
                    var restTwoPos = -1
                    var restOnePos1 = -1
                    var restOnePos2 = -1
                    val temp = digits.toMutableList()
                    for (i in 0..temp.size - 1) {
                        if (temp[i] % 3 == 2) {
                            restTwoPos = i
                            break
                        }
                        if (restOnePos1 != -1 && temp[i] % 3 == 1 && restOnePos2 == -1) {
                            restOnePos2 = i
                        } else if (temp[i] % 3 == 1 && restOnePos1 == -1) {
                            restOnePos1 = i
                        }
                    }
                    if (restTwoPos != -1) {
                        temp.removeAt(restTwoPos)
                    } else {
                        temp.removeAt(restOnePos2)
                        temp.removeAt(restOnePos1)
                    }
                    temp.reversed().forEach {
                        answer += it
                    }
                }
            }
            val original = StringBuilder(answer)
            answer = answer.trimStart('0')
            if (original.length > 0 && answer.isEmpty()) {
                answer = "0"
            }
            return answer
        }
    }
}