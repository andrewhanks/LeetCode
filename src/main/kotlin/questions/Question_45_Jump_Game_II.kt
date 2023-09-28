package questions

class Question_45_Jump_Game_II {

    companion object {

        fun runQuestion() {
            // [2,3,0,1,4]
            val array = intArrayOf(2, 3, 0, 1, 4)
            val result = jump(array)
            println("Question 45: $result")
        }

        fun jump(nums: IntArray): Int {
            var currentPosition = nums.size - 1
            var tempPosition = currentPosition
            var result = 0
            while (currentPosition > 0) {
                for (count in currentPosition - 1 downTo 0) {
                    if (nums[count] + count >= currentPosition && count < tempPosition) {
                        tempPosition = count
                    }
                }
                currentPosition = tempPosition
                result++
                println("currentPosition = $currentPosition, result = $result")
            }
            return result
        }
    }
}