package questions

import kotlin.math.sign

class Question_2685_Count_the_Number_of_Complete_Components {

    companion object {

        fun runQuestion() {
            //n = 6, edges = [[0,1],[0,2],[1,2],[3,4]]
            //n = 6, edges = [[0,1],[0,2],[1,2],[3,4],[3,5]]
            val number = 6
            val intArray1 = intArrayOf(0, 1)
            val intArray2 = intArrayOf(0, 2)
            val intArray3 = intArrayOf(1, 2)
            val intArray4 = intArrayOf(3, 4)
            val intArray5 = intArrayOf(3, 5)
            val twoDimenIntArray = arrayOf(intArray1, intArray2, intArray3, intArray4, intArray5)
            val result = countCompleteComponents(number, twoDimenIntArray)
            println("Question 2685: $result")
        }

        fun countCompleteComponents(n: Int, edges: Array<IntArray>): Int {
            val groups: MutableList<MutableSet<Int>> = mutableListOf()
            for (count in 0..n - 1) {
                groups.add(mutableSetOf())
                groups[count].add(count)
                for (edge in edges) {
                    if (edge.contains(count)) {
                        groups[count].addAll(edge.toSet())
                    }
                }
            }
            println("==================")
            for (group in groups) {
                println(group)
            }
            println("------------------")
            val results: MutableList<MutableSet<Int>> = mutableListOf()
            for (countx in 0..groups.size - 1) {
                var tempMatch = 0
                var tempGroup = groups[countx].sorted()
                println(tempGroup)
                for (county in countx + 1..groups.size - 1) {
                    if (tempGroup == groups[county].sorted()) {
                        tempMatch++
                    }
                }
                var isTheSame = false
                for (result in results) {
                    if (result == groups[countx]) {
                        isTheSame = true
                    }
                }
                if (tempMatch + 1 == groups[countx].size && !isTheSame) {
                    results.add(groups[countx])
                }
            }
            println("==================")
            for (result in results) {
                println(result)
            }
            println("------------------")
            return results.size
        }
    }
}