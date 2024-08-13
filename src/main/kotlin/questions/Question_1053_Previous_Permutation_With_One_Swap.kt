package questions

class Question_1053_Previous_Permutation_With_One_Swap {

    companion object {

        fun runQuestion() {
//            Input: arr = [1,9,4,6,7]
//            Output: [1,7,4,6,9]
            val inputArray = intArrayOf(1, 9, 4, 6, 7)
            val result = prevPermOpt1(inputArray)
            println("Question 1053: ${result.contentToString()}")
        }

        fun prevPermOpt1(arr: IntArray): IntArray {
            var i = arr.size - 1
            while (i >= 1 && arr[i] >= arr[i - 1]) {
                i--
            }
            i--
            if (i < 0) {
                return arr
            } else {
                var j = i + 1
                while (j <= arr.size - 1 && arr[j] < arr[i]) {
                    j++
                }
                j--
                while (j - 1 >= 0 && arr[j] == arr[j - 1]) {
                    j--
                }
                swap(arr, i, j)
                return arr
            }
        }

        fun swap(arr: IntArray, i: Int, j: Int) {
            val temp = arr[j]
            arr[j] = arr[i]
            arr[i] = temp
        }
    }
}