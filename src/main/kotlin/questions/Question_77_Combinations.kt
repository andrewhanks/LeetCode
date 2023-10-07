package questions

class Question_77_Combinations {

    companion object {

        fun runQuestion() {
//            Input: n = 4, k = 2
//            Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
            val n = 4
            val k = 2
            val resultList = combine(n, k)
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
            println("Question 77: $result")
        }

        fun combine(n: Int, k: Int): List<List<Int>> {
            val resultList: MutableList<MutableList<Int>> = mutableListOf()
            val temp: MutableList<Int> = mutableListOf()
            dp(1, n, k, resultList, temp)
            return resultList
        }

        fun dp(start: Int, n: Int, k: Int, resultList: MutableList<MutableList<Int>>, temp: MutableList<Int>) {
            if (k == 0) {
                resultList.add(MutableList(temp.size) { index -> temp[index] })
                println(resultList)
                return
            }
            for (i in start..n - k + 1) {
                temp.add(i)
                println("add $i")
                dp(i + 1, n, k - 1, resultList, temp)
                val index = temp.size - 1
                val value = temp.removeAt(index)
                println("remove $value at ${index}")
            }
        }
    }
}