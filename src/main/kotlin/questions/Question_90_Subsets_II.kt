package questions


class Question_90_Subsets_II {

    companion object {

        fun runQuestion() {
//            Input: nums = [1,2,2]
//            Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
            val nums = intArrayOf(1, 2, 2)
            val resultList = subsetsWithDup(nums)
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
            println("Question 90: $result")
        }

        fun subsetsWithDup(nums: IntArray): List<List<Int>> {
            val result: MutableList<MutableList<Int>> = mutableListOf()
            val temp: MutableList<Int> = mutableListOf()
            generate(nums.sorted().toIntArray(), 0, result, temp)
            return result
        }

        fun generate(nums: IntArray, start: Int, result: MutableList<MutableList<Int>>, temp: MutableList<Int>) {
            if (start == nums.size) {
                if (!result.contains(temp)) {
                    result.add(temp.toMutableList())
                }
                return
            }
            generate(nums, start + 1, result, temp)
            temp.add(nums[start])
            generate(nums, start + 1, result, temp)
            temp.removeAt(temp.size - 1)
        }
    }
}