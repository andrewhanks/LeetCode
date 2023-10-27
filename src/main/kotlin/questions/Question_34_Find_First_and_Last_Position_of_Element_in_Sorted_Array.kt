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