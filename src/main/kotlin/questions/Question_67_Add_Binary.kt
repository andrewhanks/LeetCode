package questions

import kotlin.math.max

class Question_67_Add_Binary {

    companion object {

        fun runQuestion() {
//            Input: a = "1010", b = "1011"
//            Output: "10101"
            val a = "1010"
            val b = "1011"
            val result = addBinary(a, b)
            println("Question 67: $result")
        }

        fun addBinary(a: String, b: String): String {
            val sizeA = a.length
            val sizeB = b.length
            val maxPos = max(sizeA, sizeB)
            val stringBuilderA = StringBuilder(a)
            val stringBuilderB = StringBuilder(b)
            if (sizeA > sizeB) {
                for (count in 0..sizeA - sizeB - 1) {
                    stringBuilderB.insert(0, '0')
                }
            } else if (sizeA < sizeB) {
                for (count in 0..sizeB - sizeA - 1) {
                    stringBuilderA.insert(0, '0')
                }
            }
            val result: StringBuilder = StringBuilder()
            result.setLength(maxPos)
            var carry = 0
            for (count in maxPos - 1 downTo 0) {
                when {
                    stringBuilderA[count] == '1' && stringBuilderB[count] == '1' && carry == 1 -> {
                        result[count] = '1'
                        carry = 1
                    }

                    stringBuilderA[count] == '1' && stringBuilderB[count] == '0' && carry == 1 -> {
                        result[count] = '0'
                        carry = 1
                    }

                    stringBuilderA[count] == '0' && stringBuilderB[count] == '1' && carry == 1 -> {
                        result[count] = '0'
                        carry = 1
                    }

                    stringBuilderA[count] == '0' && stringBuilderB[count] == '0' && carry == 1 -> {
                        result[count] = '1'
                        carry = 0
                    }

                    stringBuilderA[count] == '1' && stringBuilderB[count] == '1' && carry == 0 -> {
                        result[count] = '0'
                        carry = 1
                    }

                    stringBuilderA[count] == '1' && stringBuilderB[count] == '0' && carry == 0 -> {
                        result[count] = '1'
                        carry = 0
                    }

                    stringBuilderA[count] == '0' && stringBuilderB[count] == '1' && carry == 0 -> {
                        result[count] = '1'
                        carry = 0
                    }

                    stringBuilderA[count] == '0' && stringBuilderB[count] == '0' && carry == 0 -> {
                        result[count] = '0'
                        carry = 0
                    }
                }
            }
            if ((stringBuilderA[0] == '1' && stringBuilderB[0] == '1') || (stringBuilderA[0] == '1' && carry == 1) || (stringBuilderB[0] == '1' && carry == 1)) {
                result.insert(0, '1')
            }
            return result.toString()
        }

        fun addBinaryWeb(a: String, b: String): String {
            val res = java.lang.StringBuilder()
            var i = a.length - 1
            var j = b.length - 1
            var carry = 0
            while (i >= 0 || j >= 0) {
                var sum = carry
                if (i >= 0) sum += a[i--].toInt() - '0'.toInt()
                if (j >= 0) sum += b[j--].toInt() - '0'.toInt()
                carry = if (sum > 1) 1 else 0
                res.append(sum % 2)
            }
            if (carry != 0) res.append(carry)
            return res.reverse().toString()
        }
    }
}