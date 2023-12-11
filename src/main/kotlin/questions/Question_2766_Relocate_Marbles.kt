package questions

class Question_2766_Relocate_Marbles {

    companion object {

        fun runQuestion() {
//            Input: nums = [1,1,3,3], moveFrom = [1,3], moveTo = [2,2]
//            Output: [2]
            val nums = intArrayOf(1, 1, 3, 3)
            val moveFrom = intArrayOf(1, 3)
            val moveTo = intArrayOf(2, 2)
            val result = relocateMarbles(nums, moveFrom, moveTo).toString()
            println("Question 2766: $result")
        }

        fun relocateMarbles(nums: IntArray, moveFrom: IntArray, moveTo: IntArray): List<Int> {
            val temp = nums.distinct().toIntArray()
            for (step in 0..moveFrom.size - 1) {
                for (position in 0..temp.size - 1) {
                    if (temp[position] == moveFrom[step]) {
                        temp[position] = moveTo[step]
                    }
                }
            }
            val result = temp.sorted().toMutableList()
            var count = 1
            while (count <= result.size - 1) {
                if (result[count] == result[count - 1]) {
                    result.removeAt(count)
                } else {
                    count++
                }
            }
            return result.toList()
        }
    }
}