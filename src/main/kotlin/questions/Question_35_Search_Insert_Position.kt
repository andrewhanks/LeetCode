package questions


class Question_35_Search_Insert_Position {

    companion object {

        fun runQuestion() {
//            Input: nums = [1,3,5,6], target = 2
//            Output: 1
            val nums = intArrayOf(1, 3, 5, 6)
            val target = 2
            val result = searchInsert(nums, target)
            println("Question 35: $result")
        }

        fun searchInsert(nums: IntArray, target: Int): Int {
            var start = 0
            var end = nums.size
            while (start < end) {
                val mid = start + (end - start) / 2
                if (nums[mid] < target) {
                    start = mid + 1
                } else {
                    end = mid
                }
            }
            return start
        }

        fun searchInsertOldSolution(nums: IntArray, target: Int): Int {
            var start = 0
            var end = nums.size - 1
            while (start < end) {
                val mid = (start + end) / 2
                println("start = $start, end = $end, mid = $mid")
                if (target == nums[mid]) {
                    return mid
                }
                if (target > nums[mid]) {
                    start = mid + 1
                } else {
                    end = mid - 1
                }
            }
            if (target <= nums[start]) {
                return start
            } else {
                return start + 1
            }
        }

        fun searchInsertLinear(nums: IntArray, target: Int): Int {
            var result = -1
            for (count in 0..nums.size - 1) {
                if (target == nums[count]) {
                    return count
                }
                if (target < nums[count]) {
                    result = count
                    break
                }
            }
            if (result == -1) {
                result = nums.size
            }
            if (nums.size - 1 >= result - 1 && result - 1 >= 0 && target < nums[result - 1]) {
                return result - 1
            } else {
                return result
            }
        }
    }
}