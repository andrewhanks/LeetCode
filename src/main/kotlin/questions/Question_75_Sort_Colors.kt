package questions

class Question_75_Sort_Colors {

    companion object {

        fun runQuestion() {
            // [2,0,2,1,1,0]
            val numberArray = intArrayOf(2, 0, 2, 1, 1, 0)
            sortColors(numberArray)
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

        fun sortColors(nums: IntArray): Unit {
            for (x in 0..nums.size - 2) {
                for (y in 0..nums.size - 2 - x) {
                    if (nums[y] > nums[y + 1]) {
                        val tempNum = nums[y]
                        nums[y] = nums[y + 1]
                        nums[y + 1] = tempNum
                    }
                }
            }
        }
    }
}