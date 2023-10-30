package questions

class Question_26_Remove_Duplicates_from_Sorted_Array {

    companion object {

        fun runQuestion() {
//            Input: nums = [0,0,1,1,1,2,2,3,3,4]
//            Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
            val nums = intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)
            val result = removeDuplicates(nums)
            println("Question 26: $result")
        }

        fun removeDuplicates(nums: IntArray): Int {
            var index = 1
            for (count in 1..nums.size - 1) {
                if (nums[count] != nums[count - 1]) {
                    nums[index] = nums[count]
                    index++
                }
            }
            return index
        }
    }
}