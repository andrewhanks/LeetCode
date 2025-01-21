package questions

class Question_1042_Flower_Planting_With_No_Adjacent {

    companion object {

        fun runQuestion() {
//            Input: n = 4, paths = [[1,2],[2,3],[3,4],[4,1],[1,3],[2,4]]
//            Output: [1,2,3,4]
            val paths = arrayOf(
                intArrayOf(1, 2),
                intArrayOf(2, 3),
                intArrayOf(3, 4),
                intArrayOf(4, 1),
                intArrayOf(1, 3),
                intArrayOf(2, 4)
            )
            val n = 4
            val result = gardenNoAdj(n, paths)
            println("Question 1042: ${result.contentToString()}")
        }

        fun gardenNoAdj(n: Int, paths: Array<IntArray>): IntArray {
            val map: MutableMap<Int, MutableList<Int>> = mutableMapOf()
            for (i in 0..n - 1) {
                map[i] = mutableListOf()
            }
            for (item in paths) {
                var list = map.getOrDefault(item[0] - 1, mutableListOf())
                list.add(item[1] - 1)
                map[item[0] - 1] = list
                list = map.getOrDefault(item[1] - 1, mutableListOf())
                list.add(item[0] - 1)
                map[item[1] - 1] = list
            }
            // println("map = $map")
            val ans = IntArray(n) { 0 }
            for (i in 0..n - 1) {
                val used = Array(5) { false }
                val list = map[i]
                if (list != null) {
                    for (item in list) {
                        used[ans[item]] = true
                    }
                    for (j in 1..4) {
                        if (!used[j]) {
                            ans[i] = j
                            break
                        }
                    }
                }
            }
            return ans
        }
    }
}