package questions


class Question_46_Permutations {

    companion object {

        fun runQuestion() {
//            Input: nums = [1,2,3]
//            Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
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
            val temp: MutableList<Int> = mutableListOf()
            val visited: MutableSet<Int> = mutableSetOf()
            val result: MutableList<MutableList<Int>> = mutableListOf()
            find(nums, visited, temp, result)
            return result
        }

        fun find(
            nums: IntArray,
            visited: MutableSet<Int>,
            temp: MutableList<Int>,
            result: MutableList<MutableList<Int>>
        ) {
            if (temp.size == nums.size) {
                result.add(ArrayList(temp))
                return
            }
            for (num in nums) {
                if (!visited.contains(num)) {
                    temp.add(num)
                    visited.add(num)
                    find(nums, visited, temp, result)
                    temp.remove(num)
                    visited.remove(num)
                }
            }
        }

        fun permuteWebSolution(nums: IntArray): List<List<Int>> {
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