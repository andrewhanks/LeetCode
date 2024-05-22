package questions

class Question_925_Long_Pressed_Name {

    companion object {

        fun runQuestion() {
//            Input: name = "saeed", typed = "ssaaedd"
//            Output: false
            val name = "saeed"
            val typed = "ssaaedd"
            val result = isLongPressedName(name, typed)
            println("Question 925: $result")
        }

        fun isLongPressedName(name: String, typed: String): Boolean {
            val nameList: MutableList<Char> = mutableListOf()
            val nameNum: MutableList<Int> = mutableListOf()
            val typedList: MutableList<Char> = mutableListOf()
            val typedNum: MutableList<Int> = mutableListOf()
            for (count in 0..name.length - 1) {
                if (count == 0 || (count > 0 && name[count - 1] != name[count])) {
                    nameNum.add(1)
                    nameList.add(name[count])
                } else {
                    nameNum[nameNum.size - 1] = nameNum[nameNum.size - 1]!! + 1
                }
            }
            for (count in 0..typed.length - 1) {
                if (count == 0 || (count > 0 && typed[count - 1] != typed[count])) {
                    typedNum.add(1)
                    typedList.add(typed[count])
                } else {
                    typedNum[typedNum.size - 1] = typedNum[typedNum.size - 1]!! + 1
                }
            }
            // println("nameList.size = ${nameList.size}, typedList.size = ${typedList.size}")
            if (nameList.size != typedList.size) {
                return false
            }
            for (count in 0..nameList.size - 1) {
                if (nameList[count] != typedList[count] || nameNum[count] > typedNum[count]) {
                    return false
                }
            }
            return true
        }

        fun isLongPressedNameWithTwoPointers(name: String, typed: String): Boolean {
            var i = 0
            var j = 0
            while (i <= name.length - 1 && j <= typed.length - 1) {
                if (name[i] == typed[j]) {
                    i++
                    j++
                } else if (i >= 1 && name[i - 1] == typed[j]) {
                    j++
                } else {
                    return false
                }
            }
            while (j <= typed.length - 1) {
                if (name[i - 1] == typed[j]) {
                    j++
                } else {
                    return false
                }
            }
            if (i < name.length) {
                return false
            } else {
                return true
            }
        }
    }
}