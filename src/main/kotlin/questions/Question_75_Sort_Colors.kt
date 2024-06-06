package questions

class Question_75_Sort_Colors {

    companion object {

        fun runQuestion() {
//            Input: nums = [2,0,2,1,1,0]
//            Output: [0,0,1,1,2,2]
            val numberArray = intArrayOf(2, 0, 2, 1, 1, 0)
            sortColors(numberArray)
            var result = "["
            numberArray.forEachIndexed { index, i ->
                result += i
                if (index == numberArray.size - 1) {
                    result += "]"
                } else {
                    result += ","
                }
            }
            println("Question 75: $result")
        }

        fun sortColors(nums: IntArray): Unit {
            for (x in 0..nums.size - 2) {
                for (y in 0..nums.size - 2 - x) {
                    if (nums[y] > nums[y + 1]) {
                        val tempNum = nums[y]
                        nums[y] = nums[y + 1]
                        nums[y + 1] = tempNum
                    }
                }
            }
        }

        fun sortColorsSelectionSort(nums: IntArray): Unit {
            var map: MutableMap<Int, Int> = mutableMapOf(0 to 0)
            for (i in 0..nums.size - 2) {
                var min = nums[i + 1]
                map[min] = i + 1
                for (j in i + 1..nums.size - 1) {
                    if (min > nums[j]) {
                        min = nums[j]
                        map[min] = j
                    }
                    if (j == nums.size - 1 && nums[map[min]!!] < nums[i]) {
                        val temp = nums[map[min]!!]
                        nums[map[min]!!] = nums[i]
                        nums[i] = temp
                    }
                }
            }
        }
    }
}