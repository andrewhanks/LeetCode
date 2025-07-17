package questions

import java.util.*

class Question_3387_Maximize_Amount_After_Two_Days_of_Conversions {

    companion object {

        fun runQuestion() {
//            Input: initialCurrency = "EUR",
//                   pairs1 = [["EUR","USD"],["USD","JPY"]], rates1 = [2.0,3.0],
//                   pairs2 = [["JPY","USD"],["USD","CHF"],["CHF","EUR"]], rates2 = [4.0,5.0,6.0]
//            Output: 720.00000
            val initialCurrency = "EUR"
            val pairs1 = listOf(listOf("EUR", "USD"), listOf("USD", "JPY"))
            val rates1 = doubleArrayOf(2.0, 3.0)
            val pairs2 = listOf(listOf("JPY", "USD"), listOf("USD", "CHF"), listOf("CHF", "EUR"))
            val rates2 = doubleArrayOf(4.0, 5.0, 6.0)
            val result = maxAmount(initialCurrency, pairs1, rates1, pairs2, rates2)
            println("Question 3387: $result")
        }

        fun maxAmount(
            initialCurrency: String,
            pairs1: List<List<String>>,
            rates1: DoubleArray,
            pairs2: List<List<String>>,
            rates2: DoubleArray
        ): Double {
            val map: MutableMap<String, Double> = mutableMapOf()
            map.putIfAbsent(initialCurrency, 1.0)
            val convert1: MutableMap<String, MutableList<Pair<String, Double>>> = mutableMapOf()
            for (i in 0..pairs1.size - 1) {
                val pair = pairs1[i]
                convert1.putIfAbsent(pair[0], mutableListOf())
                convert1[pair[0]]!!.add(Pair(pair[1], rates1[i]))
                convert1.putIfAbsent(pair[1], mutableListOf())
                convert1[pair[1]]!!.add(Pair(pair[0], 1 / rates1[i]))
            }
            val queue: Queue<Pair<String, Double>> = LinkedList()
            queue.add(Pair(initialCurrency, 1.0))
            while (!queue.isEmpty()) {
                val node = queue.remove()
                if (convert1[node.first] == null) {
                    continue
                }
                for (item in convert1[node.first]!!) {
                    map.putIfAbsent(item.first, 0.0)
                    if (item.second * node.second > map[item.first]!!) {
                        map[item.first] = item.second * node.second
                        queue.add(Pair(item.first, item.second * node.second))
                    }
                }
            }
            // println("map = $map")
            val convert2: MutableMap<String, MutableList<Pair<String, Double>>> = mutableMapOf()
            for (i in 0..pairs2.size - 1) {
                val pair = pairs2[i]
                convert2.putIfAbsent(pair[0], mutableListOf())
                convert2[pair[0]]!!.add(Pair(pair[1], rates2[i]))
                convert2.putIfAbsent(pair[1], mutableListOf())
                convert2[pair[1]]!!.add(Pair(pair[0], 1 / rates2[i]))
            }
            queue.clear()
            for ((key, value) in map) {
                queue.add(Pair(key, value))
            }
            while (!queue.isEmpty()) {
                val node = queue.remove()
                if (convert2[node.first] == null) {
                    continue
                }
                for (item in convert2[node.first]!!) {
                    map.putIfAbsent(item.first, 0.0)
                    if (item.second * node.second > map[item.first]!!) {
                        map[item.first] = item.second * node.second
                        queue.add(Pair(item.first, item.second * node.second))
                    }
                }
            }
            return map[initialCurrency]!!
        }
    }
}