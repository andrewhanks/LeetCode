package questions

import kotlin.math.abs


class Question_2607_Make_K_Subarray_Sums_Equal {

    companion object {

        fun runQuestion() {
//            Input: arr = [2,5,5,7], k = 3
//            Output: 5
            val arr = intArrayOf(2, 5, 5, 7)
            val k = 3
            val result = makeSubKSumEqual(arr, k)
            println("Question 2607: $result")
        }

        fun makeSubKSumEqual(arr: IntArray, k: Int): Long {
            var totalOperations = 0L
            for (count in 0..k - 1) {
                val picked: MutableList<Int> = mutableListOf()
                var number = count
                while (arr[number] != 0) {
                    picked.add(arr[number])
                    arr[number] = 0
                    number = (number + k) % arr.size
                }
                picked.sort()
                for (number in 0..picked.size - 1) {
                    totalOperations += abs(picked[number] - picked[picked.size / 2])
                }
            }
            return totalOperations
        }
    }
}