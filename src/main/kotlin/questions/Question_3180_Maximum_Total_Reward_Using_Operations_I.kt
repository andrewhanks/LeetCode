package questions

import kotlin.math.max


class Question_3180_Maximum_Total_Reward_Using_Operations_I {

    companion object {

        fun runQuestion() {
//            Input: rewardValues = [1,6,4,3,2]
//            Output: 11
            val rewardValues = intArrayOf(1, 6, 4, 3, 2)
            val result = maxTotalReward(rewardValues)
            println("Question 3180: $result")
        }

        fun maxTotalReward(rewardValues: IntArray): Int {
            var sum = 0
            for (count in 0..rewardValues.size - 1) {
                sum += rewardValues[count]
            }
            val result = IntArray(sum + 1) { -1 }
            return dp(rewardValues.sorted().toIntArray(), 0, 0, result)
        }

        fun dp(rewardValues: IntArray, index: Int, lastSum: Int, result: IntArray): Int {
            if (index >= rewardValues.size) {
                return 0
            }
            if (result[lastSum] != -1) {
                return result[lastSum]
            }
            var include = 0
            if (rewardValues[index] > lastSum) {
                include = rewardValues[index] + dp(rewardValues, index + 1, lastSum + rewardValues[index], result)
            }
            val exclude = 0 + dp(rewardValues, index + 1, lastSum, result)
            result[lastSum] = max(include, exclude)
            return result[lastSum]
        }
    }
}