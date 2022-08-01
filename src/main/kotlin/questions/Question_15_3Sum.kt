package questions


class Question_15_3Sum {

    companion object {

        fun runQuestion() {
            val intArray = "-1,0,1,2,-1,-4".split(',').map { num -> num.toInt() }.toIntArray()
            val resultList = threeSumWebSolution(intArray)
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
            val resultList = ArrayList<List<Int>>()
            for (i in 0..nums.size - 3) {
                for (j in (i + 1)..nums.size - 2) {
                    run thirdLoop@{
                        nums.filterIndexed { index, i ->
                            index > j
                        }.find { it == -(nums[i] + nums[j]) }.let {
                            if (null == it) {
                                return@thirdLoop
                            }
                            val result = ArrayList<Int>()
                            result.add(nums[i])
                            result.add(nums[j])
                            result.add(it)
                            var position1TheSame = false
                            var position2TheSame = false
                            var position3TheSame = false
                            run checkLoop@{
                                resultList.forEach { list ->
                                    position1TheSame = false
                                    position2TheSame = false
                                    position3TheSame = false
                                    list.forEach {
                                        if (!position1TheSame && it == nums[i]) {
                                            position1TheSame = true
                                        } else if (!position2TheSame && it == nums[j]) {
                                            position2TheSame = true
                                        } else if (!position3TheSame && it == it) {
                                            position3TheSame = true
                                        }
                                    }
                                    if (position1TheSame && position2TheSame && position3TheSame) {
                                        return@checkLoop
                                    }
                                }
                            }
                            System.out.println("${nums[i]} ${nums[j]} ${it} : ${position1TheSame} ${position2TheSame} ${position3TheSame}")
                            if (!(position1TheSame && position2TheSame && position3TheSame)) {
                                resultList.add(result)
                                return@thirdLoop
                            }
                        }
                    }
                }
            }
            return resultList
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