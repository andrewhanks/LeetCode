package questions

class Question_1300_Sum_of_Mutated_Array_Closest_to_Target {

    companion object {

        fun runQuestion() {
//            Input: arr = [4,9,3], target = 10
//            Output: 3
            val arr = intArrayOf(4, 9, 3)
            val target = 10
            val result = findBestValue(arr, target)
            println("Question 1300: $result")
        }

        fun findBestValue(arr: IntArray, target: Int): Int {
            arr.sort()
            var ans = if (target - target / arr.size * arr.size <= (target / arr.size + 1) * arr.size - target) {
                target / arr.size
            } else {
                target / arr.size + 1
            }
            // println("ans = ${ans}")
            var currentSum = 0
            for (count in 0..arr.size - 1) {
                currentSum += arr[count]
                var rest = target - currentSum
                val number = arr.size - count - 1
                var restAverage = if (number != 0) {
                    rest / number
                } else {
                    0
                }
                // println("restAverage = ${restAverage}, arr[count] = ${arr[count]}")
                if (restAverage < arr[count]) {
                    continue
                } else {
                    if (target - (currentSum + restAverage * number) <= currentSum + (restAverage + 1) * number - target) {
                        ans = restAverage
                    } else {
                        ans = restAverage + 1
                    }
                    // println("ans = $ans, currentSum+restAverage*number = ${currentSum+restAverage*number}, currentSum+(restAverage+1)*number = ${currentSum+(restAverage+1)*number}")
                }
            }
            if (arr.sum() < target) {
                ans = arr[arr.size - 1]
            }
            return ans
        }
    }
}