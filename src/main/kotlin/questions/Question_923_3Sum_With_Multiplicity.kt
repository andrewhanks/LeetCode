package questions


class Question_923_3Sum_With_Multiplicity {

    companion object {

        fun runQuestion() {
//            Input: arr = [1,1,2,2,3,3,4,4,5,5], target = 8
//            Output: 20
            val arr = intArrayOf(1, 1, 2, 2, 3, 3, 4, 4, 5, 5)
            val target = 8
            val result = threeSumMulti(arr, target)
            println("Question 923: $result")
        }

        fun threeSumMulti(arr: IntArray, target: Int): Int {
            val mod = 1000000007
            arr.sort()
            var ans = 0L
            for (i in 0..arr.size - 1) {
                val rest = target - arr[i]
                var j = i + 1
                var k = arr.size - 1
                while (j < k) {
                    if (arr[j] + arr[k] < rest) {
                        j++
                    } else if (arr[j] + arr[k] > rest) {
                        k--
                    } else {
                        if (arr[j] == arr[k]) {
                            var count = k - j + 1
                            ans = ans + (count * (count - 1) / 2)
                            ans = ans % mod
                            break
                        } else {
                            var countJ = 1
                            var countK = 1
                            while (arr[j] == arr[j + 1]) {
                                countJ++
                                j++
                            }
                            j++
                            while (arr[k] == arr[k - 1]) {
                                countK++
                                k--
                            }
                            k--
                            ans = ans + countJ * countK
                            ans = ans % mod
                        }
                    }
                }
            }
            return ans.toInt()
        }
    }
}