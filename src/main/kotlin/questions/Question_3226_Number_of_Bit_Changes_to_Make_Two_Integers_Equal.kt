package questions

class Question_3226_Number_of_Bit_Changes_to_Make_Two_Integers_Equal {

    companion object {

        fun runQuestion() {
//            Input: n = 13, k = 4
//            Output: 2
            val n = 13
            val k = 4
            val result = minChanges(n, k)
            println("Question 3226: $result")
        }

        fun minChanges(n: Int, k: Int): Int {
            var binaryN = Integer.toBinaryString(n)
            var binaryK = Integer.toBinaryString(k)
            if (binaryN.length > binaryK.length) {
                for (count in 0..binaryN.length - binaryK.length - 1) {
                    binaryK = "0" + binaryK
                }
            } else {
                for (count in 0..binaryK.length - binaryN.length - 1) {
                    binaryN = "0" + binaryN
                }
            }
            println("binaryN = $binaryN, binaryK = $binaryK")
            var ans = 0
            for (count in 0..binaryK.length - 1) {
                if (binaryN[count] == '1' && binaryK[count] == '0') {
                    ans++
                } else if (binaryN[count] == '0' && binaryK[count] == '1') {
                    return -1
                }
            }
            return ans
        }
    }
}