package questions

class Question_190_Reverse_Bits {

    companion object {

        fun runQuestion() {
            val n = Integer.parseUnsignedInt("11111111111111111111111111111101", 2)
            val result = reverseBits(n)
            println("Question 190: $result")
        }

        fun reverseBits(n: Int): Int {
            val binary = Integer.toBinaryString(n)
            val reversedBinary = StringBuilder(binary.reversed())
            println("binary = $binary")
            println("reversedBinary = $reversedBinary")
            for (count in 0..32 - reversedBinary.length - 1) {
                reversedBinary.append('0')
            }
            return Integer.parseUnsignedInt(reversedBinary.toString(), 2)
        }

        fun reverseBitsWeb(n: Int): Int {
            var reverse = 0
            var input = n
            for (count in 1..32) {
                reverse = reverse shl 1
                reverse = reverse or (input and 1)
                input = input shr 1
            }
            return reverse
        }
    }
}