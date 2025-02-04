package questions

import kotlin.math.max
import kotlin.math.min

class Question_1781_Sum_of_Beauty_of_All_Substrings {

    companion object {

        fun runQuestion() {
//            Input: s = "aabcb"
//            Output: 5
            val s = "aabcb"
            val result = beautySum(s)
            println("Question 1781: $result")
        }

        fun beautySum(s: String): Int {
            var ans = 0
            for (i in 0..s.length - 2) {
                val list = IntArray(26) { 0 }
                list[s[i] - 'a']++
                for (j in i + 1..s.length - 1) {
                    var max = Int.MIN_VALUE
                    var min = Int.MAX_VALUE
                    list[s[j] - 'a']++
                    for (k in 0..25) {
                        max = max(max, list[k])
                        if (list[k] != 0) {
                            min = min(min, list[k])
                        }
                    }
                    // println("list = ${list.contentToString()}, max = $max, min = $min")
                    ans = ans + (max - min)
                }
            }
            return ans
        }
    }
}