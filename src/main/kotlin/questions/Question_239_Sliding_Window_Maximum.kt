package questions

import kotlin.math.max

class Question_239_Sliding_Window_Maximum {

    companion object {

        fun runQuestion() {
//            Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
//            Output: [3,3,5,5,6,7]
            val nums = intArrayOf(1, 3, -1, -3, 5, 3, 6, 7)
            val k = 3
            val result = maxSlidingWindow(nums, k)
            println("Question 239: ${result.contentToString()}")
        }

        fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
            val result: MutableList<Int> = mutableListOf()
            var maxNumberPosition = -1
            for (count in 0..nums.size - k) {
                var max = Int.MIN_VALUE
                if (maxNumberPosition >= count && maxNumberPosition <= count + k - 2) {
                    max = nums[maxNumberPosition]
                    // println("count+k-1 = ${count+k-1}, maxNumberPosition = $maxNumberPosition")
                    // println("nums[count+k-1] = ${nums[count+k-1]}, nums[maxNumberPosition] = ${nums[maxNumberPosition]}")
                    if (nums[count + k - 1] >= nums[maxNumberPosition]) {
                        maxNumberPosition = count + k - 1
                    }
                    max = max(max, nums[count + k - 1])
                } else {
                    for (item in 0..k - 1) {
                        if (nums[count + item] >= max) {
                            maxNumberPosition = count + item
                        }
                        max = max(max, nums[count + item])
                    }
                }
                // println("count = $count, maxNumberPosition = $maxNumberPosition")
                result.add(max)
            }
            return result.toIntArray()
        }
    }
}