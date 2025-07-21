package questions


class Question_768_Max_Chunks_To_Make_Sorted_II {

    companion object {

        fun runQuestion() {
//            Input: arr = [5,4,3,2,1]
//            Output: 1
            val arr = intArrayOf(5, 4, 3, 2, 1)
            val result = maxChunksToSorted(arr)
            println("Question 768: $result")
        }

        fun maxChunksToSorted(arr: IntArray): Int {
            val sorted = arr.sorted()
            var ans = 0
            var arrSum = 0
            var sortedSum = 0
            for (i in 0..arr.size - 1) {
                arrSum += arr[i]
                sortedSum += sorted[i]
                if (arrSum == sortedSum) {
                    ans++
                    arrSum = 0
                    sortedSum = 0
                }
            }
            return ans
        }
    }
}