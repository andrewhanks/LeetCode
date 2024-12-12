package questions

import java.util.*

class Question_1054_Distant_Barcodes {

    companion object {

        fun runQuestion() {
//            Input: barcodes = [1,1,1,1,2,2,3,3]
//            Output: [1,3,1,3,1,2,1,2]
            val inputIntArray = intArrayOf(1, 1, 1, 1, 2, 2, 3, 3)
            val resultList = rearrangeBarcodes(inputIntArray)
            var result = "["
            resultList.forEachIndexed { index, i ->
                result += i
                if (index == resultList.size - 1) {
                    result += "]"
                } else {
                    result += ","
                }
            }
            println("Question 1054: $result")
        }

        fun rearrangeBarcodes(barcodes: IntArray): IntArray {
            val result = IntArray(10001) { 0 }
            for (i in 0..barcodes.size - 1) {
                result[barcodes[i]]++
            }
            val queue = PriorityQueue<IntArray> { a, b ->
                b[1] - a[1]
            }
            for (i in 0..result.size - 1) {
                if (result[i] == 0) {
                    continue
                }
                queue.add(intArrayOf(i, result[i]))
            }
            var ans: MutableList<Int> = mutableListOf()
            while (!queue.isEmpty()) {
                val item = queue.remove()
                var item2: IntArray? = null
                ans.add(item[0])
                if (!queue.isEmpty()) {
                    item2 = queue.remove()
                    ans.add(item2[0])
                }
                if (item[1] - 1 > 0) {
                    queue.add(intArrayOf(item[0], item[1] - 1))
                }
                if (item2 != null && item2[1] - 1 > 0) {
                    queue.add(intArrayOf(item2[0], item2[1] - 1))
                }
            }
            return ans.toIntArray()
        }

        fun rearrangeBarcodesOldSolution(barcodes: IntArray): IntArray {
            val numberToTimesMap: MutableMap<Int, Int> = mutableMapOf()
            barcodes.forEach { number ->
                if (!numberToTimesMap.containsKey(number)) {
                    numberToTimesMap[number] = 1
                } else {
                    numberToTimesMap[number] = numberToTimesMap[number]!! + 1
                }
            }
            for ((key, value) in numberToTimesMap) {
                println("key = $key, value = $value")
            }
            var intArrayResult = intArrayOf()
            var pickupItems = pickupFirstTwoItems(numberToTimesMap)

            while (0 != pickupItems[1] || 0 != pickupItems[3]) {
                if (0 != pickupItems[1]) {
                    intArrayResult = intArrayResult.plus(pickupItems[0])
                    if (numberToTimesMap.containsKey(pickupItems[0])) {
                        numberToTimesMap[pickupItems[0]] = numberToTimesMap[pickupItems[0]]!! - 1
                    }
                }
                if (0 != pickupItems[3]) {
                    intArrayResult = intArrayResult.plus(pickupItems[2])
                    if (numberToTimesMap.containsKey(pickupItems[2])) {
                        numberToTimesMap[pickupItems[2]] = numberToTimesMap[pickupItems[2]]!! - 1
                    }
                }

                pickupItems = pickupFirstTwoItems(numberToTimesMap)
            }
            val maxLogSize = 1000
            for (i in 0..intArrayResult.contentToString().length / maxLogSize) {
                val start = i * maxLogSize
                var end = (i + 1) * maxLogSize
                end =
                    if (end > intArrayResult.contentToString().length) intArrayResult.contentToString().length else end
                println("intArrayResult = " + intArrayResult.contentToString().substring(start, end))
            }
            return intArrayResult
        }

        private fun pickupFirstTwoItems(numberToTimesMap: MutableMap<Int, Int>): Array<Int> {
            if (1 == numberToTimesMap.size) {
                val iterator = numberToTimesMap.entries.iterator()
                val firstElement = iterator.next()
                val timesMostKey = firstElement.key
                val timesMostValue = firstElement.value
                return arrayOf(timesMostKey, timesMostValue, 0, 0)
            }
            var timesMostKey = 0
            var timesMostValue = 0
            var timesSecondMostKey = 0
            var timesSecondMostValue = 0
            for ((key, value) in numberToTimesMap) {
                if (value > timesMostValue) {
                    val tempKey = timesMostKey
                    val tempValue = timesMostValue
                    timesMostKey = key
                    timesMostValue = value
                    if (tempValue > timesSecondMostValue) {
                        timesSecondMostKey = tempKey
                        timesSecondMostValue = tempValue
                    }
                } else if (value > timesSecondMostValue) {
                    timesSecondMostKey = key
                    timesSecondMostValue = value
                }
            }
            println("timesMostKey = $timesMostKey, timesMostValue = $timesMostValue")
            println("timesSecondMostKey = $timesSecondMostKey, timesSecondMostValue = $timesSecondMostValue")
            return arrayOf(timesMostKey, timesMostValue, timesSecondMostKey, timesSecondMostValue)
        }
    }
}