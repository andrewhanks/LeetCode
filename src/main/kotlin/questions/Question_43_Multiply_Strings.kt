package questions

class Question_43_Multiply_Strings {

    companion object {

        fun runQuestion() {
            val stringNumber1 = "123"
            val stringNumber2 = "456"
            val result = multiply(stringNumber1, stringNumber2)
            println("Question 43: $result")
        }

        fun multiply(num1: String, num2: String): String {
            val num1Length = num1.length
            val num2Length = num2.length
            val num1Reverse = num1.reversed()
            val num2Reverse = num2.reversed()

            val resultCharArray = CharArray(num1Length + num2Length)
            resultCharArray.forEachIndexed { index, c -> resultCharArray[index] = '0' }
            var resultString = String(resultCharArray)
            println(resultString)
            for (num1Count in 0..num1Length - 1) {
                for (num2Count in 0..num2Length - 1) {
                    val totalLength = num1Length + num2Length
                    val currentPosition = num2Count + num1Count
                    val tempResult =
                        num1Reverse[num1Count].toString().toInt() * num2Reverse[num2Count].toString().toInt()
                    var positionOriginalNumber = resultCharArray[currentPosition].toString().toInt()
                    var nextPositionOriginalNumber = resultCharArray[currentPosition + 1].toString().toInt()

                    nextPositionOriginalNumber += tempResult / 10
                    positionOriginalNumber += tempResult % 10

                    println(
                        "tempResult = ${tempResult}, " +
                                "positionOriginalNumber = ${positionOriginalNumber}, " +
                                "nextPositionOriginalNumber = ${nextPositionOriginalNumber}, " +
                                "num1Count = ${num1Count}, " +
                                "num2Count = ${num2Count}"
                    )

                    if (positionOriginalNumber > 9) {
                        resultCharArray[currentPosition] = (positionOriginalNumber % 10).toString().last()
                        nextPositionOriginalNumber++
                    } else {
                        resultCharArray[currentPosition] = positionOriginalNumber.toString().last()
                    }

//                    println("resultCharArray[currentPosition] = ${resultCharArray[currentPosition]}")

                    if (nextPositionOriginalNumber > 9) {
                        resultCharArray[currentPosition + 1] = (nextPositionOriginalNumber % 10).toString().last()
                        var count = 2
                        var isTenNotAdded = false
                        var isOverTen = true
                        whileStart@ while (currentPosition + count < totalLength && isOverTen) {
                            isOverTen = false
                            if ((resultCharArray[currentPosition + count].toString().toInt() + 1) > 9) {
                                isOverTen = true
                            }

                            resultCharArray[currentPosition + count] =
                                ((resultCharArray[currentPosition + count].toString().toInt() + 1) % 10).toString()
                                    .last()

                            println(
                                "count = ${count}, " +
                                        "resultCharArray[${currentPosition + count}] = ${resultCharArray[currentPosition + count]}, " +
                                        "resultCharArray[${currentPosition + count + 1}] = ${resultCharArray[currentPosition + count + 1]}"
                            )
                            println(
                                "(resultCharArray[currentPosition + count + 1].toString().toInt() + 1) = " +
                                        "${(resultCharArray[currentPosition + count + 1].toString().toInt() + 1)}"
                            )

                            resultString = String(resultCharArray).reversed()
                            println(resultString)
                            println("isOverTen = ${isOverTen}")
                            count++
                            isTenNotAdded = true
//                            if (!isOverTen) {
//                                break@whileStart
//                            }
                        }
                        if (!isTenNotAdded) {
                            resultCharArray[currentPosition + count] =
                                (resultCharArray[currentPosition + count].toString().toInt() + 1).toString().last()
                        }
                    } else {
                        resultCharArray[currentPosition + 1] =
                            nextPositionOriginalNumber.toString().last()
                    }

//                    println("resultCharArray[currentPosition+1] = ${resultCharArray[currentPosition + 1]}")

                    resultString = String(resultCharArray).reversed()
                    println(resultString)
                }
            }

            resultString = String(resultCharArray).reversed()
            var isZero = true
            resultString.forEach {
                if (it != '0') {
                    isZero = false
                }
            }
            if (isZero) {
                return "0"
            } else {
                return resultString.removePrefix("0")
            }
        }
    }
}