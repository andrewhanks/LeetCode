package questions

class Question_2121_Intervals_Between_Identical_Elements {

    companion object {

        fun runQuestion() {
//            Input: arr = [2,1,3,1,2,3,3]
//            Output: [4,2,7,2,4,4,5]
            val arr = intArrayOf(2, 1, 3, 1, 2, 3, 3)
            val result = getDistances(arr)
            println("Question 1054: ${result.contentToString()}")
        }

        fun getDistances(arr: IntArray): LongArray {
            val map: MutableMap<Int, MutableList<Int>> = mutableMapOf()
            var ans = LongArray(arr.size) { 0L }
            for (i in 0..arr.size - 1) {
                val list = map.getOrDefault(arr[i], mutableListOf())
                list.add(i)
                map[arr[i]] = list
            }
            for ((key, value) in map) {
                val prefixSum = LongArray(value.size) { 0L }
                var sum = 0L
                for (i in 0..value.size - 1) {
                    sum += value[i]
                    prefixSum[i] = sum
                }
                for (i in 0..prefixSum.size - 1) {
                    val rightSum = prefixSum[prefixSum.size - 1] - prefixSum[i]
                    val leftSum = if (i == 0) {
                        0L
                    } else {
                        prefixSum[i - 1]
                    }
                    ans[value[i]] = (rightSum - leftSum) - ((prefixSum.size - 1 - i) - (i)) * value[i].toLong()
                }
            }
            return ans
        }
    }
}