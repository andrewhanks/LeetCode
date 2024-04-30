package questions

class Question_739_Daily_Temperatures {

    companion object {

        fun runQuestion() {
//            Input: temperatures = [73,74,75,71,69,72,76,73]
//            Output: [1,1,4,2,1,1,0,0]
            val temperatures = intArrayOf(73, 74, 75, 71, 69, 72, 76, 73)
            val result = dailyTemperatures(temperatures)
            println("Question 739: ${result.contentToString()}")
        }

        fun dailyTemperatures(temperatures: IntArray): IntArray {
            val result = IntArray(temperatures.size) { 0 }
            for (count in 0..temperatures.size - 1) {
                for (day in count + 1..result.size - 1) {
                    if (temperatures[day] > temperatures[count]) {
                        result[count] = day - count
                        break
                    }
                }
            }
            return result
        }
    }
}