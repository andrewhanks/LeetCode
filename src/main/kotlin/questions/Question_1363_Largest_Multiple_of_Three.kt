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

        fun largestMultipleOfThreeWithDp(digits: IntArray): String {
            digits.sortDescending()
            val dp = Array<String>(3) { "" }
            dp[0] = ""
            dp[1] = "#"
            dp[2] = "#"
            for (i in 1..digits.size) {
                val prevDp = dp.toMutableList()
                for (j in 0..2) {
                    val digit = digits[i - 1]
                    val k = digit % 3
                    val prevJ = ((j - k) + 3) % 3
                    val picked = prevDp[prevJ]
                    val notPicked = prevDp[j]
                    // println("picked = $picked, notPicked = $notPicked")
                    dp[j] = if (notPicked == "#" && picked == "#") {
                        "#"
                    } else if (notPicked == "#") {
                        picked + digit
                    } else if (picked == "#") {
                        notPicked
                    } else if (picked.length + 1 <= notPicked.length) {
                        notPicked
                    } else {
                        picked + digit
                    }
                }
                // println("dp = ${dp.contentToString()}")
            }
            // println("dp = ${dp.contentToString()}")
            val ret = dp[0]
            if (ret.length == 0) {
                return ""
            } else if (ret[0] == '0') {
                return "0"
            } else {
                return ret
            }
        }

        fun largestMultipleOfThreeWithBackTracking(digits: IntArray): String {
            digits.sortDescending()
            val n = digits.size
            val dp = Array(3) { IntArray(n + 1) { 0 } }
            val pick = Array(3) { Array<Boolean>(n + 1) { false } }
            val prev = Array(3) { IntArray(n + 1) { 0 } }
            dp[0][0] = 0
            dp[1][0] = Int.MIN_VALUE
            dp[2][0] = Int.MIN_VALUE
            for (i in 1..n) {
                for (j in 0..2) {
                    val digit = digits[i - 1]
                    val prevJ = (j - digit % 3 + 3) % 3
                    val picked = dp[prevJ][i - 1]
                    val notPicked = dp[j][i - 1]
                    if (notPicked >= picked + 1) {
                        dp[j][i] = notPicked
                        pick[j][i] = false
                        prev[j][i] = j
                    } else {
                        dp[j][i] = picked + 1
                        pick[j][i] = true
                        prev[j][i] = prevJ
                    }
                }
            }
            var ret = ""
            var prevJ = 0
            for (i in n downTo 1) {
                if (pick[prevJ][i]) {
                    ret += digits[i - 1]
                }
                prevJ = prev[prevJ][i]
            }

            val answer = ret.reversed()

            if (answer.isEmpty()) {
                return ""
            } else if (answer[0] == '0') {
                return "0"
            } else {
                return answer
            }
        }
    }
}