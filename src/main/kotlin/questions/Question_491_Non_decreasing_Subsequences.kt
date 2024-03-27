package questions


class Question_491_Non_decreasing_Subsequences {

    companion object {

        fun runQuestion() {
//            Input: nums = [4,6,7,7]
//            Output: [[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
            val nums = intArrayOf(4, 6, 7, 7)
            val resultList = findSubsequences(nums)
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
            println("Question 491: $result")
        }

        fun findSubsequences(nums: IntArray): List<List<Int>> {
            val result: MutableSet<MutableList<Int>> = mutableSetOf()
            val temp: MutableList<Int> = mutableListOf()
            generate(nums, 0, result, temp)
            return result.toMutableList()
        }

        fun generate(nums: IntArray, start: Int, result: MutableSet<MutableList<Int>>, temp: MutableList<Int>) {
            if (start == nums.size) {
                if (temp.size >= 2) {
                    result.add(temp.toMutableList())
                }
                return
            }
            generate(nums, start + 1, result, temp)
            if (temp.size >= 1 && nums[start] < temp[temp.size - 1]) {
                return
            }
            temp.add(nums[start])
            generate(nums, start + 1, result, temp)
            temp.removeAt(temp.size - 1)
        }
    }
}