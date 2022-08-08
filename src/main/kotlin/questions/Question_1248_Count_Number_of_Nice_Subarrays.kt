package questions


class Question_1248_Count_Number_of_Nice_Subarrays {

    companion object {

        fun runQuestion() {
            val numberArray = intArrayOf(1, 1, 2, 1, 1)
            val number = 3
            val result = numberOfSubarrays(numberArray, number)
            println("Question 1248: $result")
        }

        fun numberOfSubarrays(nums: IntArray, k: Int): Int {
            var result = 0
            val oddPosition: MutableList<Int> = mutableListOf()
            nums.forEachIndexed { index, value ->
                if (value % 2 == 1) {
                    oddPosition.add(index)
                }
            }
            if (oddPosition.size < k) {
                return 0
            }
            for (count in 0..oddPosition.size - k) {
                println("count = $count, k = $k, oddPosition.size = ${oddPosition.size}")
                if (count == 0) {
                    if (count + k - 1 < oddPosition.size - 1) {
                        result += (oddPosition[count] + 1) * (oddPosition[count + k] - oddPosition[count + k - 1])
                        println("-0 +N result = $result")
                    } else {
                        // this array includes exactly k odd numbers
                        result += (oddPosition[count] + 1) * (nums.size - 1 - oddPosition[count + k - 1] + 1)
                        println("-0 +0 result = $result")
                    }
                } else if (count + k - 1 == oddPosition.size - 1) {
                    result += (oddPosition[count] - oddPosition[count - 1]) * (nums.size - oddPosition[count + k - 1])
                    println("-N +0 result = $result")
                } else {
                    result += (oddPosition[count] - oddPosition[count - 1]) * (oddPosition[count + k] - oddPosition[count + k - 1])
                    println("-N +N result = $result")
                }
            }
            return result
        }
    }
}