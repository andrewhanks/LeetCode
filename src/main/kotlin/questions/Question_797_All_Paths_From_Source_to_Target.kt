package questions


class Question_797_All_Paths_From_Source_to_Target {

    companion object {

        fun runQuestion() {
//            Input: graph = [[4,3,1],[3,2,4],[3],[4],[]]
//            Output: [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
            val graph = arrayOf(intArrayOf(4, 3, 1), intArrayOf(3, 2, 4), intArrayOf(3), intArrayOf(4), intArrayOf())
            val resultList = allPathsSourceTarget(graph)
            var result = "["
            resultList.forEachIndexed { firstIndex, firstI ->
                resultList[firstIndex].forEachIndexed { secondIndex, secondI ->
                    if (0 == secondIndex) {
                        result += "["
                    }
                    result += secondI
                    if (secondIndex == resultList[firstIndex].size - 1) {
                        result += "]"
                    } else {
                        result += ","
                    }
                }
                if (firstIndex == resultList.size - 1) {
                    result += "]"
                } else {
                    result += ","
                }
            }
            if (']' != result.last()) {
                result += "]"
            }
            println("Question 797: $result")
        }

        fun allPathsSourceTarget(graph: Array<IntArray>): List<List<Int>> {
            val result: MutableList<MutableList<Int>> = mutableListOf()
            val temp: MutableList<Int> = mutableListOf()
            temp.add(0)
            pick(graph, 0, result, temp)
            return result
        }

        fun pick(graph: Array<IntArray>, index: Int, result: MutableList<MutableList<Int>>, temp: MutableList<Int>) {
            if (index == graph.size - 1) {
                result.add(temp.toMutableList())
                return
            }
            for (count in 0..graph[index].size - 1) {
                temp.add(graph[index][count])
                pick(graph, graph[index][count], result, temp)
                temp.removeAt(temp.size - 1)
            }
        }
    }
}