package questions

class Question_421_Maximum_XOR_of_Two_Numbers_in_an_Array {

    companion object {

        fun runQuestion() {
//            Input: nums = [14,70,53,83,49,91,36,80,92,51,66,70]
//            Output: 127
            val nums = intArrayOf(14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70)
            val result = findMaximumXOR(nums)
            println("Question 421: $result")
        }

//        我们还需要用上一个异或的特性，假设 a 和 b 产生了最终的答案 max，即 a ^ b = x，那么根据异或的特性，a ^ x = b。
//        同理，a 和 b 的最高位（前 n 位）也有相同的性质。
//        先以最高位为例子，我们可以把所有的数字的最高位放到一个 HashSet 里面，然后使用 1 与 set 里面的所有数字进行异或，
//        如果得出的结果仍然在 set 里面，那么最终结果的最高位必然为 1，否则为 0。也即，先假定结果为 1，然后与 set 中所有数字异或，
//        假定 a 与 1 异或得到结果 b（a ^ 1 = b），而 b 仍然在 set 里面，那么说明 set 中有两个数字异或能得到 1（a ^ b = 1）。否则，
//        set 中没有两个数字能够异或得到 1，那么最终结果的最高位为 1 的假设失败，说明最终结果的最高位为 0。以此类推可以得到第二位、第三位。。。的数字。
//        再做一下推广，我们将所有数字的前 N 位放到一个 HashSet 里面，然后使用之前 N-1 位得到的最大值前缀 prefix 与 set 里面的所有数字进行异或，
//        如果得出的结果仍然在 set 中，那么第N位必然为 1，否则为 0。
        fun findMaximumXOR(nums: IntArray): Int {
            var result = 0
            for (count in 31 downTo 0) {
                val tempSet: MutableSet<Int> = mutableSetOf()
                for (num in nums) {
                    tempSet.add(num shr count)
                }
                result = (result shl 1) + 1
                var exist = false
                for (num in nums) {
                    val temp = (num shr count) xor result
                    if (tempSet.contains(temp)) {
                        exist = true
                        break
                    }
                }
                if (!exist) {
                    result = result - 1
                }
            }
            return result
        }
    }
}