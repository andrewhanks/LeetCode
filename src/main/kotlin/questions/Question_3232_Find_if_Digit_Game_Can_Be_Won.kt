package questions

class Question_3232_Find_if_Digit_Game_Can_Be_Won {

    companion object {

        fun runQuestion() {
//            Input: nums = [1,2,3,4,10]
//            Output: false
            val numberArray = intArrayOf(1, 2, 3, 4, 10)
            val result = canAliceWin(numberArray)
            println("Question 3232: $result")
        }

        fun canAliceWin(nums: IntArray): Boolean {
            var oneDigitSum = 0
            var twoDigitSum = 0
            for (count in 0..nums.size - 1) {
                if (nums[count] / 10 == 0) {
                    oneDigitSum += nums[count]
                } else {
                    twoDigitSum += nums[count]
                }
            }
            // println("oneDigitSum = $oneDigitSum, twoDigitSum = $twoDigitSum")
            if (oneDigitSum > twoDigitSum || twoDigitSum > oneDigitSum) {
                return true
            } else {
                return false
            }
        }
    }
}