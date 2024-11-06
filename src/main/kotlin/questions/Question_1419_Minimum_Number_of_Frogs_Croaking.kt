package questions

import kotlin.math.max

class Question_1419_Minimum_Number_of_Frogs_Croaking {

    companion object {

        fun runQuestion() {
//            Input: croakOfFrogs = "crocakcroraoakk"
//            Output: 2
            val croakOfFrogs = "crocakcroraoakk"
            val result = minNumberOfFrogs(croakOfFrogs)
            println("Question 1419: $result")
        }

        fun minNumberOfFrogs(croakOfFrogs: String): Int {
            val croak = "croak"
            val list = IntArray(26) { 0 }
            var ans = 1
            var current = 0
            for (i in 0..croakOfFrogs.length - 1) {
                for (j in 1..croak.length - 1) {
                    if (list[croak[j] - 'a'] > list[croak[j - 1] - 'a']) {
                        return -1
                    }
                }
                if (croakOfFrogs[i] == 'c') {
                    current++
                    ans = max(ans, current)
                }
                if (croakOfFrogs[i] == 'k') {
                    current--
                    ans = max(ans, current)
                }
                list[croakOfFrogs[i] - 'a']++
            }
            for (count in 1..croak.length - 1) {
                if (list[croak[count] - 'a'] != list[croak[count - 1] - 'a']) {
                    return -1
                }
            }
            return ans
        }

        fun minNumberOfFrogsWebSolution(croakOfFrogs: String): Int {
            var c = 0
            var r = 0
            var o = 0
            var a = 0
            var k = 0
            var ans = 0
            for (ch in croakOfFrogs) {
                if (ch == 'c') {
                    c++
                } else if (ch == 'r') {
                    c--
                    r++
                    if (c < 0) {
                        return -1
                    }
                } else if (ch == 'o') {
                    r--
                    o++
                    if (r < 0) {
                        return -1
                    }
                } else if (ch == 'a') {
                    o--
                    a++
                    if (o < 0) {
                        return -1
                    }
                } else if (ch == 'k') {
                    a--
                    k++
                    if (a < 0) {
                        return -1
                    }
                }
                ans = max(ans, c + r + o + a)
            }
            if (c + r + o + a > 0) {
                return -1
            }
            return ans
        }
    }
}