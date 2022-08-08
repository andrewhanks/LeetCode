package questions


class Question_1577_Number_of_Ways_Where_Square_of_Number_Is_Equal_to_Product_of_Two_Numbers {

    companion object {

        fun runQuestion() {
            val numberArray1 = intArrayOf(7, 7, 8, 3)
            val numberArray2 = intArrayOf(1, 2, 9, 7)
            val result = numTriplets(numberArray1, numberArray2)
            println("Question 1577: $result")
        }

        fun numTriplets(nums1: IntArray, nums2: IntArray): Int {
            var result = 0
            nums1.forEachIndexed { index1, value1 ->
                for (i in 0..nums2.size - 1) {
                    for (j in i + 1..nums2.size - 1) {
                        if (value1 > 46000 || nums2[i] > 46000 || nums2[j] > 46000) {
                            val squareValue: Long = value1.toLong() * value1.toLong()
                            val multipleValue: Long = nums2[i].toLong() * nums2[j].toLong()
                            if (squareValue == multipleValue) {
                                //println("nums1 value1 = $value1, nums2[$i] = ${nums2[i]}, nums2[$j] = ${nums2[j]}")
                                result++
                            }
                        } else {
                            if (value1 * value1 == nums2[i] * nums2[j]) {
                                //println("nums1 value1 = $value1, nums2[$i] = ${nums2[i]}, nums2[$j] = ${nums2[j]}")
                                result++
                            }
                        }
                    }
                }
            }
            nums2.forEachIndexed { index1, value1 ->
                for (i in 0..nums1.size - 1) {
                    for (j in i + 1..nums1.size - 1) {
                        if (value1 > 46000 || nums1[i] > 46000 || nums1[j] > 46000) {
                            val squareValue: Long = value1.toLong() * value1.toLong()
                            val multipleValue: Long = nums1[i].toLong() * nums1[j]
                            if (squareValue == multipleValue) {
                                //println("nums2 value1 = $value1, nums1[$i] = ${nums1[i]}, nums1[$j] = ${nums1[j]}")
                                result++
                            }
                        } else {
                            if (value1 * value1 == nums1[i] * nums1[j]) {
                                //println("nums2 value1 = $value1, nums1[$i] = ${nums1[i]}, nums1[$j] = ${nums1[j]}")
                                result++
                            }
                        }
                    }
                }
            }
            return result
        }

        fun numTripletsWebSolution(nums1: IntArray, nums2: IntArray): Int {
            return getCount(nums1, nums2) + getCount(nums2, nums1)
        }

        private fun getCount(nums1: IntArray, nums2: IntArray): Int {
            var res = 0
            for (j in nums1) {
                val sqr = j.toLong() * j.toLong() // as range is 10^5
                val map: MutableMap<Long, Long> = HashMap()
                for (value in nums2) {
                    if (sqr % value.toLong() == 0L) {
                        res += map.getOrDefault(sqr / value.toLong(), 0L).toInt()
                        // if divisible store in map so that next time we can pull count
                        map.compute(
                            value.toLong()
                        ) { k: Long?, v: Long? -> if (v == null) 1L else 1L + v }
                    }
                }
            }
            return res
        }
    }
}