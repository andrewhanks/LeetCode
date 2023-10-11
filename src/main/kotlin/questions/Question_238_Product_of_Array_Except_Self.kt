package questions

class Question_238_Product_of_Array_Except_Self {

    companion object {

        fun runQuestion() {
            val inputIntArray = intArrayOf(1, 2, 3, 4)
            val resultList = productExceptSelf(inputIntArray)
            var result = "["
            resultList.forEachIndexed { index, i ->
                result += i
                if (index == resultList.size - 1) {
                    result += "]"
                } else {
                    result += ","
                }
            }
            println("Question 238: $result")
        }

        fun productExceptSelf(nums: IntArray): IntArray {
            val result: IntArray = IntArray(nums.size) { 0 }
            var prefixProduct = 1
            var suffixProduct = 1
            for (count in 0..nums.size - 1) {
                result[count] = prefixProduct
                prefixProduct *= nums[count]
            }
            for (count in nums.size - 1 downTo 0) {
                result[count] *= suffixProduct
                suffixProduct *= nums[count]
            }
            return result
        }

        fun productExceptSelfSelf(nums: IntArray): IntArray {
            if (nums.contains(0)) {
                if (nums.filter { it == 0 }.count() >= 2) {
                    return IntArray(nums.size) { 0 }
                } else {
                    val indexOfZero = nums.indexOf(0)
                    val result: IntArray = IntArray(nums.size) { 0 }
                    result[indexOfZero] = 1
                    for (count in 0..nums.size - 1) {
                        if (nums[count] != 0) {
                            result[indexOfZero] *= nums[count]
                        }
                    }
                    return result
                }
            } else {
                val result: IntArray = IntArray(nums.size) { 1 }
                var total = 1
                for (count in 0..nums.size - 1) {
                    total *= nums[count]
                }
                for (count in 0..nums.size - 1) {
                    result[count] = total / nums[count]
                }
                return result
            }
        }
    }
}