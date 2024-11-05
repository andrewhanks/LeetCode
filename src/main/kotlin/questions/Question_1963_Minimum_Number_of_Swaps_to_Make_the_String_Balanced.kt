package questions

class Question_1963_Minimum_Number_of_Swaps_to_Make_the_String_Balanced {

    companion object {

        fun runQuestion() {
//            Input: s = "]]][[["
//            Output: 2
            val s = "]]][[["
            val result = minSwaps(s)
            println("Question 1963: $result")
        }

        fun minSwaps(s: String): Int {
            val list: MutableList<Int> = MutableList(s.length) { 0 }
            for (count in 0..s.length - 1) {
                if (s[count] == '[') {
                    list[count] = 1
                } else {
                    list[count] = -1
                }
            }
            var ans = 0
            var current = 0
            var j = list.size - 1
            for (i in 0..list.size - 1) {
                if (current + list[i] < 0) {
                    while (list[j] < 0) {
                        j--
                    }
                    val temp = list[i]
                    list[i] = list[j]
                    list[j] = temp
                    j--
                    ans++
                }
                current = current + list[i]
                // println("current = $current")
                if (i >= j) {
                    break
                }
            }
            return ans
        }
    }
}