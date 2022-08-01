package questions

class Question_948_Bag_of_Tokens {

    companion object {

        fun runQuestion() {
            val inputNums = intArrayOf(100, 200, 300, 400)
            val inputTarget = 200
            val result = bagOfTokensScore(inputNums, inputTarget)
            println("Question 948: $result")
        }

        fun bagOfTokensScore(tokens: IntArray, power: Int): Int {
            tokens.sort()
            var lastAddPowerPosition = tokens.size - 1
            var tempPower = power
            var score = 0
            tokens.forEachIndexed { index, i ->
                println("index = $index, lastAddPowerPosition = $lastAddPowerPosition")
                if (index > lastAddPowerPosition) {
                    return score
                }
                println("tempPower = $tempPower, i = $i")
                if (tempPower >= i) {
                    tempPower -= i
                    score += 1
                } else {
                    println("score = $score")
                    if (score > 0 && index != lastAddPowerPosition) {
                        score -= 1
                        tempPower += tokens[lastAddPowerPosition]
                        lastAddPowerPosition -= 1
                        if (tempPower >= i) {
                            tempPower -= i
                            score += 1
                        }
                    } else {
                        return score
                    }
                }
            }
            return score
        }
    }
}