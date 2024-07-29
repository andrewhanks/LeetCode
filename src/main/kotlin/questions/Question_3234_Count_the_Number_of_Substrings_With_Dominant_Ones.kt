package questions

import kotlin.math.sqrt

class Question_3234_Count_the_Number_of_Substrings_With_Dominant_Ones {

    companion object {

        fun runQuestion() {
//            Input: s = "00011"
//            Output: 5
            val s = "00011"
            val result = numberOfSubstrings(s)
            println("Question 3234: $result")
        }

        fun numberOfSubstrings(s: String): Int {
            val zeroNum = IntArray(s.length + 1) { 0 }
            val oneNum = IntArray(s.length + 1) { 0 }
            for (count in 1..zeroNum.size - 1) {
                if (s[count - 1] == '0') {
                    zeroNum[count] = zeroNum[count - 1] + 1
                    oneNum[count] = oneNum[count - 1]
                } else {
                    zeroNum[count] = zeroNum[count - 1]
                    oneNum[count] = oneNum[count - 1] + 1
                }
            }
            // println("zeroNum = ${zeroNum.contentToString()}, oneNum = ${oneNum.contentToString()}")
            var ans = 0
            var i = 0
            var j = 0
            while (i <= zeroNum.size - 1) {
                j = i + 1
                while (j <= zeroNum.size - 1) {
                    val diffOne = oneNum[j] - oneNum[i]
                    val diffZero = zeroNum[j] - zeroNum[i]
                    if (diffOne >= diffZero * diffZero) {
                        ans++
                        if (diffOne > diffZero * diffZero) {
                            val diff = sqrt(diffOne.toDouble()).toInt() - diffZero
                            val nextJ = j + diff
                            if (nextJ >= oneNum.size) {
                                ans += oneNum.size - j - 1
                            } else {
                                ans += diff
                            }
                            j = nextJ
                        }
                    } else {
                        j += diffZero * diffZero - diffOne - 1
                    }
                    j++
                }
                i++
            }
            return ans
        }
    }
}