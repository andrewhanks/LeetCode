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
            var jump = 0
            var currPos = 0
            var farPos = 0
            while (currPos < nums.size - 1) {
                var endPos = nums[currPos] + currPos
                if (endPos >= nums.size - 1) {
                    jump++
                    break
                }
                if (endPos > nums.size - 1) {
                    endPos = nums.size - 1
                }
                for (count in currPos..endPos) {
                    if (farPos <= nums[count] + count) {
                        farPos = nums[count] + count
                        currPos = count
                    }
                }
                jump++
            }
            return jump
        }

        fun jumpOld(nums: IntArray): Int {
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