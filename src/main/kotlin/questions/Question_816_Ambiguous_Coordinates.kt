package questions

class Question_816_Ambiguous_Coordinates {

    companion object {

        fun runQuestion() {
//            Input: s = "(10101)"
//            Output: ["(1, 0.101)","(10, 1.01)","(10, 10.1)","(10, 101)","(1.01, 0.1)","(10.1, 0.1)","(101, 0.1)","(1010, 1)"]
            val s = "(10101)"
            val result = ambiguousCoordinates(s)
            println("Question 816: $result")
        }

        fun ambiguousCoordinates(s: String): List<String> {
            val ans: MutableSet<String> = mutableSetOf()
            val temp = s.substring(1..s.length - 2)
            for (i in 1..temp.length - 1) {
                var frontSub = temp.substring(0..i - 1)
                var backSub = temp.substring(i..temp.length - 1)
                if ((frontSub.length >= 2 && frontSub[0] == '0' && frontSub[frontSub.length - 1] == '0') ||
                    (backSub.length >= 2 && backSub[0] == '0' && backSub[backSub.length - 1] == '0')
                ) {
                    continue
                }

                if ((frontSub[0] == '0' || frontSub.length == 1) && (backSub[0] == '0' || backSub.length == 1)) {
                    if (frontSub.length >= 2) {
                        frontSub = frontSub[0] + "." + frontSub.substring(1..frontSub.length - 1)
                    }
                    if (backSub.length >= 2) {
                        backSub = backSub[0] + "." + backSub.substring(1..backSub.length - 1)
                    }
                    ans.add("(" + frontSub + ", " + backSub + ")")
                } else if (frontSub[0] == '0' || frontSub.length == 1) {
                    if (frontSub[0] == '0' && frontSub.length >= 2) {
                        frontSub = frontSub[0] + "." + frontSub.substring(1..frontSub.length - 1)
                    }
                    if (backSub[backSub.length - 1] == '0') {
                        ans.add("(" + frontSub + ", " + backSub + ")")
                    } else {
                        for (j in 1..backSub.length) {
                            var backTemp = backSub
                            if (j < backTemp.length) {
                                backTemp =
                                    backTemp.substring(0..j - 1) + "." + backTemp.substring(j..backTemp.length - 1)
                            }
                            ans.add("(" + frontSub + ", " + backTemp + ")")
                        }
                    }
                } else if (backSub[0] == '0' || backSub.length == 1) {
                    if (backSub[0] == '0' && backSub.length >= 2) {
                        backSub = backSub[0] + "." + backSub.substring(1..backSub.length - 1)
                    }
                    if (frontSub[frontSub.length - 1] == '0') {
                        ans.add("(" + frontSub + ", " + backSub + ")")
                    } else {
                        for (j in 1..frontSub.length) {
                            var frontTemp = frontSub
                            if (j < frontTemp.length) {
                                frontTemp =
                                    frontTemp.substring(0..j - 1) + "." + frontTemp.substring(j..frontTemp.length - 1)
                            }
                            ans.add("(" + frontTemp + ", " + backSub + ")")
                        }
                    }
                } else {
                    var j = 1
                    var k = 1
                    while (j <= frontSub.length && k <= backSub.length) {
                        var frontTemp = frontSub
                        var backTemp = backSub
                        if (j < frontTemp.length && frontTemp[frontTemp.length - 1] != '0') {
                            frontTemp =
                                frontTemp.substring(0..j - 1) + "." + frontTemp.substring(j..frontTemp.length - 1)
                        }
                        if (k < backTemp.length && backTemp[backTemp.length - 1] != '0') {
                            backTemp = backTemp.substring(0..k - 1) + "." + backTemp.substring(k..backTemp.length - 1)
                        }
                        if (k == backTemp.length) {
                            j++
                            k = 1
                        } else {
                            k++
                        }
                        ans.add("(" + frontTemp + ", " + backTemp + ")")
                    }
                }
            }
            return ans.toList()
        }

        fun ambiguousCoordinatesByCheckingValid(s: String): List<String> {
            val ans: MutableSet<String> = mutableSetOf()
            val temp = s.substring(1..s.length - 2)
            for (i in 1..temp.length - 1) {
                var frontSub = temp.substring(0..i - 1)
                var backSub = temp.substring(i..temp.length - 1)
                val frontPossible = getPossibleString(frontSub)
                val backPossible = getPossibleString(backSub)
                // println("i = $i, frontPossible = $frontPossible, backPossible = $backPossible")
                for (front in frontPossible) {
                    if (isValid(front)) {
                        for (back in backPossible) {
                            if (isValid(back)) {
                                ans.add("(" + front + ", " + back + ")")
                            }
                        }
                    }
                }
            }
            return ans.toList()
        }

        fun getPossibleString(str: String): MutableList<String> {
            val ret: MutableList<String> = mutableListOf()
            for (i in 1..str.length) {
                if (i < str.length) {
                    val temp = str.substring(0..i - 1) + "." + str.substring(i..str.length - 1)
                    ret.add(temp)
                } else {
                    ret.add(str)
                }
            }
            return ret
        }

        fun isValid(str: String): Boolean {
            if (str.contains(".")) {
                val dotIndex = str.indexOf(".")
                if ((str[0] == '0' && dotIndex != 1) || str[str.length - 1] == '0') {
                    return false
                } else {
                    return true
                }
            } else {
                if (str[0] != '0' || str.length == 1) {
                    return true
                } else {
                    return false
                }
            }
        }
    }
}