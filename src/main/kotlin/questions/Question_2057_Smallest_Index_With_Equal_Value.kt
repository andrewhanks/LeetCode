package questions

class Question_2057_Smallest_Index_With_Equal_Value {

    companion object {

        fun runQuestion2057() {
            val numberArray = intArrayOf(4, 3, 2, 1)
            val result = smallestEqual(numberArray)
            println("Question 2057: $result")
        }

        fun smallestEqual(nums: IntArray): Int {
            nums.forEachIndexed { index, value ->
                if (index % 10 == value) {
                    return index
                }
            }
            return -1
        }
    }
}