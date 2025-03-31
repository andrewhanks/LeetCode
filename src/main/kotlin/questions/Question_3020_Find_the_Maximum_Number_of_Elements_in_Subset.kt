package questions

import kotlin.math.max
import kotlin.math.sqrt

class Question_3020_Find_the_Maximum_Number_of_Elements_in_Subset {

    companion object {

        fun runQuestion() {
//            Input: nums = [5,4,1,2,2]
//            Output: 3
            val array = intArrayOf(5, 4, 1, 2, 2)
            val result = maximumLength(array)
            println("Question 3020: $result")
        }

        fun maximumLength(nums: IntArray): Int {
            var oneNumbers = nums.filter { it == 1 }.count()
            var ans = 0
            if (oneNumbers % 2 == 1) {
                ans = oneNumbers
            } else {
                ans = oneNumbers - 1
            }
            val map: MutableMap<Int, Int> = mutableMapOf()
            for (i in 0..nums.size - 1) {
                map[nums[i]] = map.getOrDefault(nums[i], 0) + 1
            }
            // println("map = $map")
            for (i in 2..32000) {
                var current = 0
                var temp = i
                while (temp <= 1000000000) {
                    // println("temp = $temp")
                    if (map[temp] != null && map[temp] == 1) {
                        current = current + 1
                        break
                    } else if (map[temp] != null && map[temp]!! >= 2) {
                        current = current + 2
                    } else {
                        current = current - 1
                        break
                    }
                    temp = temp * temp
                }
                if (temp > 1000000000 && map[temp] == null) {
                    current = current - 1
                }
                // println("i = $i, current = $current")
                ans = max(ans, current)
            }
            return ans
        }

        fun maximumLengthFaster(nums: IntArray): Int {
            val map: MutableMap<Double, Int> = mutableMapOf()
            for (i in 0..nums.size - 1) {
                val num = nums[i].toDouble()
                map[num] = map.getOrDefault(num, 0) + 1
            }
            var ans = 0
            for ((key, value) in map) {
                if (key == 1.0) {
                    if (value % 2 == 1) {
                        ans = max(ans, value)
                    } else {
                        ans = max(ans, value - 1)
                    }
                    continue
                }
                var current = 1
                var next = sqrt(key)
                // println("key = $key, current = $current, next = $next, map[next]!=null && map[next]!!>=2 = ${map[next]!=null && map[next]!!>=2}")
                while (map[next] != null && map[next]!! >= 2) {
                    current += 2
                    next = sqrt(next)
                }
                // println("current = $current")
                ans = max(ans, current)
            }
            return ans
        }
    }
}