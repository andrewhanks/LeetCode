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
    }
}