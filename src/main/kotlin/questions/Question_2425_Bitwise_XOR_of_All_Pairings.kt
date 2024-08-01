package questions

import kotlin.math.max


class Question_2425_Bitwise_XOR_of_All_Pairings {

    companion object {

        fun runQuestion() {
//            Input: nums1 = [2,1,3], nums2 = [10,2,5,0]
//            Output: 13
            val nums1 = intArrayOf(2, 1, 3)
            val nums2 = intArrayOf(10, 2, 5, 0)
            val result = xorAllNums(nums1, nums2)
            println("Question 2425: $result")
        }

        fun xorAllNums(nums1: IntArray, nums2: IntArray): Int {
            val binary1 = Array<String>(nums1.size) { "" }
            val binary2 = Array<String>(nums2.size) { "" }
            var maxLength = 0
            for (count in 0..nums1.size - 1) {
                val temp = Integer.toBinaryString(nums1[count])
                binary1[count] = temp
                maxLength = max(maxLength, temp.length)
            }
            for (count in 0..nums2.size - 1) {
                val temp = Integer.toBinaryString(nums2[count])
                binary2[count] = temp
                maxLength = max(maxLength, temp.length)
            }
            val result = StringBuilder()
            for (count in 1..maxLength) {
                var oneInNums1 = 0
                var zeroInNums1 = 0
                for (n1 in 0..binary1.size - 1) {
                    val curBinLen = binary1[n1].length
                    if (curBinLen - count >= 0 && binary1[n1][curBinLen - count] == '1') {
                        oneInNums1++
                    } else {
                        zeroInNums1++
                    }
                }
                var oneInNums2 = 0
                var zeroInNums2 = 0
                for (n2 in 0..binary2.size - 1) {
                    val curBinLen = binary2[n2].length
                    if (curBinLen - count >= 0 && binary2[n2][curBinLen - count] == '1') {
                        oneInNums2++
                    } else {
                        zeroInNums2++
                    }
                }
                val oneInNums3 = (oneInNums1 * zeroInNums2) + (zeroInNums1 * oneInNums2)
                result.insert(0, oneInNums3 % 2)
            }
            return Integer.parseInt(result.toString(), 2)
        }

        // https://home.gamer.com.tw/artwork.php?sn=5777643
        fun xorAllNumsWebSolution(nums1: IntArray, nums2: IntArray): Int {
            var ans = 0
            if (nums1.size % 2 == 1) {
                for (count in 0..nums2.size - 1) {
                    ans = ans xor nums2[count]
                }
            }
            if (nums2.size % 2 == 1) {
                for (count in 0..nums1.size - 1) {
                    ans = ans xor nums1[count]
                }
            }
            return ans
        }
    }
}