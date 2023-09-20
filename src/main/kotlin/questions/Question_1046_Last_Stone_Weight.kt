package questions

import java.util.*

class Question_1046_Last_Stone_Weight {

    companion object {

        fun runQuestion() {
            // [2,7,4,1,8,1]
            val array = intArrayOf(2, 7, 4, 1, 8, 1)
            val result = lastStoneWeight(array)
            println("Question 1046: $result")
        }

        fun lastStoneWeight(stones: IntArray): Int {
            val resultQueue: PriorityQueue<Int> = PriorityQueue { a, b -> b - a }
            for (item in stones) {
                resultQueue.add(item)
            }
            while (resultQueue.size > 1) {
                println(resultQueue)
                val a = resultQueue.poll()
                val b = resultQueue.poll()
                if (a - b > 0) {
                    resultQueue.add(a - b)
                }
            }
            if (resultQueue.size == 0) {
                return 0
            } else {
                return resultQueue.poll()
            }
        }

        fun lastStoneWeightSlow(stones: IntArray): Int {
            val tempArray = stones.sorted().toMutableList()
            while (tempArray.size > 1) {
                val firstMax = tempArray.removeLast()
                val secondMax = tempArray.removeLast()
                val diff = firstMax - secondMax
                println("firstMax = " + firstMax + ", secondMax = " + secondMax)
                if (diff == 0) {
                    continue
                }
                if (tempArray.size == 0) {
                    tempArray.add(0, diff)
                    continue
                }
                for (count in tempArray.size - 1 downTo 0) {
                    if (diff >= tempArray[count]) {
                        tempArray.add(count + 1, diff)
                        break
                    }
                    if (count == 0) {
                        tempArray.add(0, diff)
                        break
                    }
                }
                println(tempArray)
            }
            if (tempArray.size == 0) {
                return 0
            } else {
                return tempArray[0]
            }
        }
    }
}