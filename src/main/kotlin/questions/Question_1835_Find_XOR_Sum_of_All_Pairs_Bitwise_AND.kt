package questions


class Question_1835_Find_XOR_Sum_of_All_Pairs_Bitwise_AND {

    companion object {

        fun runQuestion() {
//            Input: arr1 = [1,2,3], arr2 = [6,5]
//            Output: 0
            val arr1 = intArrayOf(1, 2, 3)
            val arr2 = intArrayOf(6, 5)
            val result = getXORSum(arr1, arr2)
            println("Question 1835: $result")
        }

        fun getXORSum(arr1: IntArray, arr2: IntArray): Int {
            var arr1Xor = 0
            var arr2Xor = 0
            for (item in arr1) {
                arr1Xor = arr1Xor xor item
            }
            for (item in arr2) {
                arr2Xor = arr2Xor xor item
            }
            return arr1Xor and arr2Xor
        }
    }
}