package questions


class Question_216_Combination_Sum_III {

    companion object {

        fun runQuestion() {
//            Input: k = 3, n = 9
//            Output: [[1,2,6],[1,3,5],[2,3,4]]
            val k = 3
            val n = 9
            val resultList = combinationSum3(k, n)
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
            println("Question 216: $result")
        }

        fun combinationSum3(k: Int, n: Int): List<List<Int>> {
            val result: MutableList<MutableList<Int>> = mutableListOf()
            val temp: MutableList<Int> = mutableListOf()
            combination(1, k, n, result, temp)
            return result
        }

        fun combination(start: Int, k: Int, n: Int, result: MutableList<MutableList<Int>>, temp: MutableList<Int>) {
            if (temp.size == k && temp.sum() == n) {
                result.add(temp.toMutableList())
                return
            }
            for (count in start..9) {
                temp.add(count)
                combination(count + 1, k, n, result, temp)
                temp.remove(count)
            }
        }
    }
}