package questions

class Question_162_Find_Peak_Element {

    companion object {

        fun runQuestion() {
//            Input: nums = [1,2,1,3,5,6,4]
//            Output: 1
            val nums = intArrayOf(1, 2, 1, 3, 5, 6, 4)
            val result = findPeakElement(nums)
            println("Question 162: $result")
        }

        fun findPeakElement(nums: IntArray): Int {
            if (nums.size == 1) {
                return 0
            }
            for (count in 0..nums.size - 1) {
                if (count >= 1 && count <= nums.size - 2 && nums[count] > nums[count - 1] && nums[count] > nums[count + 1]) {
                    return count
                } else if (count == 0) {
                    if (count + 1 <= nums.size - 1 && nums[count] > nums[count + 1]) {
                        return count
                    }
                } else if (count == nums.size - 1) {
                    if (count - 1 >= 0 && nums[count] > nums[count - 1]) {
                        return count
                    }
                }
            }
            return -1
        }

//        Case 1 : mid lies on the right of our result peak ( Observation : Our peak element search space is leftside )
//        Case 2 : mid is equal to the peak element ( Observation : mid element is greater than its neighbors )
//        Case 3 : mid lies on the left. ( Observation : Our peak element search space is rightside )
        fun findPeakElementBinarySearch(nums: IntArray): Int {
            if (nums.size == 1) {
                return 0
            }
            if (nums[0] > nums[1]) {
                return 0
            }
            if (nums[nums.size - 1] > nums[nums.size - 2]) {
                return nums.size - 1
            }
            var start = 1
            var end = nums.size - 2
            while (start <= end) {
                val mid = (start + end) / 2
                if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                    return mid
                } else if (nums[mid] < nums[mid - 1]) {
                    end = mid - 1
                } else if (nums[mid] < nums[mid + 1]) {
                    start = mid + 1
                }
            }
            return -1
        }
    }
}