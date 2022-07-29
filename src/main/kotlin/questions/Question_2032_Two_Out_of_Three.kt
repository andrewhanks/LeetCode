package questions

class Question_2032_Two_Out_of_Three {

    companion object {

        fun runQuestion2032() {
            val numberArray1 = intArrayOf(1, 1, 3, 2)
            val numberArray2 = intArrayOf(2, 3)
            val numberArray3 = intArrayOf(3)
            val result = twoOutOfThree(numberArray1, numberArray2, numberArray3).toString()
            println("Question 2032: $result")
        }

        fun twoOutOfThree(nums1: IntArray, nums2: IntArray, nums3: IntArray): List<Int> {
            val result: MutableList<Int> = arrayListOf()
            for (number in nums1) {
                if (nums2.contains(number) || nums3.contains(number)) {
                    if (!result.contains(number)) {
                        result.add(number)
                    }
                }
            }
            for (number in nums2) {
                if (nums3.contains(number)) {
                    if (!result.contains(number)) {
                        result.add(number)
                    }
                }
            }
            return result
        }
    }
}