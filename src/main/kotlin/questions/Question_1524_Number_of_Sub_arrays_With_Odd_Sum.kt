package questions

class Question_1524_Number_of_Sub_arrays_With_Odd_Sum {

    companion object {

        fun runQuestion() {
//            Input: arr = [1,2,3,4,5,6,7]
//            Output: 16
            val arr = intArrayOf(1, 2, 3, 4, 5, 6, 7)
            val result = numOfSubarrays(arr)
            println("Question 1524: $result")
        }

        fun numOfSubarrays(arr: IntArray): Int {
            val mod = 1000000007
            var oddPrefix = 0L
            var evenPrefix = 1L
            var sum = 0L
            for (count in 0..arr.size - 1) {
                sum += arr[count]
                if (sum % 2 == 1L) {
                    oddPrefix++
                } else {
                    evenPrefix++
                }
            }
            return (oddPrefix * evenPrefix % mod).toInt()
        }
    }
}