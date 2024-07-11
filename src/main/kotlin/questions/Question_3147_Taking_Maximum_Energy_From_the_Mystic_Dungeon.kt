package questions

import kotlin.math.max


class Question_3147_Taking_Maximum_Energy_From_the_Mystic_Dungeon {

    companion object {

        fun runQuestion() {
//            Input: energy = [5,2,-10,-5,1], k = 3
//            Output: 3
            val energy = intArrayOf(5, 2, -10, -5, 1)
            val k = 3
            val result = maximumEnergy(energy, k)
            println("Question 3147: $result")
        }

        fun maximumEnergyQuicker(energy: IntArray, k: Int): Int {
            var result = Int.MIN_VALUE
            for (i in 1..k) {
                var prefixSum = 0
                for (j in energy.size - i downTo 0 step k) {
                    prefixSum += energy[j]
                    result = max(result, prefixSum)
                }
            }
            return result
        }

        fun maximumEnergy(energy: IntArray, k: Int): Int {
            val result = IntArray(energy.size) { 0 }
            for (i in 1..k) {
                var prefixSum = 0
                for (j in energy.size - i downTo 0 step k) {
                    prefixSum += energy[j]
                    result[j] = prefixSum
                }
            }
            // println(result.contentToString())
            return result.max()
        }

        fun maximumEnergyDp(energy: IntArray, k: Int): Int {
            val result = IntArray(energy.size) { -1 }
            var max = Int.MIN_VALUE
            for (count in 0..energy.size - 1) {
                max = max(max, dp(energy, k, count, result))
            }
            return max
        }

        fun dp(energy: IntArray, k: Int, index: Int, result: IntArray): Int {
            if (index >= energy.size) {
                return 0
            }
            if (result[index] != -1) {
                return result[index]
            }
            var ans = 0
            ans = ans + energy[index] + dp(energy, k, index + k, result)
            result[index] = ans
            return result[index]
        }
    }
}