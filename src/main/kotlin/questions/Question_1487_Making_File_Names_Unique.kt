package questions

import kotlin.math.abs


class Question_1487_Making_File_Names_Unique {

    companion object {

        fun runQuestion() {
//            Input: names = ["gta","gta(1)","gta","avalon"]
//            Output: ["gta","gta(1)","gta(2)","avalon"]
            val names = arrayOf("gta", "gta(1)", "gta", "avalon")
            val result = getFolderNames(names)
            println("Question 1487: ${result.contentToString()}")
        }

        fun getFolderNames(names: Array<String>): Array<String> {
            val set: MutableSet<String> = mutableSetOf()
            val ans: MutableList<String> = mutableListOf()
            for (i in 0..names.size - 1) {
                val name = names[i]
                var modifiedName = name
                if (set.contains(modifiedName)) {
                    var currentValue = 1
                    while (set.contains(modifiedName + "($currentValue)")) {
                        currentValue++
                    }
                    set.add(modifiedName + "($currentValue)")
                    ans.add(modifiedName + "($currentValue)")
                } else {
                    set.add(modifiedName)
                    ans.add(modifiedName)
                }
                // println("set = $set")
            }
            return ans.toTypedArray()
        }
    }
}