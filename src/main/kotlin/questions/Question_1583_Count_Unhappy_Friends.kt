package questions


class Question_1583_Count_Unhappy_Friends {

    companion object {

        fun runQuestion() {
//            Input: n = 4, preferences = [[1, 3, 2], [2, 3, 0], [1, 3, 0], [0, 2, 1]], pairs = [[1, 3], [0, 2]]
//            Output: 4
            val preferences =
                arrayOf(intArrayOf(1, 3, 2), intArrayOf(2, 3, 0), intArrayOf(1, 3, 0), intArrayOf(0, 2, 1))
            val pairs = arrayOf(intArrayOf(1, 3), intArrayOf(0, 2))
            val n = 4
            val k = 2
            val result = unhappyFriends(n, preferences, pairs)
            println("Question 1583: $result")
        }

        fun unhappyFriends(n: Int, preferences: Array<IntArray>, pairs: Array<IntArray>): Int {
            val pairMap: MutableMap<Int, Int> = mutableMapOf()
            for (count in 0..pairs.size - 1) {
                pairMap[pairs[count][0]] = pairs[count][1]
                pairMap[pairs[count][1]] = pairs[count][0]
            }
            val order = IntArray(n) { -1 }
            for (count in 0..n - 1) {
                order[count] = preferences[count].indexOf(pairMap[count]!!)
            }
            // println("order = ${order.contentToString()}")
            var ans = Array(n) { false }
            for (count in 0..n - 1) {
                for (i in 0..n - 1) {
                    if (i == count || i == pairMap[count]!!) {
                        continue
                    }
                    val pairedOne = pairMap[i]!!
                    val indexOfP1ForI = preferences[count].indexOf(i)
                    val indexOfP2ForI = preferences[i].indexOf(count)
                    // println("i = $i, count = $count, pariedOne = $pairedOne, indexOfP1ForI = $indexOfP1ForI, indexOfP2ForI = $indexOfP2ForI")
                    if (indexOfP1ForI < order[count] && indexOfP2ForI < order[i]) {
                        ans[count] = true
                        break
                    }
                }
            }
            return ans.filter { it }.count()
        }
    }
}