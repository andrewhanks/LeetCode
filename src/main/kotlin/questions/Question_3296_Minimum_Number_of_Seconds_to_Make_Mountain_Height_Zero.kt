package questions

class Question_3296_Minimum_Number_of_Seconds_to_Make_Mountain_Height_Zero {

    companion object {

        fun runQuestion() {
//            Input: mountainHeight = 10, workerTimes = [3,2,2,4]
//            Output: 12
            val workerTimes = intArrayOf(3, 2, 2, 4)
            val mountainHeight = 10
            val result = minNumberOfSeconds(mountainHeight, workerTimes)
            println("Question 3296: $result")
        }

        fun minNumberOfSeconds(mountainHeight: Int, workerTimes: IntArray): Long {
            var left = 0L
            var right = Long.MAX_VALUE
            while (left < right) {
                var mid = left + (right - left) / 2
                if (check(mountainHeight, workerTimes, mid)) {
                    right = mid
                } else {
                    left = mid + 1
                }
            }
            return left
        }

        fun check(mountainHeight: Int, workerTimes: IntArray, mid: Long): Boolean {
            var ret = 0
            for (time in workerTimes) {
                var totalTime = 0L
                var count = 1L
                while (totalTime + count * time <= mid) {
                    totalTime = totalTime + count * time
                    count++
                    ret++
                    if (ret >= mountainHeight) {
                        return true
                    }
                }
            }
            return false
        }
    }
}