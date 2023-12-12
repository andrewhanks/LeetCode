package questions

class Question_2357_Make_Array_Zero_by_Subtracting_Equal_Amounts {

    companion object {

        fun runQuestion() {
//            Input: nums = [1,5,0,3,5]
//            Output: 3
            val nums = intArrayOf(1, 5, 0, 3, 5)
            val result = minimumOperations(nums)
            println("Question 2357: $result")
        }

        fun minimumOperations(nums: IntArray): Int {
            var result: MutableList<Int> = nums.filter { it != 0 }.sorted().toMutableList()
            var total = 0
            while (result.size > 0) {
                val min = result.removeAt(0)
                for (count in 0..result.size - 1) {
                    result[count] = result[count] - min
                }
                total++
                result = result.filter { it != 0 }.sorted().toMutableList()
            }
            return total
        }

        fun minimumOperationsDistinctCount(nums: IntArray): Int {
            return nums.filter { it != 0 }.distinct().count()
        }

        fun minimumOperationsSet(nums: IntArray): Int {
            val result: MutableSet<Int> = mutableSetOf()
            for (count in 0..nums.size - 1) {
                if (nums[count] != 0) {
                    result.add(nums[count])
                }
            }
            return result.size
        }
    }
}