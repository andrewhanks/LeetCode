package questions

class Question_3208_Alternating_Groups_II {

    companion object {

        fun runQuestion() {
//            Input: colors = [0,1,0,1,0], k = 3
//            Output: 3
            val colors = intArrayOf(0, 1, 0, 1, 0)
            val k = 3
            val result = numberOfAlternatingGroups(colors, k)
            println("Question 3208: $result")
        }

        fun numberOfAlternatingGroups(colors: IntArray, k: Int): Int {
            val tempColors: MutableList<Int> = colors.toMutableList()
            tempColors.addAll(colors.toMutableList())
            // println("tempColors = $tempColors")
            val result = IntArray(colors.size + k - 1) { 0 }
            result[0] = 1
            for (i in 1..result.size - 1) {
                if (tempColors[i] != tempColors[i - 1]) {
                    result[i] = result[i - 1] + 1
                } else {
                    result[i] = 1
                }
            }
            // println("result = ${result.contentToString()}")
            var ans = 0
            for (i in 0..result.size - 1) {
                if (result[i] >= k) {
                    ans++
                }
            }
            return ans
        }
    }
}