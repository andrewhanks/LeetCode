package questions

class Question_399_Evaluate_Division {

    companion object {

        fun runQuestion() {
//            Input: equations = [["a","b"],["b","c"]],
//                    values = [2.0,3.0],
//                    queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
//            Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
            val equations = listOf(listOf("a", "b"), listOf("b", "c"))
            val values = doubleArrayOf(2.0, 3.0)
            val queries =
                listOf(listOf("a", "c"), listOf("b", "a"), listOf("a", "e"), listOf("a", "a"), listOf("x", "x"))
            val resultArray = calcEquation(equations, values, queries)
            var result = "["
            resultArray.forEachIndexed { index, i ->
                result += i
                if (index == resultArray.size - 1) {
                    result += "]"
                } else {
                    result += ","
                }
            }
            println("Question 399: $result")
        }

        fun calcEquation(equations: List<List<String>>, values: DoubleArray, queries: List<List<String>>): DoubleArray {
            val result: MutableMap<String, MutableMap<String, Double>> = mutableMapOf()
            for (count in 0..equations.size - 1) {
                if (!result.containsKey(equations[count][0])) {
                    result.put(equations[count][0], mutableMapOf())
                }
                result[equations[count][0]]?.put(equations[count][1], values[count])
                if (!result.containsKey(equations[count][1])) {
                    result.put(equations[count][1], mutableMapOf())
                }
                result[equations[count][1]]?.put(equations[count][0], 1.0 / values[count])
            }
            println(result)
            val ans: MutableList<Double> = mutableListOf()
            for (count in 0..queries.size - 1) {
                println("======================================")
                val final = divide(queries[count][0], queries[count][1], result, mutableSetOf())
                ans.add(final)
                println("====================================== final = $final")
            }
            return ans.toDoubleArray()
        }

        fun divide(
            x: String,
            y: String,
            result: MutableMap<String, MutableMap<String, Double>>,
            visited: MutableSet<String>
        ): Double {
            if (!result.containsKey(x) || !result.containsKey(y)) {
                return -1.0
            }
            println("x = $x, y = $y, visited = $visited")
            if (x == y) {
                return 1.0
            }
            visited.add(x)
            if (!result.containsKey(x)) {
                return -1.0
            }
            for (entry in result[x]!!) {
                if (visited.contains(entry.key)) {
                    continue
                }
                val tempValue = divide(entry.key, y, result, visited)
                if (tempValue > 0) {
                    return tempValue * result[x]!![entry.key]!!
                }
            }
            return -1.0
        }
    }
}