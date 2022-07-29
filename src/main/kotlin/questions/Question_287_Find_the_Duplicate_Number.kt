package questions

class Question_287_Find_the_Duplicate_Number {

    companion object {

        fun runQuestion287() {
            val inputIntArray = intArrayOf(1, 3, 4, 2, 2)
            val result = findDuplicate(inputIntArray)
            println("Question 287: $result")
        }

        fun findDuplicate(nums: IntArray): Int {
            var head = 1
            var tail = nums.size - 1
            while (head < tail) {
                val middle = head + (tail - head) / 2
                var totalNumberBetweenHeadAndMiddle = 0
                for (num in nums) {
                    if (num >= head && num <= middle) {
                        totalNumberBetweenHeadAndMiddle++
                    }
                }
                if (totalNumberBetweenHeadAndMiddle > middle - head + 1) {
                    tail = middle
                } else {
                    head = middle + 1
                }
            }
            return head
        }
    }
}