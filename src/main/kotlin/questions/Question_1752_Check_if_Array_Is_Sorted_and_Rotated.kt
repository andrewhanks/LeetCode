package questions

class Question_1752_Check_if_Array_Is_Sorted_and_Rotated {

    companion object {

        fun runQuestion() {
//            Input: nums = [2,1,3,4]
//            Output: false
            val nums = intArrayOf(2, 1, 3, 4)
            val result = check(nums)
            println("Question 1752: $result")
        }

        fun check(nums: IntArray): Boolean {
            var breakTimes = 0
            for (count in 1..nums.size - 1) {
                if (nums[count] < nums[count - 1]) {
                    breakTimes++
                    if (breakTimes >= 2) {
                        return false
                    }
                }
            }
            if (nums[nums.size - 1] <= nums[0] && breakTimes == 1 || nums[nums.size - 1] >= nums[0] && breakTimes == 0) {
                return true
            } else {
                return false
            }
        }

        fun checkBreakAndCompare(nums: IntArray): Boolean {
            var breakPoint = -1
            for (count in 1..nums.size - 1) {
                if (nums[count] < nums[count - 1]) {
                    breakPoint = count - 1
                    break
                }
            }
            println(breakPoint)
            val result: MutableList<Int> = nums.toMutableList()
            for (count in 0..breakPoint) {
                val temp = result.removeAt(0)
                result.add(temp)
            }
            println(result)
            if (result == result.sorted()) {
                return true
            } else {
                return false
            }
        }
    }
}