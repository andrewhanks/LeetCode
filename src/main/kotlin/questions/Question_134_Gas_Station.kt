package questions

import kotlin.math.max


class Question_134_Gas_Station {

    companion object {

        fun runQuestion() {
//            Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
//            Output: 3
            val numberArray1 = intArrayOf(1, 2, 3, 4, 5)
            val numberArray2 = intArrayOf(3, 4, 5, 1, 2)
            val result = canCompleteCircuit(numberArray1, numberArray2)
            println("Question 134: $result")
        }

        fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
            val rest: IntArray = IntArray(gas.size) { 0 }
            for (count in 0..gas.size - 1) {
                rest[count] = gas[count] - cost[count]
            }
            if (rest.sum() < 0) {
                return -1
            }
            var startStation = 0
            var sum = 0
            var max = 0
            for (count in 0..rest.size - 1) {
                sum += rest[count]
                max = max(max, sum)
                if (sum < 0) {
                    sum = 0
                    startStation = count + 1
                }
            }
            return startStation
        }

        fun canCompleteCircuitAnotherSolution(gas: IntArray, cost: IntArray): Int {
            val result: MutableList<Int> = mutableListOf()
            for (count in 0..gas.size - 1) {
                result.add(gas[count] - cost[count])
            }
            if (result.sum() < 0) {
                return -1
            }
            // val size = result.size
            // for(count in 0..size-1) {
            //     result.add(result[count])
            // }
            // println(result)
            var sum = 0
            var max = Int.MIN_VALUE
            var pos = -1
            for (count in 0..result.size - 1) {
                sum = sum + result[count]
                max = max(max, sum)
                if (sum < 0) {
                    sum = 0
                    pos = -1
                }
                if (sum > 0 && pos == -1) {
                    pos = count
                }
                // println(pos)
            }
            if (pos == -1) {
                pos = 0
            }
            return pos
        }
    }
}