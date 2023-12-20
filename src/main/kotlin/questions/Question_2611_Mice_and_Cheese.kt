package questions


class Question_2611_Mice_and_Cheese {

    companion object {

        fun runQuestion() {
//            Input: reward1 = [1,1,3,4], reward2 = [4,4,1,1], k = 2
//            Output: 15
            val reward1 = intArrayOf(1, 1, 3, 4)
            val reward2 = intArrayOf(4, 4, 1, 1)
            val k = 2
            val result = miceAndCheese(reward1, reward2, k)
            println("Question 2611: $result")
        }

        fun miceAndCheese(reward1: IntArray, reward2: IntArray, k: Int): Int {
            val diff: Array<IntArray> = Array(reward1.size) { IntArray(3) { 0 } }
            for (count in 0..diff.size - 1) {
                diff[count][0] = reward1[count] - reward2[count]
                diff[count][1] = reward1[count]
                diff[count][2] = reward2[count]
            }
            diff.sortByDescending { it[0] }
            println("diff = ${diff.contentDeepToString()}")
            var points = 0
            for (count in 0..diff.size - 1) {
                if (count < k) {
                    points += diff[count][1]
                } else {
                    points += diff[count][2]
                }
            }
            return points
        }
    }
}