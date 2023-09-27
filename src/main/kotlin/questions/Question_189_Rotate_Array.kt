package questions

class Question_189_Rotate_Array {

    companion object {

        fun runQuestion() {
            // [1,2,3,4,5,6,7]
            val k = 3
            val numberArray = intArrayOf(1, 2, 3, 4, 5, 6, 7)
            rotate(numberArray, k)
            var result = "["
            numberArray.forEachIndexed { index, i ->
                result += i
                if (index == numberArray.size - 1) {
                    result += "]"
                } else {
                    result += ","
                }
            }
            println("Question 75: $result")
        }

        fun rotate(nums: IntArray, k: Int): Unit {
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