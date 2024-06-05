package questions


class Question_39_Combination_Sum {

    companion object {

        fun runQuestion() {
//            Input: candidates = [2,3,5], target = 8
//            Output: [[2,2,2,2],[2,3,3],[3,5]]
            val candidates = intArrayOf(2, 3, 5)
            val target = 8
            val resultList = combinationSum(candidates, target)
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
            println("Question 39: $result")
        }

        fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
            val result: MutableList<MutableList<Int>> = mutableListOf()
            val temp: MutableList<Int> = mutableListOf()
            cal(candidates.sorted().toIntArray(), target, result, temp, 0)
            return result
        }

        fun cal(
            candidates: IntArray,
            target: Int,
            result: MutableList<MutableList<Int>>,
            temp: MutableList<Int>,
            index: Int
        ) {
            val sum = temp.sum()
            // println("temp = $temp, sum = $sum, target = $target")
            if (sum >= target) {
                // println("!result.contains(temp) = ${!result.contains(temp)}, sum==target = ${sum==target}")
                val sortedTemp = temp.sorted()
                if (sum == target) {
                    result.add(sortedTemp.toMutableList())
                }
                return
            }
            for (count in index..candidates.size - 1) {
                temp.add(candidates[count])
                cal(candidates, target, result, temp, count)
                temp.removeAt(temp.size - 1)
            }
        }

        fun combinationSumOldSolution(candidates: IntArray, target: Int): List<List<Int>> {
            val result: MutableList<MutableList<Int>> = mutableListOf()
            val temp: MutableList<Int> = mutableListOf()
            combinationOldSolution(candidates.sorted().toIntArray(), 0, target, result, temp)
            return result
        }

        fun combinationOldSolution(
            candidates: IntArray,
            index: Int,
            target: Int,
            result: MutableList<MutableList<Int>>,
            temp: MutableList<Int>
        ) {
            if (target <= 0) {
                if (0 == target && !result.contains(temp.sorted())) {
                    result.add(temp.toMutableList())
                }
                return
            }
            for (count in index..candidates.size - 1) {
                if (target - candidates[count] < 0) {
                    return
                }
                temp.add(candidates[count])
                combinationOldSolution(candidates, count, target - candidates[count], result, temp)
                temp.removeAt(temp.size - 1)
            }
        }

        fun combinationSumSlow(candidates: IntArray, target: Int): List<List<Int>> {
            val result: MutableList<MutableList<Int>> = mutableListOf()
            val temp: MutableList<Int> = mutableListOf()
            combinationSlow(candidates.sorted().toIntArray(), target, result, temp)
            return result
        }

        fun combinationSlow(
            candidates: IntArray,
            target: Int,
            result: MutableList<MutableList<Int>>,
            temp: MutableList<Int>
        ) {
            val sum = temp.sum()
            if (sum >= target) {
                if (sum == target && !result.contains(temp.sorted())) {
                    result.add(temp.toMutableList())
                }
                return
            }
            for (count in 0..candidates.size - 1) {
                temp.add(candidates[count])
                combinationSlow(candidates, target, result, temp)
                temp.removeLast()
            }
        }

        fun combinationSumOld(candidates: IntArray, target: Int): List<List<Int>> {
            val result: MutableList<MutableList<Int>> = mutableListOf()
            val temp: MutableList<Int> = mutableListOf()
            dp(candidates.sorted().toIntArray(), target, 0, result, temp)
            return result
        }

        fun dp(
            candidates: IntArray,
            target: Int,
            index: Int,
            result: MutableList<MutableList<Int>>,
            temp: MutableList<Int>
        ) {
            if (target == 0) {
                result.add(ArrayList(temp))
//                val tempResult:MutableList<Int> = mutableListOf()
//                temp.forEach { tempResult.add(it) }
//                result.add(tempResult)
                return
            }
            for (count in index..candidates.size - 1) {
                val current = candidates[count]
                if (target - current < 0) {
                    return
                }
                println("target = $target, count = $count, current = $current, result = $result, temp = $temp")
                temp.add(current)
                dp(candidates, target - current, count, result, temp)
                temp.removeAt(temp.size - 1)
            }
        }
    }
}