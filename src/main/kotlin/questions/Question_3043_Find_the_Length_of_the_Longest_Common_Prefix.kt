package questions


class Question_3043_Find_the_Length_of_the_Longest_Common_Prefix {

    companion object {

        fun runQuestion() {
//            Input: arr1 = [1,10,100], arr2 = [1000]
//            Output: 3
            val arr1 = intArrayOf(1, 10, 100)
            val arr2 = intArrayOf(1000)
            val result = longestCommonPrefix(arr1, arr2)
            println("Question 3043: $result")
        }

        fun longestCommonPrefix(arr1: IntArray, arr2: IntArray): Int {
            val set: MutableSet<Int> = mutableSetOf()
            var count = 100000000
            while (count > 0) {
                var contains = false
                for (i in 0..arr1.size - 1) {
                    if (arr1[i] < count) {
                        continue
                    }
                    var cutNumber = arr1[i]
                    while (cutNumber / 10 >= count) {
                        cutNumber = cutNumber / 10
                    }
                    set.add(cutNumber)
                }
                for (i in 0..arr2.size - 1) {
                    if (arr2[i] < count) {
                        continue
                    }
                    var cutNumber = arr2[i]
                    while (cutNumber / 10 >= count) {
                        cutNumber = cutNumber / 10
                    }
                    if (set.contains(cutNumber)) {
                        contains = true
                        break
                    }
                }
                if (contains) {
                    break
                }
                count = count / 10
            }
            var ans = 0
            while (count > 0) {
                ans++
                count = count / 10
            }
            return ans
        }
    }
}