package questions

class Question_34_Find_First_and_Last_Position_of_Element_in_Sorted_Array {

    companion object {

        fun runQuestion() {
//            Input: nums = [5,7,7,8,8,10], target = 8
//            Output: [3,4]
            val nums = intArrayOf(5, 7, 7, 8, 8, 10)
            val target = 8
            val resultList = searchRange(nums, target)
            var result = "["
            resultList.forEachIndexed { index, i ->
                result += i
                if (index == resultList.size - 1) {
                    result += "]"
                } else {
                    result += ","
                }
            }
            println("Question 34: $result")
        }

        fun searchRange(nums: IntArray, target: Int): IntArray {
            val left = binarySearch(nums, target, true)
            val right = binarySearch(nums, target, false)
            return intArrayOf(left, right)
        }

        fun binarySearch(nums: IntArray, target: Int, left: Boolean): Int {
            var start = 0
            var end = nums.size - 1
            var index = -1
            while (start <= end) {
                val mid = start + (end - start) / 2
                if (target > nums[mid]) {
                    start = mid + 1
                } else if (target < nums[mid]) {
                    end = mid - 1
                } else {
                    index = mid
                    if (left) {
                        end = mid - 1
                    } else {
                        start = mid + 1
                    }
                }
            }
            return index
        }

        fun searchRangeLinearSearch(nums: IntArray, target: Int): IntArray {
            val result: IntArray = IntArray(2) { -1 }
            for (count in 0..nums.size - 1) {
                if (result[0] == -1 && target == nums[count]) {
                    result[0] = count
                }
                if (target == nums[count]) {
                    result[1] = count
                }
            }
            return result
        }
    }
}