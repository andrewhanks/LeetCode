package questions

class Question_55_Jump_Game {

    companion object {

        fun runQuestion() {
            // [3,2,1,0,4]
            val array = intArrayOf(3, 2, 1, 0, 4)
            val result = canJump(array)
            println("Question 55: $result")
        }

        fun canJump(nums: IntArray): Boolean {
            if (nums.size == 1) {
                return true
            }
            var maxReachPos = 0
            nums.forEachIndexed { index, value ->
                if (maxReachPos < index + value) {
                    maxReachPos = index + value
                }
                if (index >= maxReachPos) {
                    return false
                }
                if (index + value >= nums.size - 1) {
                    return true
                }
            }
            return false
        }
    }
}