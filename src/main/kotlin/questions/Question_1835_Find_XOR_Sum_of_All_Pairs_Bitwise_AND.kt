package questions


class Question_1835_Find_XOR_Sum_of_All_Pairs_Bitwise_AND {

    companion object {

        fun runQuestion() {
//            Input: arr1 = [1,2,3], arr2 = [6,5]
//            Output: 0
            val arr1 = intArrayOf(1, 2, 3)
            val arr2 = intArrayOf(6, 5)
            val result = getXORSum(arr1, arr2)
            println("Question 1835: $result")
        }

        // (a1&b1) ^ (a1&b2) ^ ... ^ (an&bn)
        // = a1 & (b1^b2^b3^...^bn) ^ a2 & (b1^b2^b3^...^bn) ^ an & (b1^b2^b3^...^bn)
        // = (b1^b2^b3^...^bn) & a1 ^ (b1^b2^b3^...^bn) & a2 ^ (b1^b2^b3^...^bn) & an
        // = (b1^b2^b3^...^bn) & (a1^a2^a3^...^an)
        fun getXORSum(arr1: IntArray, arr2: IntArray): Int {
            var arr1Xor = 0
            var arr2Xor = 0
            for (item in arr1) {
                arr1Xor = arr1Xor xor item
            }
            for (item in arr2) {
                arr2Xor = arr2Xor xor item
            }
            return arr1Xor and arr2Xor
        }

        // for every i-th bit:
        //    a&b1 ^ a&b2 ^ a&b3 ^ ... ^ a&bn
        //    if a==0, ans = 0
        //    if a==1, ans = b1 ^ b2 ^ b3 ^ ... ^ bn = 1 (if there are odd 1) 0 (if there are even 1)
        fun getXORSumByBitOperation(arr1: IntArray, arr2: IntArray): Int {
            var arr2Xor = IntArray(32) { 0 }
            for (item in arr2) {
                for (i in 0..31) {
                    val current = (item shr i) and 1
                    if (current == 1) {
                        arr2Xor[i]++
                    }
                }
            }
            // println("arr2Xor = ${arr2Xor.contentToString()}")
            var ret = 0
            for (item in arr1) {
                var answer = 0
                for (i in 0..31) {
                    val current = (item shr i) and 1
                    if (current == 1 && arr2Xor[i] % 2 == 1) {
                        answer = answer + (1 shl i)
                    }
                }
                ret = ret xor answer
            }
            return ret
        }
    }
}