package questions

import kotlin.math.min

class Question_153_Find_Minimum_in_Rotated_Sorted_Array {

    companion object {

        fun runQuestion() {
//            Input: nums = [4,5,6,7,0,1,2]
//            Output: 0
            val numberArray = intArrayOf(4, 5, 6, 7, 0, 1, 2)
            val startTime = System.currentTimeMillis()
            val result = findMin(numberArray)
            println("Question 153: $result, spent time = ${System.currentTimeMillis() - startTime}")
        }

        fun findMinMyLogN(nums: IntArray): Int {
            if (nums.size == 1) {
                return nums[0]
            }
            var min = 10000
            var i = 0
            var j = nums.size - 1
            var middle = (nums.size - 1) / 2
            while (i < j) {
                if (nums[i] <= nums[middle] && nums[middle + 1] <= nums[j]) {
                    min = min(nums[i], nums[middle + 1])
                    break
                } else if (nums[i] <= nums[middle]) {
                    i = middle + 1
                    middle = (i + j) / 2
                } else if (nums[middle + 1] <= nums[j]) {
                    j = middle
                    middle = (i + j) / 2
                }
            }
            return min
        }

        fun findMinFastest(nums: IntArray): Int {
            var i = 0
            var j = nums.size - 1
            while (i < j) {
                val middle = i + (j - i) / 2
                if (nums[middle] > nums[j]) {
                    i = middle + 1
                } else {
                    j = middle
                }
            }
            return nums[i]
        }

        fun findMin(nums: IntArray): Int {
            var min = 10000
            for (count in 0..nums.size - 1) {
                if (nums[count] < min) {
                    min = nums[count]
                }
            }
            return min
        }

        fun findMinRecursive(nums: IntArray): Int {
            val min = find(nums, 0, nums.size - 1)
            return min
        }

        fun find(nums: IntArray, i: Int, j: Int): Int {
            if (i == j) {
                return nums[i]
            }
            val middle = (i + j) / 2
            return min(find(nums, i, middle), find(nums, middle + 1, j))
        }
    }
}