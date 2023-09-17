package questions


class Question_1318_Minimum_Flips_to_Make_a_OR_b_Equal_to_c {

    companion object {

        fun runQuestion() {
            val a = 10
            val b = 9
            val c = 1
            val result = minFlips(a, b, c)
            println("Question 1318: $result")
        }

        fun minFlips(a: Int, b: Int, c: Int): Int {
            var result = 0

            var modifiedA = a
            var modifiedB = b
            var modifiedC = c
            while (modifiedA != 0 || modifiedB != 0 || modifiedC != 0) {
                println("modifiedA = $modifiedA, modifiedB = $modifiedB, modifiedC = $modifiedC")
                val bitA = modifiedA and 1
                val bitB = modifiedB and 1
                val bitC = modifiedC and 1
                println("bitA = $bitA, bitB = $bitB, bitC = $bitC")
                if (bitA or bitB != bitC) {
                    if (bitA == 1 && bitB == 1) {
                        result += 2
                    } else {
                        result += 1
                    }
                }
                modifiedA = modifiedA shr 1
                modifiedB = modifiedB shr 1
                modifiedC = modifiedC shr 1
            }
            return result
        }

        fun minFlipsWithSavedArray(a: Int, b: Int, c: Int): Int {
            var result = 0

            val binaryA = a.toString(2)
            val binaryB = b.toString(2)
            val binaryC = c.toString(2)
            println("binaryA = " + binaryA + ", binaryB = " + binaryB + ", binaryC = " + binaryC)
            val binaryALength = binaryA.length
            val binaryBLength = binaryB.length
            val binaryCLength = binaryC.length
            var maxLength = Math.max(binaryALength, binaryBLength)
            maxLength = Math.max(maxLength, binaryCLength)
            val charArrayA = binaryA.toMutableList()
            val charArrayB = binaryB.toMutableList()
            val charArrayC = binaryC.toMutableList()
            for (count in 1..maxLength - charArrayA.size) {
                charArrayA.add(0, '0')
            }
            for (count in 1..maxLength - charArrayB.size) {
                charArrayB.add(0, '0')
            }
            for (count in 1..maxLength - charArrayC.size) {
                charArrayC.add(0, '0')
            }
            for (count in 0..maxLength - 1) {
                println("charArrayA[$count] = ${charArrayA[count]}, charArrayB[$count] = ${charArrayB[count]}, charArrayC[$count] = ${charArrayC[count]}")
                println(
                    "charArrayA[count] xor charArrayB[count] == charArrayC[count] = " +
                            (charArrayA[count].toString().toInt() xor charArrayB[count].toString()
                                .toInt() == charArrayC[count].toString().toInt()) +
                            ", charArrayA[count] or charArrayB[count] != charArrayC[count] = " +
                            (charArrayA[count].toString().toInt() or charArrayB[count].toString()
                                .toInt() != charArrayC[count].toString().toInt())
                )
                println(
                    "charArrayA[count] xor charArrayB[count] = " +
                            (charArrayA[count].toString().toInt() xor charArrayB[count].toString().toInt()) +
                            ", charArrayC[count] = " + charArrayC[count].toString().toInt()
                )
                if (charArrayA[count].toString().toInt() xor charArrayB[count].toString()
                        .toInt() == charArrayC[count].toString().toInt() &&
                    charArrayC[count].toString().toInt() == 0 && charArrayA[count].toString().toInt() != 0
                ) {
                    result += 2
                } else if (charArrayA[count].toString().toInt() or charArrayB[count].toString()
                        .toInt() != charArrayC[count].toString().toInt()
                ) {
                    result += 1
                }
                println("result = $result")
            }

            return result
        }
    }
}