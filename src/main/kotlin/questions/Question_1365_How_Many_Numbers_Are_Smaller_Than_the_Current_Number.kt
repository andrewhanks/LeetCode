package questions

class Question_1365_How_Many_Numbers_Are_Smaller_Than_the_Current_Number {

    companion object {

        fun runQuestion() {
//            Input: nums = [8,1,2,2,3]
//            Output: [4,0,1,1,3]
            val inputIntArray = intArrayOf(8, 1, 2, 2, 3)
            val result = smallerNumbersThanCurrent(inputIntArray)
            println("Question 1365: ${result.contentToString()}")
        }

        fun smallerNumbersThanCurrent(nums: IntArray): IntArray {
            val result = IntArray(nums.size) { 0 }
            for (i in 0..nums.size - 1) {
                for (j in 0..nums.size - 1) {
                    if (i == j) {
                        continue
                    }
                    if (nums[i] > nums[j]) {
                        result[i]++
                    }
                }
            }
            return result
        }

        fun smallerNumbersThanCurrentFast(nums: IntArray): IntArray {
            val temp = IntArray(101) { 0 }
            for (num in nums) {
                temp[num]++
            }
            for (count in 1..temp.size - 1) {
                temp[count] += temp[count - 1]
            }
            // println(temp.contentToString())
            val result = IntArray(nums.size) { 0 }
            for (count in 0..nums.size - 1) {
                if (nums[count] == 0) {
                    continue
                }
                result[count] = temp[nums[count] - 1]
            }
            // println(result.contentToString())
            return result
        }
    }
}