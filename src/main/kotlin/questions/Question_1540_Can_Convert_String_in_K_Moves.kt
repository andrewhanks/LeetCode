package questions

class Question_1540_Can_Convert_String_in_K_Moves {

    companion object {

        fun runQuestion() {
//            Input: s = "aab", t = "bbb", k = 27
//            Output: true
            val s = "aab"
            val t = "bbb"
            val k = 27
            val result = canConvertString(s, t, k)
            println("Question 1540: $result")
        }

        fun canConvertString(s: String, t: String, k: Int): Boolean {
            if (s.length != t.length) {
                return false
            }
            val used = IntArray(27) { 0 }
            for (count in 0..s.length - 1) {
                val diff = if (t[count] >= s[count]) {
                    t[count] - s[count]
                } else {
                    t[count] - s[count] + 26
                }
                if (diff == 0) {
                    continue
                }
                if (diff + 26 * used[diff] <= k) {
                    used[diff]++
                } else {
                    return false
                }
            }
            return true
        }

        fun canConvertStringWithNotNecessaryArray(s: String, t: String, k: Int): Boolean {
            if (s.length != t.length) {
                return false
            }
            val diff = IntArray(s.length) { 0 }
            for (count in 0..diff.size - 1) {
                diff[count] = if (t[count] >= s[count]) {
                    t[count] - s[count]
                } else {
                    t[count] - s[count] + 26
                }
            }
            val used = IntArray(27) { 0 }
            for (count in 0..diff.size - 1) {
                if (diff[count] == 0) {
                    continue
                }
                var tempDiff = diff[count]
                // println("$tempDiff+26*used[$tempDiff] = ${tempDiff+26*used[tempDiff]}")
                if (tempDiff + 26 * used[tempDiff] <= k) {
                    used[tempDiff]++
                } else {
                    return false
                }
            }
            return true
        }
    }
}