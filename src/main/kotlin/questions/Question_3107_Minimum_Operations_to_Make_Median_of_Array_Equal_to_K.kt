package questions

class Question_3107_Minimum_Operations_to_Make_Median_of_Array_Equal_to_K {

    companion object {

        fun runQuestion() {
//            Input: nums = [2,5,6,8,5], k = 7
//            Output: 3
            val nums = intArrayOf(2, 5, 6, 8, 5)
            val k = 7
            val result = minOperationsToMakeMedianK(nums, k)
            println("Question 167: $result")
        }

        fun minOperationsToMakeMedianK(nums: IntArray, k: Int): Long {
            nums.sort()
            var current = nums.size / 2
            var sum = 0L
            if (k == nums[current]) {
                return 0
            } else if (k > nums[current]) {
                sum += (k - nums[current]).toLong()
                current++
                while (current <= nums.size - 1 && k > nums[current]) {
                    sum += (k - nums[current]).toLong()
                    current++
                }
            } else if (k < nums[current]) {
                sum += (nums[current] - k).toLong()
                current--
                while (current >= 0 && k < nums[current]) {
                    sum += (nums[current] - k).toLong()
                    current--
                }
            }
            return sum
        }
    }
}