package questions

import kotlin.math.max

class Question_3186_Maximum_Total_Damage_With_Spell_Casting {

    companion object {

        fun runQuestion() {
//            Input: power = [1,1,3,4]
//            Output: 6
            val intArray = intArrayOf(1, 1, 3, 4)
            val result = maximumTotalDamage(intArray)
            println("Question 3186: $result")
        }

        fun maximumTotalDamage(power: IntArray): Long {
            val result = Array(power.size) { -1L }
            val max = dp(power.sorted().toIntArray(), result, 0)
            println("result = ${result.contentToString()}")
            return max
        }

        fun dp(power: IntArray, result: Array<Long>, index: Int): Long {
            if (index >= power.size) {
                return 0
            }
            if (result[index] != -1L) {
                return result[index]
            }
            var firstOcc = index
            var lastOcc = index
            while (lastOcc <= power.size - 1 && power[firstOcc] == power[lastOcc]) {
                lastOcc++
            }
            lastOcc--
            val notTaken = dp(power, result, lastOcc + 1)
            var count = lastOcc + 1
            while (count <= power.size - 1 && power[count] <= power[index] + 2) {
                count++
            }
            val taken = power[index].toLong() * (lastOcc - firstOcc + 1) + dp(power, result, count)
            result[index] = max(notTaken, taken)
            return result[index]
        }
    }
}