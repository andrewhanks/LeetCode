package questions

class Question_1405_Longest_Happy_String {

    companion object {

        fun runQuestion() {
            val numberA = 1
            val numberB = 1
            val numberC = 7
            val result = longestDiverseString(numberA, numberB, numberC)
            println("Question 1405: $result")
        }

        fun longestDiverseString(a: Int, b: Int, c: Int): String {
            var numberA = a
            var numberB = b
            var numberC = c
            var result = ""
            while ((numberA != 0 && numberB != 0) || (numberA != 0 && numberC != 0) || (numberB != 0 && numberC != 0)) {
                if (numberA > numberB) {
                    if (numberB > numberC) {
                        //A>B>C
                        if (!isPrevious2TheSameWith(result, 'a')) {
                            result += "a"
                            numberA -= 1
                        } else {
                            result += "b"
                            numberB -= 1
                        }
                    } else if (numberA > numberC) {
                        //A>C>=B
                        if (!isPrevious2TheSameWith(result, 'a')) {
                            result += "a"
                            numberA -= 1
                        } else {
                            result += "c"
                            numberC -= 1
                        }
                    } else {
                        //C>=A>B
                        if (!isPrevious2TheSameWith(result, 'c')) {
                            result += "c"
                            numberC -= 1
                        } else {
                            result += "a"
                            numberA -= 1
                        }
                    }
                } else {
                    if (numberA > numberC) {
                        //B>=A>C
                        if (!isPrevious2TheSameWith(result, 'b')) {
                            result += "b"
                            numberB -= 1
                        } else {
                            result += "a"
                            numberA -= 1
                        }
                    } else if (numberC > numberB) {
                        //C>B>=A
                        if (!isPrevious2TheSameWith(result, 'c')) {
                            result += "c"
                            numberC -= 1
                        } else {
                            result += "b"
                            numberB -= 1
                        }
                    } else {
                        //B>=C>=A
                        if (!isPrevious2TheSameWith(result, 'b')) {
                            result += "b"
                            numberB -= 1
                        } else {
                            result += "c"
                            numberC -= 1
                        }
                    }
                }
                //println("$result")
            }
            for (count in 0..1) {
                if (numberA >= 1 && !isPrevious2TheSameWith(result, 'a')) {
                    result += "a"
                    numberA -= 1
                } else if (numberB >= 1 && !isPrevious2TheSameWith(result, 'b')) {
                    result += "b"
                    numberB -= 1
                } else if (numberC >= 1 && !isPrevious2TheSameWith(result, 'c')) {
                    result += "c"
                    numberC -= 1
                }
            }
            return result
        }

        fun isPrevious2TheSameWith(result: String, target: Char): Boolean {
            return result.length >= 2 && result[result.length - 1] == target && result[result.length - 2] == target
        }
    }
}