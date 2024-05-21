package questions

class Question_1356_Sort_Integers_by_The_Number_of_1_Bits {

    companion object {

        fun runQuestion() {
//            Input: arr = [0,1,2,3,4,5,6,7,8]
//            Output: [0,1,2,4,8,3,5,6,7]
            val arr = intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8)
            val result = sortByBits(arr)
            println("Question 1356: ${result.contentToString()}")
        }

        fun sortByBits(arr: IntArray): IntArray {
            arr.sort()
            return arr.sortedBy { bitCount(it) }.toIntArray()
        }

        fun bitCount(n: Int): Int {
            var count = 0
            var temp = n
            while (temp > 0) {
                temp = temp and (temp - 1)
                count++
            }
            return count
        }

        fun sortByBitsWithMap(arr: IntArray): IntArray {
            val temp: MutableMap<Int, MutableList<Int>> = mutableMapOf()
            for (count in 0..arr.size - 1) {
                val binaryString = arr[count].toString(2)
                val number1 = binaryString.filter { it == '1' }.count()
                if (!temp.contains(number1)) {
                    temp.put(number1, mutableListOf(arr[count]))
                } else {
                    temp[number1]!!.add(arr[count])
                }
            }
            val sortedMap = temp.toSortedMap()
            val result: MutableList<Int> = mutableListOf()
            for ((key, value) in sortedMap) {
                value.sorted().forEach {
                    result.add(it)
                }
            }
            return result.toIntArray()
        }
    }
}