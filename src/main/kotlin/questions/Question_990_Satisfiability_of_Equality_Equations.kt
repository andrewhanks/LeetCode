package questions

class Question_990_Satisfiability_of_Equality_Equations {

    companion object {

        fun runQuestion() {
//            Input: equations = ["a==b","b!=a"]
//            Output: false
            val stringArray = arrayOf("a==b", "b!=a")
            val result = equationsPossible(stringArray)
            println("Question 990: $result")
        }

        fun equationsPossible(equations: Array<String>): Boolean {
            val result: MutableMap<String, String> = mutableMapOf()
            for (count in 0..equations.size - 1) {
                var var1 = ""
                var var2 = ""
                if (equations[count].contains("==")) {
                    var1 = equations[count].split("==")[0]
                    var2 = equations[count].split("==")[1]
                } else {
                    var1 = equations[count].split("!=")[0]
                    var2 = equations[count].split("!=")[1]
                }
                result[var1] = var1
                result[var2] = var2
            }
            for (count in 0..equations.size - 1) {
                if (!equations[count].contains("==")) {
                    continue
                }
                val var1 = equations[count].split("==")[0]
                val var2 = equations[count].split("==")[1]
                union(result, var1, var2, true)
            }
            // println("result = $result")
            for (count in 0..equations.size - 1) {
                if (!equations[count].contains("!=")) {
                    continue
                }
                val var1 = equations[count].split("!=")[0]
                val var2 = equations[count].split("!=")[1]
                if (union(result, var1, var2, false)) {
                    return false
                }
            }
            return true
        }

        fun union(result: MutableMap<String, String>, var1: String, var2: String, doesNeedUnion: Boolean): Boolean {
            val node1 = find(result, var1)
            val node2 = find(result, var2)
            if (node1 == node2) {
                return true
            }
            if (doesNeedUnion) {
                result[node2] = node1
            }
            return false
        }

        fun find(result: MutableMap<String, String>, variable: String): String {
            if (result[variable] == variable) {
                return result[variable]!!
            }
            result[variable] = find(result, result[variable]!!)
            return result[variable]!!
        }

        fun equationsPossibleWithAlphabetArray(equations: Array<String>): Boolean {
            val result = IntArray(26) { 0 }
            for (count in 0..25) {
                result[count] = count
            }
            for (count in 0..equations.size - 1) {
                if (!equations[count].contains("==")) {
                    continue
                }
                val var1 = equations[count][0]
                val var2 = equations[count][3]
                union(result, var1 - 'a', var2 - 'a', true)
            }
            // println("result = ${result.contentToString()}")
            for (count in 0..equations.size - 1) {
                if (!equations[count].contains("!=")) {
                    continue
                }
                val var1 = equations[count][0]
                val var2 = equations[count][3]
                if (union(result, var1 - 'a', var2 - 'a', false)) {
                    return false
                }
            }
            return true
        }

        fun union(result: IntArray, var1: Int, var2: Int, doesNeedUnion: Boolean): Boolean {
            val node1 = find(result, var1)
            val node2 = find(result, var2)
            if (node1 == node2) {
                return true
            }
            if (doesNeedUnion) {
                result[node2] = node1
            }
            return false
        }

        fun find(result: IntArray, variable: Int): Int {
            if (result[variable] == variable) {
                return result[variable]
            }
            result[variable] = find(result, result[variable])
            return result[variable]
        }
    }
}