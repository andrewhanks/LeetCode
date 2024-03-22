package questions


class Question_40_Combination_Sum_II {

    companion object {

        fun runQuestion() {
//            Input: candidates = [10,1,2,7,6,1,5], target = 8
//            Output:
//            [
//                [1,1,6],
//                [1,2,5],
//                [1,7],
//                [2,6]
//            ]
            val candidates = intArrayOf(10, 1, 2, 7, 6, 1, 5)
            val target = 8
            val resultList = combinationSum2(candidates, target)
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
            println("Question 40: $result")
        }

        fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
            val result: MutableList<MutableList<Int>> = mutableListOf()
            val temp: MutableList<Int> = mutableListOf()
            combination(candidates.sorted().toIntArray(), 0, target, result, temp)
            return result
        }

        fun combination(
            candidates: IntArray,
            start: Int,
            target: Int,
            result: MutableList<MutableList<Int>>,
            temp: MutableList<Int>
        ) {
            if (target <= 0) {
                if (target == 0 && !result.contains(temp)) {
                    result.add(temp.toMutableList())
                }
                return
            }
            for (count in start..candidates.size - 1) {
                // if value is the same as previous one, skip
                if (count > start && candidates[count] == candidates[count - 1]) continue
                temp.add(candidates[count])
                combination(candidates, count + 1, target - candidates[count], result, temp)
                temp.removeLast()
            }
        }
    }
}