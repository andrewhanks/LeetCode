package questions

class Question_189_Rotate_Array {

    companion object {

        fun runQuestion() {
//            Input: nums = [1,2,3,4,5,6,7], k = 3
//            Output: [5,6,7,1,2,3,4]
            val k = 3
            val nums = intArrayOf(1, 2, 3, 4, 5, 6, 7)
            rotate(nums, k)
            println("Question 189: ${nums.contentToString()}")
        }

        fun rotate(nums: IntArray, k: Int): Unit {
            if (nums.size == 1) {
                return
            }
            var tempK = k
            while (tempK >= nums.size) {
                tempK -= nums.size
            }
            rotate(nums, 0, nums.size - tempK - 1)
            rotate(nums, nums.size - tempK, nums.size - 1)
            rotate(nums, 0, nums.size - 1)
        }

        fun rotate(nums: IntArray, start: Int, end: Int) {
            var i = start
            var j = end
            while (i < j) {
                val temp = nums[i]
                nums[i] = nums[j]
                nums[j] = temp
                i++
                j--
            }
        }

        fun rotateOldSolution(nums: IntArray, k: Int): Unit {
            var tempK = k
            while (tempK >= nums.size) {
                tempK -= nums.size
            }
            val temp: IntArray = IntArray(tempK)
            for (count in 0..tempK - 1) {
                temp[count] = nums[nums.size - tempK + count]
            }
            for (count in nums.size - 1 downTo 0) {
                if (count > tempK - 1) {
                    nums[count] = nums[count - tempK]
                } else {
                    nums[count] = temp[count]
                }
            }
        }
    }
}