package questions

import kotlin.math.max

class Question_948_Bag_of_Tokens {

    companion object {

        fun runQuestion() {
//            Input: tokens = [100,200,300,400], power = 200
//            Output: 2
            val tokens = intArrayOf(100, 200, 300, 400)
            val power = 200
            val result = bagOfTokensScore(tokens, power)
            println("Question 948: $result")
        }

        fun bagOfTokensScore(tokens: IntArray, power: Int): Int {
            tokens.sort()
            var i = 0
            var j = tokens.size - 1
            var score = 0
            var temp = power
            var max = 0
            while (i <= j) {
                if (temp >= tokens[i]) {
                    temp -= tokens[i]
                    score++
                    max = max(max, score)
                    i++
                } else if (score > 0) {
                    score--
                    temp += tokens[j]
                    j--
                } else {
                    break
                }
            }
            return max
        }

        fun bagOfTokensScoreOldSolution(tokens: IntArray, power: Int): Int {
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