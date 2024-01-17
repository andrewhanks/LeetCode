package questions


class Question_704_Binary_Search {

    companion object {

        fun runQuestion() {
//            Input: nums = [-1,0,3,5,9,12], target = 9
//            Output: 4
            val nums = intArrayOf(-1, 0, 3, 5, 9, 12)
            val target = 9
            val result = search(nums, target)
            println("Question 704: $result")
        }

        fun search(nums: IntArray, target: Int): Int {
            var start = 0
            var end = nums.size - 1
            while (start < end) {
                val mid = start + (end - start) / 2
                if (nums[mid] == target) {
                    return mid
                }
                if (target > nums[mid]) {
                    start = mid + 1
                } else {
                    end = mid
                }
            }
            if (start == end && nums[start] == target) {
                return start
            }
            return -1
        }
    }
}