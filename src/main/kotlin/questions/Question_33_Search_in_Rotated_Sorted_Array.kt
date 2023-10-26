package questions

import java.util.*

class Question_33_Search_in_Rotated_Sorted_Array {

    companion object {

        fun runQuestion() {
//            Input: nums = [4,5,6,7,0,1,2], target = 0
//            Output: 4
            val nums = intArrayOf(4, 5, 6, 7, 0, 1, 2)
            val target = 0
            val result = search(nums, target)
            println("Question 33: $result")
        }

        fun search(nums: IntArray, target: Int): Int {
            for (count in 0..nums.size - 1) {
                if (nums[count] == target) {
                    return count
                }
            }
            return -1
        }

        fun searchBinarySearch(nums: IntArray, target: Int): Int {
            var start = 0
            var end = nums.size - 1
            while (start <= end) {
                println("start = $start, end = $end")
                val mid = (start + end) / 2
                if (nums[mid] == target) {
                    return mid
                } else if (nums[mid] >= nums[start]) {
                    if (target >= nums[start] && target <= nums[mid]) {
                        end = mid - 1
                    } else {
                        start = mid + 1
                    }
                } else if (nums[end] >= nums[mid]) {
                    if (target >= nums[mid] && target <= nums[end]) {
                        start = mid + 1
                    } else {
                        end = mid - 1
                    }
                }
            }
            return -1
        }
    }
}