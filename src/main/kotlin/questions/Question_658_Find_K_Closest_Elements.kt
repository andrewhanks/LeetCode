package questions

import kotlin.math.abs

class Question_658_Find_K_Closest_Elements {

    companion object {

        fun runQuestion() {
//            Input: arr = [1,2,3,4,5], k = 4, x = 3
//            Output: [1,2,3,4]
            val arr = intArrayOf(1, 2, 3, 4, 5)
            val k = 4
            val x = 3
            val result = findClosestElements(arr, k, x)
            println("Question 658: $result")
        }

        fun findClosestElements(arr: IntArray, k: Int, x: Int): List<Int> {
            var count = 0
            while (count <= arr.size - 1 && arr[count] < x) {
                count++
            }
            var i = count - 1
            var j = count
            val result: MutableList<Int> = mutableListOf()
            while (result.size < k && result.size < arr.size) {
                if (i >= 0 && j <= arr.size - 1) {
                    if (abs(arr[i] - x) <= abs(arr[j] - x)) {
                        result.add(arr[i])
                        i--
                    } else if (abs(arr[j] - x) < abs(arr[i] - x)) {
                        result.add(arr[j])
                        j++
                    }
                } else if (i < 0) {
                    result.add(arr[j])
                    j++
                } else if (j > arr.size - 1) {
                    result.add(arr[i])
                    i--
                }
            }
            return result.sorted()
        }
    }
}