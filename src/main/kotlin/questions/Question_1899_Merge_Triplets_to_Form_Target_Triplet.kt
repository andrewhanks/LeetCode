package questions

import kotlin.math.max


class Question_1899_Merge_Triplets_to_Form_Target_Triplet {

    companion object {

        fun runQuestion() {
//            nput: triplets = [[2,5,3],[1,8,4],[1,7,5]], target = [2,7,5]
//            Output: true
            val intArray = arrayOf(intArrayOf(2, 5, 3), intArrayOf(1, 8, 4), intArrayOf(1, 7, 5))
            val insertInterval = intArrayOf(2, 7, 5)
            val result = mergeTriplets(intArray, insertInterval)
            println("Question 1899: $result")
        }

        fun mergeTriplets(triplets: Array<IntArray>, target: IntArray): Boolean {
            var x = 0
            var y = 0
            var z = 0
            for (i in 0..triplets.size - 1) {
                if (triplets[i][0] <= target[0] && triplets[i][1] <= target[1] && triplets[i][2] <= target[2]) {
                    x = max(x, triplets[i][0])
                    y = max(y, triplets[i][1])
                    z = max(z, triplets[i][2])
                }
            }
            if (target[0] == x && target[1] == y && target[2] == z) {
                return true
            }
            return false
        }
    }
}