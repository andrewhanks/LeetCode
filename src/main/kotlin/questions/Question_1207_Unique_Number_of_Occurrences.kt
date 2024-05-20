package questions

class Question_1207_Unique_Number_of_Occurrences {

    companion object {

        fun runQuestion() {
//            Input: arr = [1,2,2,1,1,3]
//            Output: true
            val arr = intArrayOf(1, 2, 2, 1, 1, 3)
            val result = uniqueOccurrences(arr)
            println("Question 1207: $result")
        }

        fun uniqueOccurrences(arr: IntArray): Boolean {
            val result: MutableMap<Int, Int> = mutableMapOf()
            for (count in 0..arr.size - 1) {
                if (!result.contains(arr[count])) {
                    result.put(arr[count], 1)
                } else {
                    result[arr[count]] = result[arr[count]]!! + 1
                }
            }
            val occurrence: MutableList<Int> = mutableListOf()
            for ((key, value) in result) {
                if (occurrence.contains(value)) {
                    return false
                }
                occurrence.add(value)
            }
            return true
        }
    }
}