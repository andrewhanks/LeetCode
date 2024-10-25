package questions

import java.util.*
import kotlin.math.min

class Question_2182_Construct_String_With_Repeat_Limit {

    companion object {

        fun runQuestion() {
//            Input: s = "aababab", repeatLimit = 2
//            Output: "bbabaa"
            val s = "aababab"
            val repeatLimit = 2
            val result = repeatLimitedString(s, repeatLimit)
            println("Question 2182: $result")
        }

        fun repeatLimitedString(s: String, repeatLimit: Int): String {
            val result = IntArray(26) { 0 }
            for (count in 0..s.length - 1) {
                result[s[count] - 'a']++
            }
            var i = 25
            var j = i
            var count = 0
            var ans = StringBuilder("")
            while (i >= 0 && j >= 0) {
                while (i >= 0 && result[i] == 0) {
                    i--
                }
                if (i < 0) {
                    break
                }
                // println("i = $i, j = $j, count = $count, ans = ${ans.toString()}")
                if (count < repeatLimit) {
                    ans.append((i + 'a'.toInt()).toChar())
                    result[i]--
                    if (result[i] == 0) {
                        count = 0
                    } else {
                        count++
                    }
                } else {
                    j = i - 1
                    while (j >= 0 && result[j] == 0) {
                        j--
                    }
                    if (j < 0) {
                        break
                    }
                    ans.append((j + 'a'.toInt()).toChar())
                    result[j]--
                    count = 0
                }
            }
            return ans.toString()
        }

        fun repeatLimitedStringSlower(s: String, repeatLimit: Int): String {
            val map: TreeMap<Char, Int> = TreeMap()
            for (count in 0..s.length - 1) {
                map[s[count]] = map.getOrDefault(s[count], 0) + 1
            }
            var ans = StringBuilder("")
            var count = 0
            while (map.size > 1) {
                if (count < repeatLimit) {
                    val key = map.lastKey()
                    ans.append(key)
                    decreaseKey(map, key)
                    count++
                    if (map[key] == null) {
                        count = 0
                    }
                } else {
                    val key = map.lowerKey(ans[ans.length - 1])
                    ans.append(key)
                    decreaseKey(map, key)
                    count = 0
                }
                // println("map = ${map}")
            }
            val lastKey = map.lastKey()
            val min = min(repeatLimit, map[lastKey]!!)
            for (count in 0..min - 1) {
                ans.append(lastKey)
            }
            return ans.toString()
        }

        fun decreaseKey(map: TreeMap<Char, Int>, key: Char) {
            map[key] = map[key]!! - 1
            if (map[key]!! == 0) {
                map.remove(key)
            }
        }
    }
}