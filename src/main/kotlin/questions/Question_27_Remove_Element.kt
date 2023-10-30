package questions

class Question_27_Remove_Element {

    companion object {

        fun runQuestion() {
//            Input: nums = [0,1,2,2,3,0,4,2], val = 2
//            Output: 5, nums = [0,1,4,0,3,_,_,_]
            val nums = intArrayOf(0, 1, 2, 2, 3, 0, 4, 2)
            val `val` = 2
            val result = removeElement(nums, `val`)
            println("Question 27: $result")
        }

        fun removeElement(nums: IntArray, `val`: Int): Int {
            for (count in 0..nums.size - 1) {
                if (nums[count] == `val`) {
                    nums[count] = Int.MAX_VALUE
                }
            }
            nums.sort()
            return nums.filter { it != Int.MAX_VALUE }.count()
        }

        fun removeElementReplaceDirectly(nums: IntArray, `val`: Int): Int {
            var index = 0
            for (count in 0..nums.size - 1) {
                if (nums[count] != `val`) {
                    nums[index] = nums[count]
                    index++
                }
            }
            return index
        }
    }
}