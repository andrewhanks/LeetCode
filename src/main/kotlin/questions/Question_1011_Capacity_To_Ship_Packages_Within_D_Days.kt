package questions


class Question_1011_Capacity_To_Ship_Packages_Within_D_Days {

    companion object {

        fun runQuestion() {
//            Input: weights = [1,2,3,4,5,6,7,8,9,10], days = 5
//            Output: 15
            val weights = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
            val days = 5
            val result = shipWithinDays(weights, days)
            println("Question 1011: $result")
        }

        fun shipWithinDays(weights: IntArray, days: Int): Int {
            var end = weights.sum()
            var start = weights.sum() / days
            while (start < end) {
                val mid = start + (end - start) / 2
                if (check(weights, mid, days)) {
                    end = mid
                } else {
                    start = mid + 1
                }
            }
            return start
        }

        fun check(weights: IntArray, capacity: Int, days: Int): Boolean {
            var temp = 0
            var itemIndex = 0
            for (count in 0..days - 1) {
                while (itemIndex <= weights.size - 1 && temp + weights[itemIndex] <= capacity) {
                    temp += weights[itemIndex]
                    itemIndex++
                }
                if (itemIndex > weights.size - 1) {
                    return true
                } else {
                    temp = 0
                }
            }
            return false
        }
    }
}