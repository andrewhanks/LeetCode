package questions

import kotlin.math.min

class Question_1653_Minimum_Deletions_to_Make_String_Balanced {

    companion object {

        fun runQuestion() {
//            Input: s = "aababbab"
//            Output: 2
            val s = "aababbab"
            val result = minimumDeletions(s)
            println("Question 1653: $result")
        }

        fun minimumDeletions(s: String): Int {
            val tempS = s + "_"
            var aNum = 0
            var bNum = 0
            for (i in 0..s.length - 1) {
                if (s[i] == 'a') {
                    aNum++
                } else {
                    bNum++
                }
            }
            var ans = Int.MAX_VALUE
            var bAcc = 0
            for (i in 0..tempS.length - 1) {
                var ret = 0
                if (i == 0) {
                    ret = aNum
                    ans = min(ans, ret)
                } else {
                    if (s[i - 1] == 'a') {
                        aNum--
                        ret = bAcc + aNum
                        ans = min(ans, ret)
                    } else {
                        bAcc++
                        bNum--
                        ret = bAcc + aNum
                        ans = min(ans, ret)
                    }
                }
                // println("aNum = $aNum, bNum = $bNum, bAcc = $bAcc, ret = $ret, ans = $ans")
            }
            return ans
        }

        fun minimumDeletionsAnotherSolution(s: String): Int {
            val n = s.length
            val changeToA = IntArray(n) { 0 }
            val changeToB = IntArray(n) { 0 }
            if (s[0] == 'b') {
                changeToA[0] = 1
            }
            for (i in 1..n - 1) {
                if (s[i] == 'b') {
                    changeToA[i] = changeToA[i - 1] + 1
                } else {
                    changeToA[i] = changeToA[i - 1]
                }
            }
            if (s[n - 1] == 'a') {
                changeToB[n - 1] = 1
            }
            for (i in n - 2 downTo 0) {
                if (s[i] == 'a') {
                    changeToB[i] = changeToB[i + 1] + 1
                } else {
                    changeToB[i] = changeToB[i + 1]
                }
            }
            // println("changeToA = ${changeToA.contentToString()}, changeToB = ${changeToB.contentToString()}")
            var ans = min(changeToA[n - 1], changeToB[0])
            for (i in 0..n - 2) {
                ans = min(ans, changeToA[i] + changeToB[i + 1])
            }
            return ans
        }
    }
}