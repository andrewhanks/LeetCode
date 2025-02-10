package questions

import kotlin.math.max
import kotlin.math.pow


class Question_1239_Maximum_Length_of_a_Concatenated_String_with_Unique_Characters {

    companion object {

        fun runQuestion() {
//            Input: arr = ["un","iq","ue"]
//            Output: 4
            val arr = listOf("un", "iq", "ue")
            val result = maxLength(arr)
            println("Question 1239: $result")
        }

        fun maxLength(arr: List<String>): Int {
            val n = arr.size
            val max = (2.0).pow(n.toDouble()).toInt()
            var ans = 0
            for (i in 0..max - 1) {
                var mask = ""
                var current = i
                for (j in 0..n - 1) {
                    val rest = current % 2
                    current = current / 2
                    mask = rest.toString() + mask
                }
                var over = false
                val count = IntArray(26) { 0 }
                // println("mask = $mask")
                for (j in 0..arr.size - 1) {
                    if (mask[j] == '0') {
                        continue
                    }
                    for (k in 0..arr[j].length - 1) {
                        count[arr[j][k] - 'a']++
                        if (count[arr[j][k] - 'a'] > 1) {
                            over = true
                            break
                        }
                    }
                    if (over) {
                        break
                    }
                }
                if (!over) {
                    // println("ans = $ans, count.sum() = ${count.sum()}")
                    ans = max(ans, count.sum())
                }
            }
            return ans
        }
    }
}