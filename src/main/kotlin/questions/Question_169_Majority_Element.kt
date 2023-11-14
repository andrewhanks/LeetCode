package questions

class Question_169_Majority_Element {

    companion object {

        fun runQuestion() {
//            Input: nums = [2,2,1,1,1,2,2]
//            Output: 2
            val nums = intArrayOf(2, 2, 1, 1, 1, 2, 2)
            val result = majorityElement(nums)
            println("Question 169: $result")
        }

        fun majorityElement(nums: IntArray): Int {
            nums.sort()
            return nums[nums.size / 2]
        }

        fun majorityElementMooreVotingAlgorithm(nums: IntArray): Int {
            var major = 0
            var times = 0
            for(count in 0..nums.size-1) {
                if(major==0 || times==0) {
                    major = nums[count]
                    times = 1
                }else if (major==nums[count]) {
                    times++
                }else {
                    times--
                }
            }
            return major
        }

        fun majorityElementWithMap(nums: IntArray): Int {
            val result: MutableMap<Int, Int> = mutableMapOf()
            for (count in 0..nums.size - 1) {
                if (result.contains(nums[count])) {
                    result[nums[count]] = result[nums[count]]!! + 1
                } else {
                    result.put(nums[count], 1)
                }
            }
            for ((key, value) in result) {
                if (value > nums.size / 2) {
                    return key
                }
            }
            return 0
        }
    }
}