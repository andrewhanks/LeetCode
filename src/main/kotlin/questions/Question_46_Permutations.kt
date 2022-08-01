package questions


class Question_46_Permutations {

    companion object {

        fun runQuestion() {
            val intArray = intArrayOf(1, 2, 3)
            val resultList = permute(intArray)
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
            println("Question 46: $result")
        }

        fun permute(nums: IntArray): List<List<Int>> {
            val resultArray = ArrayList<List<Int>>()
            permuteArray(nums, 0, nums.size - 1, resultArray)
            return resultArray
        }

        fun permuteArray(nums: IntArray, i: Int, j: Int, resultArray: MutableList<List<Int>>) {
            if (i == j) {
                resultArray.add(nums.toMutableList())
            } else {
                for (count in i..j) {
                    nums[i] = nums[count].also { nums[count] = nums[i] }
                    permuteArray(nums, i + 1, j, resultArray)
                    nums[count] = nums[i].also { nums[i] = nums[count] }
                }
            }
        }
    }
}