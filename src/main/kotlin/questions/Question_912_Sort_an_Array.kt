package questions

class Question_912_Sort_an_Array {

    companion object {

        fun runQuestion() {
//            Input: nums = [5,2,3,1]
//            Output: [1,2,3,5]
            val nums = intArrayOf(5, 2, 3, 1)
            val resultList = sortArray(nums)
            var result = "["
            resultList.forEachIndexed { index, i ->
                result += i
                if (index == resultList.size - 1) {
                    result += "]"
                } else {
                    result += ","
                }
            }
            println("Question 912: $result")
        }

        fun sortArray(nums: IntArray): IntArray {
            return mergeSort(nums)
        }

        fun mergeSort(nums: IntArray): IntArray {
            if (nums.size == 1) {
                return nums
            }
            val mid = (nums.size - 1) / 2
            val left = mergeSort(nums.copyOfRange(0, mid + 1))
            val right = mergeSort(nums.copyOfRange(mid + 1, nums.size))
            return merge(left, right)
        }

        fun merge(left: IntArray, right: IntArray): IntArray {
            val result: MutableList<Int> = mutableListOf()
            var leftCount = 0
            var rightCount = 0
            while (leftCount <= left.size - 1 && rightCount <= right.size - 1) {
                if (left[leftCount] <= right[rightCount]) {
                    result.add(left[leftCount])
                    leftCount++
                } else {
                    result.add(right[rightCount])
                    rightCount++
                }
            }
            while (leftCount <= left.size - 1) {
                result.add(left[leftCount])
                leftCount++
            }
            while (rightCount <= right.size - 1) {
                result.add(right[rightCount])
                rightCount++
            }
            return result.toIntArray()
        }

        fun sortArrayWithBuiltInFunction(nums: IntArray): IntArray {
            return nums.sorted().toIntArray()
        }
    }
}