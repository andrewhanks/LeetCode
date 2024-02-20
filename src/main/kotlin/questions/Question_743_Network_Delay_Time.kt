package questions


class Question_743_Network_Delay_Time {

    companion object {

        fun runQuestion() {
//            Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
//            Output: 2
            val times = arrayOf(
                intArrayOf(2, 1, 1),
                intArrayOf(2, 3, 1),
                intArrayOf(3, 4, 1)
            )
            val n = 4
            val k = 2
            val result = networkDelayTime(times, n, k)
            println("Question 743: $result")
        }

        fun networkDelayTime(times: Array<IntArray>, n: Int, k: Int): Int {
            val tempArray = Array(n) { IntArray(n) { Int.MAX_VALUE } }
            for (count in 0..times.size - 1) {
                tempArray[times[count][0] - 1][times[count][1] - 1] = times[count][2]
            }
            val visited: MutableList<Boolean> = MutableList(n) { false }
            val distance: MutableList<Int> = MutableList(n) { Int.MAX_VALUE }
            distance[k - 1] = 0
            for (count in 0..visited.size - 1) {
                var minDistance = Int.MAX_VALUE
                var picked = 0
                for (pick in 0..distance.size - 1) {
                    if (distance[pick] < minDistance && !visited[pick]) {
                        minDistance = distance[pick]
                        picked = pick
                    }
                }
                visited[picked] = true
                println(picked)
                for (update in 0..distance.size - 1) {
                    if (update != picked && tempArray[picked][update] != Int.MAX_VALUE && distance[picked] + tempArray[picked][update] < distance[update]) {
                        distance[update] = distance[picked] + tempArray[picked][update]
                    }
                }
                println(distance)
            }
            val minPath = distance.maxOrNull() ?: Int.MAX_VALUE
            return if (minPath == Int.MAX_VALUE) {
                -1
            } else {
                minPath
            }
        }
    }
}