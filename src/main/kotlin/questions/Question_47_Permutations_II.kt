package questions


class Question_47_Permutations_II {

    companion object {

        fun runQuestion() {
//            Input: nums = [1,1,2]
//            Output:[[1,1,2], [1,2,1], [2,1,1]]
            val nums = intArrayOf(1, 1, 2)
            val resultList = permuteUnique(nums)
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
            println("Question 47: $result")
        }

        fun permuteUnique(nums: IntArray): List<List<Int>> {
            val result: MutableSet<MutableList<Int>> = mutableSetOf()
            val temp: MutableList<Int> = mutableListOf()
            val visitedPos: MutableList<Int> = mutableListOf()
            generate(nums, result, temp, visitedPos)
            return result.toMutableList()
        }

        fun generate(
            nums: IntArray,
            result: MutableSet<MutableList<Int>>,
            temp: MutableList<Int>,
            visitedPos: MutableList<Int>
        ) {
            if (temp.size == nums.size) {
                result.add(temp.toMutableList())
                return
            }
            for (count in 0..nums.size - 1) {
                if (visitedPos.contains(count)) {
                    continue
                }
                temp.add(nums[count])
                visitedPos.add(count)
                generate(nums, result, temp, visitedPos)
                temp.removeAt(temp.size - 1)
                visitedPos.removeAt(visitedPos.size - 1)
            }
        }

        fun permuteUniqueNormal(nums: IntArray): List<List<Int>> {
            val result: MutableList<MutableList<Int>> = mutableListOf()
            val temp: MutableList<Int> = mutableListOf()
            val visitedPos: MutableList<Int> = mutableListOf()
            generateNormal(nums, result, temp, visitedPos)
            return result
        }

        fun generateNormal(
            nums: IntArray,
            result: MutableList<MutableList<Int>>,
            temp: MutableList<Int>,
            visitedPos: MutableList<Int>
        ) {
            if (temp.size == nums.size) {
                if (!result.contains(temp)) {
                    result.add(temp.toMutableList())
                }
                return
            }
            for (count in 0..nums.size - 1) {
                if (visitedPos.contains(count)) {
                    continue
                }
                temp.add(nums[count])
                visitedPos.add(count)
                generateNormal(nums, result, temp, visitedPos)
                temp.removeAt(temp.size - 1)
                visitedPos.removeAt(visitedPos.size - 1)
            }
        }
    }
}