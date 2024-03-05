package questions


class Question_18_4Sum {

    companion object {

        fun runQuestion() {
//            Input: nums = [1,0,-1,0,-2,2], target = 0
//            Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
            val nums = "1,0,-1,0,-2,2".split(',').map { num -> num.toInt() }.toIntArray()
            val target = 0
            val resultList = fourSum(nums, target)
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
            println("Question 18: $result")
        }

        fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
            nums.sort()
            // println(nums.contentToString())
            val result: MutableList<MutableList<Int>> = mutableListOf()
            for (i in 0..nums.size - 1) {
                for (j in i + 1..nums.size - 1) {
                    var k = j + 1
                    var l = nums.size - 1
                    while (k < l) {
                        val sum: Long = nums[i].toLong() + nums[j].toLong() + nums[k].toLong() + nums[l].toLong()
                        // println("i=$i, j=$j, k=$k, l=$l, sum=$sum")
                        if (sum == target.toLong()) {
                            val temp: MutableList<Int> = mutableListOf()
                            temp.add(nums[i])
                            temp.add(nums[j])
                            temp.add(nums[k])
                            temp.add(nums[l])
                            if (!result.contains(temp)) {
                                result.add(temp)
                            }
                            k++
                            if (k <= nums.size - 1 && nums[k - 1] == nums[k]) {
                                k++
                            }
                            l--
                            if (l >= 0 && nums[l + 1] == nums[l]) {
                                l--
                            }
                        } else if (sum > target) {
                            l--
                        } else {
                            k++
                        }
                    }
                }
            }
            return result
        }
    }
}