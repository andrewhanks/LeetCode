package questions

import kotlin.math.abs

class Question_16_3Sum_Closest {

    companion object {

        fun runQuestion() {
//            Input: nums = [-1,2,1,-4], target = 1
//            Output: 2
            val inputNums = intArrayOf(-1, 2, 1, -4)
            val inputTarget = 1
            val result = threeSumClosest(inputNums, inputTarget)
            println("Question 16: $result")
        }

        fun threeSumClosest(nums: IntArray, target: Int): Int {
            nums.sort()
            var minDiff = Int.MAX_VALUE
            var ans = 0
            for (i in 0..nums.size - 3) {
                var j = i + 1
                var k = nums.size - 1
                while (j < k) {
                    val sum = nums[i] + nums[j] + nums[k]
                    val diff = sum - target
                    if (abs(diff) < minDiff) {
                        ans = sum
                        minDiff = abs(diff)
                    }
                    // println("nums[$i] = ${nums[i]}, nums[$j] = ${nums[j]}, nums[$k] = ${nums[k]}, minDiff = $minDiff")
                    if (diff > 0) {
                        k--
                    } else if (diff < 0) {
                        j++
                    } else {
                        return target
                    }
                }
            }
            return ans
        }

        fun threeSumClosestOldSolution(nums: IntArray, target: Int): Int {
            var result = Int.MAX_VALUE
            for (i in 0..nums.size - 1) {
                for (j in i + 1..nums.size - 1) {
                    for (k in j + 1..nums.size - 1) {
                        val tempResult = nums[i] + nums[j] + nums[k]
                        if (Int.MAX_VALUE < (result.toLong() - target.toLong()) ||
                            (Math.abs(tempResult - target) < Math.abs(result - target))
                        ) {
                            result = tempResult
                        }
                    }
                }
            }
            return result
        }

        fun threeSumClosestWebSolution(nums: IntArray, target: Int): Int {
            var result = nums[0] + nums[1] + nums[nums.size - 1]
            nums.sort()
            for (i in 0 until nums.size - 2) {
                var start = i + 1
                var end = nums.size - 1
                while (start < end) {
                    val sum = nums[i] + nums[start] + nums[end]
                    if (sum > target) {
                        end--
                    } else {
                        start++
                    }
                    if (Math.abs(sum - target) < Math.abs(result - target)) {
                        result = sum
                    }
                }
            }
            return result
        }
    }
}