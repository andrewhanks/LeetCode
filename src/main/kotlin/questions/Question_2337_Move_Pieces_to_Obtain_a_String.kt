package questions

class Question_2337_Move_Pieces_to_Obtain_a_String {

    companion object {

        fun runQuestion() {
            val startString = "_L__R__R_"
            val targetString = "L______RR"
            val result = canChange(startString, targetString)
            println("Question 2337: $result")
        }

        fun canChange(start: String, target: String): Boolean {
            if (start.filter { it != '_' } != target.filter { it != '_' }) {
                return false
            }
            val startL: MutableList<Int> = mutableListOf()
            val startR: MutableList<Int> = mutableListOf()
            val targetL: MutableList<Int> = mutableListOf()
            val targetR: MutableList<Int> = mutableListOf()
            for (count in 0..start.length - 1) {
                if (start[count] == 'L') {
                    startL.add(count)
                } else if (start[count] == 'R') {
                    startR.add(count)
                }
            }
            for (count in 0..target.length - 1) {
                if (target[count] == 'L') {
                    targetL.add(count)
                } else if (target[count] == 'R') {
                    targetR.add(count)
                }
            }
            for (count in 0..startL.size - 1) {
                if (startL[count] < targetL[count]) {
                    return false
                }
            }
            for (count in 0..startR.size - 1) {
                if (startR[count] > targetR[count]) {
                    return false
                }
            }
            if (startL.size != targetL.size || startR.size != targetR.size) {
                return false
            }
            return true
        }

        fun canChangeOldSolution(start: String, target: String): Boolean {
            if (start.replace("_", "") != target.replace("_", "")) {
                return false
            }
            val rStartList = mutableListOf<Int>()
            val lStartList = mutableListOf<Int>()
            val rTargetList = mutableListOf<Int>()
            val lTargetList = mutableListOf<Int>()
            for (count in 0..start.length - 1) {
                if (start[count] == 'R') {
                    rStartList.add(count)
                } else if (start[count] == 'L') {
                    lStartList.add(count)
                }
                if (target[count] == 'R') {
                    rTargetList.add(count)
                } else if (target[count] == 'L') {
                    lTargetList.add(count)
                }
            }
            if (rStartList.size != rTargetList.size || lStartList.size != lTargetList.size) {
                return false
            }
            for (count in 0..rStartList.size - 1) {
                if (rStartList[count] > rTargetList[count]) {
                    return false
                }
            }
            for (count in 0..lStartList.size - 1) {
                if (lStartList[count] < lTargetList[count]) {
                    return false
                }
            }
            return true
        }

        fun canChangeWebSolution(s: String, t: String): Boolean {
            if (s.replace("_", "") != t.replace("_", "")) {
                return false
            }
            var i = 0
            var r = 0
            var l = 0
            while (i < s.length) {
                if (s[i] == 'R') {
                    r++
                }
                if (t[i] == 'L') {
                    l++
                }
                if (t[i] == 'R' && --r < 0) {
                    return false
                }
                if (s[i] == 'L' && --l < 0) {
                    return false
                }
                i++
            }
            return true
        }
    }
}