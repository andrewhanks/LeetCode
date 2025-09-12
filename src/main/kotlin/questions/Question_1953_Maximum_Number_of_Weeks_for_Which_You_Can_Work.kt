package questions

class Question_1953_Maximum_Number_of_Weeks_for_Which_You_Can_Work {

    companion object {

        fun runQuestion() {
//            Input: milestones = [5,2,1]
//            Output: 7
            val milestones = intArrayOf(5, 2, 1)
            val result = numberOfWeeks(milestones)
            println("Question 1953: $result")
        }

        fun numberOfWeeks(milestones: IntArray): Long {
            var sum = 0L
            for (i in 0..milestones.size - 1) {
                sum += milestones[i]
            }
            var half = sum / 2
            for (i in 0..milestones.size - 1) {
                if (milestones[i] > half) {
                    return (sum - milestones[i]) * 2 + 1
                }
            }
            return sum
        }
    }
}