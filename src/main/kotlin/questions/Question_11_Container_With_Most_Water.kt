package questions

import kotlin.math.max
import kotlin.math.min

class Question_11_Container_With_Most_Water {

    companion object {

        fun runQuestion() {
//            Input: height = [1,8,6,2,5,4,8,3,7]
//            Output: 49
            val numberArray = intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)
            val result = maxArea(numberArray)
            println("Question 11: $result")
        }

        fun maxArea(height: IntArray): Int {
            val map: MutableMap<Int, IntArray> = mutableMapOf()
            for (count in 0..height.size - 1) {
                if (!map.contains(height[count])) {
                    map.put(height[count], intArrayOf(count, count))
                } else {
                    map[height[count]]!![0] = min(map[height[count]]!![0]!!, count)
                    map[height[count]]!![1] = max(map[height[count]]!![1]!!, count)
                }
            }
            var max = 0
            val range = IntArray(2) { -1 }
            map.keys.toList().sortedDescending().forEach {
                // println("map[$it]!! = ${map[it]!!.contentToString()}")
                if (range[0] == -1 || range[1] == -1) {
                    range[0] = map[it]!![0]
                    range[1] = map[it]!![1]
                } else {
                    range[0] = min(range[0], map[it]!![0])
                    range[1] = max(range[1], map[it]!![1])
                }
                max = max(max, (range[1] - range[0]) * it)
                // println("max = $max")
            }
            return max
        }

        // brute force
        fun maxArea1(height: IntArray): Int {
            var waterSum = 0
            for (index1 in 0..height.size - 1) {
                for (index2 in index1 + 1..height.size - 1) {
                    val minHeight = Math.min(height[index1], height[index2])
                    val currentWater = minHeight * (index2 - index1)
                    println("${index1}, ${index2}, ${currentWater}")
                    if (currentWater > waterSum) {
                        waterSum = currentWater
                    }
                }
            }
            return waterSum
        }

        fun maxArea2(height: IntArray): Int {
            val maxHeight = height.maxOrNull() ?: 0
            var maxWaterSum = 0
            if (0 == maxHeight) {
                return 0
            }
            for (waterHeight in 1..maxHeight) {
                var start = 0
                var end = 0
                loopStart@ for (startPosition in 0..height.size - 1) {
                    if (height[startPosition] >= waterHeight) {
                        start = startPosition
                        break@loopStart
                    }
                }
                loopEnd@ for (endPosition in height.size - 1 downTo start + 1) {
                    if (height[endPosition] >= waterHeight) {
                        end = endPosition
                        break@loopEnd
                    }
                }
                if (0 == end) {
                    start = 0
                    end = 0
                }
                val currentWater = waterHeight * (end - start)
                println("${height}, ${start}, ${end}, ${currentWater}")
                if (currentWater > maxWaterSum) {
                    maxWaterSum = currentWater
                }
            }
            return maxWaterSum
        }
    }
}