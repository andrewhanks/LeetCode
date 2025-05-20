package questions


class Question_2568_Minimum_Impossible_OR {

    companion object {

        fun runQuestion() {
//            Input: nums = [2,1]
//            Output: 4
            val nums = intArrayOf(2, 1)
            val result = minImpossibleOR(nums)
            println("Question 2568: $result")
        }

//        想法1:
//        1. 注意到，如果 1 不存在，答案一定是 1。接着如果 2 不存在，则答案一定是 2。1 和 2 都存在，但 4 不存在，答案就是 4；
//           依次类推，只要判断最小的不存在的 2 的幂次就是答案。
//        2. 可以使用一个整数变量记录 2 的幂次存在的情况。

//        想法2:
//        首先，我们先观察输入数据范围中小数值的二进制表示，尝试发现规律：
//
//        0 = 0000 = 0
//        1 = 0001 = 1
//        2 = 0010 = 2
//        3 = 0011 = 2 | 1
//        4 = 0100 = 4
//        5 = 0101 = 4 | 1
//        6 = 0110 = 4 | 2
//        7 = 0111 = 4 | 2 | 1，或者 5 | 1
//        8 = 1000 = 8
//        9 = 1001 = 8 | 1
//        10 = 1010 = 8 | 2
//        我们发现以下 2 点信息：
//
//        除了数字 7 = 5 | 1 的特殊方案外，其他数字的表示方案都可以由形如 $x = 2^i | 2^j | 2^ k$ 的格式表达（很容易理解）；
//        $2^i$ 格式的数字不可能被其他数用 “或” 的形式表示（也很容易理解）。
//        由此可以得出结论： 影响数组最小可表达数的关键在于数组中 “未出现的最小的 $2^i$”，并且这个数就是不可表达的最小非零数。
//
//        举例说明：假设 8 是数组中未出现的最小 $2^i$（此时 [1, 2, 4] 肯定在数组中出现$2^i$），那么数字 1 ~ 7 之间的所有数字都可以由 [1、2、4] 通过或表示，而 8 无法被 [1, 2, 3, 4, 5, 6 ,7] 之间的任何数字表达，同时也无法被大于 8 的其他数表示，因此 8 就是最小的可表达数。
//
//        完成问题转换后编码就很容易了，我们只要从小到大枚举所有 $2^i$ ，并检查它是否在数组中出现即可：
        fun minImpossibleOR(nums: IntArray): Int {
            val set: MutableSet<Int> = mutableSetOf()
            var num = 1
            for (i in 0..nums.size - 1) {
                set.add(nums[i])
            }
            for (i in 0..31) {
                if (!set.contains(num)) {
                    return num
                }
                num = num * 2
            }
            return -1
        }

        fun minImpossibleORAnotherSolution(nums: IntArray): Int {
            nums.sort()
            var max = 0
            for (i in 0..nums.size - 1) {
                if (nums[i] > max + 1) {
                    return max + 1
                } else {
                    max = max or nums[i]
                }
            }
            return max + 1
        }
    }
}