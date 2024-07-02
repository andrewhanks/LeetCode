package questions

class Question_179_Largest_Number {

    companion object {

        fun runQuestion() {
//            Input: nums = [3,30,34,5,9]
//            Output: "9534330"
            val nums = intArrayOf(3, 30, 34, 5, 9)
            val result = largestNumber(nums)
            println("Question 179: $result")
        }

        fun largestNumber(nums: IntArray): String {
            val result = Array(nums.size) { "" }
            for (count in 0..nums.size - 1) {
                result[count] = nums[count].toString()
            }
            result.sortWith(Comparator { a, b -> (b + a).compareTo(a + b) })
            // println(result.contentToString())
            if (result[0] == "0") {
                return "0"
            }
            var ret = ""
            for (count in 0..result.size - 1) {
                ret += result[count]
            }
            return ret
        }
    }
}