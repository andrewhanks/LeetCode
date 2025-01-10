package questions

import kotlin.math.max


class Question_1567_Maximum_Length_of_Subarray_With_Positive_Product {

    companion object {

        fun runQuestion() {
//            Input: nums = [0,1,-2,-3,-4]
//            Output: 3
            val nums = intArrayOf(0, 1, -2, -3, -4)
            val result = getMaxLen(nums)
            println("Question 1567: $result")
        }

        fun getMaxLen(nums: IntArray): Int {
            val negPos: MutableList<Int> = mutableListOf()
            var ans = 0
            var prev = 0
            for (i in 0..nums.size - 1) {
                if (nums[i] == 0) {
                    if (negPos.size % 2 == 1) {
                        val rangeMax = max((i - 1) - (negPos[0] + 1) + 1, (negPos[negPos.size - 1] - 1) - prev + 1)
                        ans = max(ans, rangeMax)
                    } else {
                        ans = max(ans, (i - 1) - prev + 1)
                    }
                    negPos.clear()
                    prev = i + 1
                } else if (nums[i] < 0) {
                    negPos.add(i)
                }
            }
            if (negPos.size % 2 == 1) {
                val rangeMax = max((nums.size - 1) - (negPos[0] + 1) + 1, (negPos[negPos.size - 1] - 1) - prev + 1)
                ans = max(ans, rangeMax)
            } else {
                ans = max(ans, (nums.size - 1) - prev + 1)
            }
            return ans
        }

        fun getMaxLenByCheckingAtEachNumber(nums: IntArray): Int {
            var ans = 0
            var i = 0
            while (i <= nums.size - 1) {
                if (nums[i] == 0) {
                    i++
                    continue
                }
                var j = i
                var count = 0
                var k = -1
                while (j <= nums.size - 1 && nums[j] != 0) {
                    if (nums[j] < 0) {
                        count++
                        if (k == -1) {
                            k = j
                        }
                    }
                    if (count % 2 == 0) {
                        ans = max(ans, j - i + 1)
                    } else if (k != -1) {
                        ans = max(ans, j - k)
                    }
                    j++
                }
                i = j
            }
            return ans
        }
    }
}