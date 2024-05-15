package questions

class Question_31_Next_Permutation {

    companion object {

        fun runQuestion() {
//            Input: nums = [1,2,3]
//            Output: [1,3,2]
            val nums = intArrayOf(1, 2, 3)
            nextPermutation(nums)
            println("Question 31: ${nums.contentToString()}")
        }

        fun nextPermutation(nums: IntArray): Unit {
            var insert = nums.size - 1
            while (insert >= 1 && nums[insert] <= nums[insert - 1]) {
                insert--
            }
            insert--
            var target = insert + 1
            // println("insert = $insert")
            if (insert > -1) {
                while (target <= nums.size - 1 && nums[target] > nums[insert]) {
                    target++
                }
                target--
                swap(nums, insert, target)
            }
            // println("target = $target")
            reverseFrom(nums, insert + 1)
        }

        fun swap(nums: IntArray, i: Int, j: Int) {
            val temp = nums[i]
            nums[i] = nums[j]
            nums[j] = temp
        }

        fun reverseFrom(nums: IntArray, index: Int) {
            var start = index
            var end = nums.size - 1
            while (start < end) {
                swap(nums, start, end)
                start++
                end--
            }
        }
    }
}