package questions

import kotlin.math.min


class Question_3076_Shortest_Uncommon_Substring_in_an_Array {

    companion object {

        fun runQuestion() {
//            Input: arr = ["cab","ad","bad","c"]
//            Output: ["ab","","ba",""]
            val words = arrayOf("cab", "ad", "bad", "c")
            val result = shortestSubstrings(words)
            println("Question 3076: ${result.contentToString()}")
        }

        fun shortestSubstrings(arr: Array<String>): Array<String> {
            val result = Array(arr.size) { "" }
            for (i in 0..arr.size - 1) {
                val temp: MutableList<String> = mutableListOf()
                // println("=================================")
                for (j in 0..arr[i].length - 1) {
                    for (k in j..arr[i].length - 1) {
                        val subString = arr[i].substring(j..k)
                        var isSubString = false
                        for (l in 0..arr.size - 1) {
                            if (i != l && arr[l].contains(subString)) {
                                isSubString = true
                            }
                        }
                        if (!isSubString) {
                            // println("subString = $subString")
                            temp.add(subString)
                        }
                    }
                }
                if (temp.size >= 1) {
                    temp.sortWith(Comparator { a, b ->
                        if (a.length != b.length) {
                            a.length - b.length
                        } else {
                            val min = min(a.length, b.length)
                            var ret = 0
                            for (count in 0..min - 1) {
                                ret = a[count] - b[count]
                                if (ret != 0) {
                                    break
                                }
                            }
                            ret
                        }
                    })
                    // println("temp = $temp")
                    result[i] = temp[0]
                }
            }
            return result
        }
    }
}