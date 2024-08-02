package questions


class Question_1248_Count_Number_of_Nice_Subarrays {

    companion object {

        fun runQuestion() {
//            Input: nums = [1,1,2,1,1], k = 3
//            Output: 2
            val numberArray = intArrayOf(1, 1, 2, 1, 1)
            val number = 3
            val result = numberOfSubarrays(numberArray, number)
            println("Question 1248: $result")
        }

        fun numberOfSubarrays(nums: IntArray, k: Int): Int {
            var oddNum = if (nums[0] % 2 == 1) {
                1
            } else {
                0
            }
            var ans = 0
            var end = 0
            for (start in 0..nums.size - 1) {
                if (start > 0 && nums[start - 1] % 2 == 1) {
                    oddNum--
                }
                while (end <= nums.size - 1 && oddNum < k) {
                    end++
                    if (end <= nums.size - 1 && nums[end] % 2 == 1) {
                        oddNum++
                    }
                }
                if (oddNum == k) {
                    ans++
                    // println("start = $start, end = $end")
                    var tempEnd = end
                    while (tempEnd + 1 <= nums.size - 1 && nums[tempEnd + 1] % 2 == 0) {
                        ans++
                        tempEnd++
                        // println("start = $start, tempEnd = $tempEnd")
                    }
                }
            }
            return ans
        }

        fun numberOfSubarraysOldSolution(nums: IntArray, k: Int): Int {
            var result = 0
            val oddPosition: MutableList<Int> = mutableListOf()
            nums.forEachIndexed { index, value ->
                if (value % 2 == 1) {
                    oddPosition.add(index)
                }
            }
            if (oddPosition.size < k) {
                return 0
            }
            for (count in 0..oddPosition.size - k) {
                println("count = $count, k = $k, oddPosition.size = ${oddPosition.size}")
                if (count == 0) {
                    if (count + k - 1 < oddPosition.size - 1) {
                        result += (oddPosition[count] + 1) * (oddPosition[count + k] - oddPosition[count + k - 1])
                        println("-0 +N result = $result")
                    } else {
                        // this array includes exactly k odd numbers
                        result += (oddPosition[count] + 1) * (nums.size - 1 - oddPosition[count + k - 1] + 1)
                        println("-0 +0 result = $result")
                    }
                } else if (count + k - 1 == oddPosition.size - 1) {
                    result += (oddPosition[count] - oddPosition[count - 1]) * (nums.size - oddPosition[count + k - 1])
                    println("-N +0 result = $result")
                } else {
                    result += (oddPosition[count] - oddPosition[count - 1]) * (oddPosition[count + k] - oddPosition[count + k - 1])
                    println("-N +N result = $result")
                }
            }
            return result
        }

        fun numberOfSubarraysPointSolution(nums: IntArray, k: Int): Int {
            var i = 0
            var j = 0
            var odd = 0
            var result = 0
            var temp = 0

            /*
            Approach : two pointer + sliding window technique

            step 1 : we have fix i and moving j until our count of odd numbers == k
            step 2 : when(odd == count) we are counting every possible subarray by reducing the size of subarray from i

            why temp?
            from reducing the size of subarray we will count all the possible subarray from between i and j
            but when i encounter a odd element the odd count will reduce and that while will stop executing

            now there are two possible cases
            1.The leftover elements have a odd number
            2.The leftover elements do not have any odd number

            1. if our leftover elements have a odd number
                    then we cannot include our old possible subarrays into new possible subarrays because now new window for having odd == k is formed
                    that's why temp = 0;

            2. if out leftover elements do not have any odd element left
                then our leftover elements must also take in consideration becuase they will also contribute in forming subarrays
            */

            while (j < nums.size) {
                if (nums[j] % 2 != 0) {
                    odd++
                    //if leftover elements have odd element then new window is formed so we set temp = 0;
                    temp = 0
                }
                while (odd == k) {
                    temp++
                    if (nums[i] % 2 != 0) odd--
                    i++
                }
                //if no leftover elements is odd, each element will part in forming subarray
                //so include them
                result += temp
                j++
            }
            return result
        }
    }
}