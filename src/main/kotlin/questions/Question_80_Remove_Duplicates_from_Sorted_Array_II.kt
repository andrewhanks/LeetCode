package questions


class Question_80_Remove_Duplicates_from_Sorted_Array_II {

    companion object {

        fun runQuestion() {
            // [0,0,1,1,1,1,2,3,3]
            val intArray = intArrayOf(0, 0, 1, 1, 1, 1, 2, 3, 3)
            val returned = removeDuplicates(intArray)
            var result = "["
            intArray.forEachIndexed { index, i ->
                result += i
                if (index == intArray.size - 1) {
                    result += "]"
                } else {
                    result += ","
                }
            }
            println("Question 80: $returned $result")
        }

        fun removeDuplicates(nums: IntArray): Int {
            val stone = -100000
            var tempNum = nums[0]
            var times = 0
            var count = 0
            while (count <= nums.size - 1) {
                if (nums[count] != stone && nums[count] == tempNum) {
                    if (times >= 2) {
                        for (tempCount in count..nums.size - 2) {
                            nums[tempCount] = nums[tempCount + 1]
                        }
                        nums[nums.size - 1] = stone
                        count--
                    }
                    times++
                } else {
                    tempNum = nums[count]
                    times = 1
                }
                println("tempNum = $tempNum, times = $times, nums[count] = ${nums[count]}")
                count++
            }
            return nums.filter { it != stone }.count()
        }

        fun removeDuplicatesQuick(nums: IntArray): Int {
            if (nums.size <= 2) {
                return nums.size
            }
            var overridePos = 2
            for (count in 2..nums.size - 1) {
                if (nums[overridePos - 2] != nums[count]) {
                    nums[overridePos] = nums[count]
                    overridePos++
                }
            }
            return overridePos
        }
    }
}