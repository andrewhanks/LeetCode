package questions

import kotlin.math.abs
import kotlin.math.min

class Question_1864_Minimum_Number_of_Swaps_to_Make_the_Binary_String_Alternating {

    companion object {

        fun runQuestion() {
//            Input: s = "111000"
//            Output: 1
            val s = "111000"
            val result = minSwaps(s)
            println("Question 1864: $result")
        }

        fun minSwaps(s: String): Int {
            val oneNumber = s.filter { it == '1' }.count()
            val zeroNumber = s.filter { it == '0' }.count()
            if (abs(oneNumber - zeroNumber) >= 2) {
                return -1
            }
            if (oneNumber - zeroNumber == 1 || zeroNumber - oneNumber == 1) {
                var currentShouldBeOne = '1'
                if (oneNumber - zeroNumber == 1) {
                    currentShouldBeOne = '1'
                } else {
                    currentShouldBeOne = '0'
                }
                var diff = 0
                for (count in 0..s.length - 1) {
                    if (s[count] != currentShouldBeOne) {
                        diff++
                    }
                    if (currentShouldBeOne == '1') {
                        currentShouldBeOne = '0'
                    } else {
                        currentShouldBeOne = '1'
                    }
                }
                return diff / 2
            } else {
                var currentShouldBeOne = '1'
                var diff = 0
                for (count in 0..s.length - 1) {
                    if (s[count] != currentShouldBeOne) {
                        diff++
                    }
                    if (currentShouldBeOne == '1') {
                        currentShouldBeOne = '0'
                    } else {
                        currentShouldBeOne = '1'
                    }
                }
                diff = min(diff, s.length - diff)
                return diff / 2
            }
        }
    }
}