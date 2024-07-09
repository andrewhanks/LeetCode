package questions


class Question_15_3Sum {

    companion object {

        fun runQuestion() {
//            Input: nums = [-1,0,1,2,-1,-4]
//            Output: [[-1,-1,2],[-1,0,1]]
            val intArray = "-1,0,1,2,-1,-4".split(',').map { num -> num.toInt() }.toIntArray()
            val resultList = threeSum(intArray)
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
            println("Question 15: $result")
        }

        fun threeSum(nums: IntArray): List<List<Int>> {
            nums.sort()
            //println(nums.contentToString())
            val result: MutableList<MutableList<Int>> = mutableListOf()
            for (i in 0..nums.size - 3) {
                var j = i + 1
                var k = nums.size - 1
                //println("i = $i, j = $j, k = $k")
                while (j < k) {
                    val sum = nums[i] + nums[j] + nums[k]
                    //println("j = $j, k = $k, sum = $sum")
                    if (sum == 0) {
                        val tempResult: MutableList<Int> = mutableListOf()
                        tempResult.add(nums[i])
                        tempResult.add(nums[j])
                        tempResult.add(nums[k])
                        if (!result.contains(tempResult)) {
                            result.add(tempResult)
                        }
                        j++
                    } else if (sum < 0) {
                        j++
                    } else {
                        k--
                    }
                }
            }
            return result
        }

        fun threeSumWebSolution(nums: IntArray): List<List<Int>> {
            val res = ArrayList<List<Int>>()
            nums.sort()
            var i = 0
            while (i + 2 < nums.size) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    i++
                    continue
                }
                var j = i + 1
                var k = nums.size - 1
                val target = -nums[i]
                while (j < k) {
                    if (nums[j] + nums[k] == target) {
                        val result = ArrayList<Int>()
                        result.add(nums[i])
                        result.add(nums[j])
                        result.add(nums[k])
                        res.add(result)
                        j++
                        k--
                        while (j < k && nums[j] == nums[j - 1]) j++
                        while (j < k && nums[k] == nums[k + 1]) k--
                    } else if (nums[j] + nums[k] > target) {
                        k--
                    } else {
                        j++
                    }
                }
                i++
            }
            return res
        }
    }
}