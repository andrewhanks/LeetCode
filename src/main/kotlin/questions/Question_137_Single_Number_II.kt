package questions

class Question_137_Single_Number_II {

    companion object {

        fun runQuestion() {
            val input = intArrayOf(2, 2, 3, 2)
            val result = singleNumber(input)
            println("Question 137: $result")
        }

        fun singleNumber(nums: IntArray): Int {
            val collection: MutableMap<Int, Int> = mutableMapOf()
            nums.forEach {
                if (collection.containsKey(it)) {
                    collection[it] = collection[it]!! + 1
                } else {
                    collection[it] = 1
                }
            }
            collection.forEach {
                if (collection[it.key] != 3) {
                    return it.key
                }
            }
            return -1
        }

        fun singleNumberSort(nums: IntArray): Int {
            nums.sort()
            var previous = nums[0]
            var times = 0
            nums.forEach {
                if (times != 3 && previous != it) {
                    return previous
                } else if (previous == it) {
                    times++
                } else {
                    previous = it
                    times = 1
                }
                println("$it, $times, $previous")
            }
            return previous
        }
    }
}