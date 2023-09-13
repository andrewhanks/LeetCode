package questions

class Question_2593_Find_Score_of_an_Array_After_Marking_All_Elements {

    companion object {

        fun runQuestion() {
            // [10,44,10,8,48,30,17,38,41,27,16,33,45,45,34,30,22,3,42,42]
            val intArray = intArrayOf(10, 44, 10, 8, 48, 30, 17, 38, 41, 27, 16, 33, 45, 45, 34, 30, 22, 3, 42, 42)
            val result = findScore(intArray)
            println("Question 2593: $result")
        }

        fun findScore(nums: IntArray): Long {
            var finalScore = 0L
            val tempMarkArray = BooleanArray(nums.size)

            val tempNumArray: MutableMap<Int, MutableList<Int>> = mutableMapOf()
            nums.forEachIndexed { index, i ->
                if (!tempNumArray.containsKey(i)) {
                    val positionList = mutableListOf(index)
                    tempNumArray[i] = positionList
                } else {
                    tempNumArray[i]?.add(index)
                }
            }
            for ((key, values) in tempNumArray.toSortedMap()) {
                println("key, values = $key, $values")
                for (value in values) {
                    if (tempMarkArray[value]) {
                        continue
                    }
                    finalScore += key
                    if (value - 1 >= 0 && !tempMarkArray[value - 1]) {
                        tempMarkArray[value - 1] = true
                    }
                    tempMarkArray[value] = true
                    if (value + 1 <= nums.size - 1 && !tempMarkArray[value + 1]) {
                        tempMarkArray[value + 1] = true
                    }
                }
            }

            return finalScore
        }

        fun findScoreSlow(nums: IntArray): Long {
            var finalScore = 0L
            val tempMarkArray = BooleanArray(nums.size)
            var num = nums.size
            while (num > 0) {
                var minNumber = -1
                var minNumberPosition = -1
                for (count in nums.size - 1 downTo 0) {
                    if (tempMarkArray[count]) {
                        continue
                    }
                    if (minNumber == -1 || minNumber >= nums[count]) {
                        minNumber = nums[count]
                        minNumberPosition = count
                    }
                }
                println("===============================")
                println("minNumber = $minNumber, minNumberPosition = $minNumberPosition")
                if (minNumberPosition == -1) {
                    continue
                }
                if (minNumberPosition - 1 >= 0 && !tempMarkArray[minNumberPosition - 1]) {
                    tempMarkArray[minNumberPosition - 1] = true
                    num--
                }
                tempMarkArray[minNumberPosition] = true
                num--
                if (minNumberPosition + 1 <= nums.size - 1 && !tempMarkArray[minNumberPosition + 1]) {
                    tempMarkArray[minNumberPosition + 1] = true
                    num--
                }
                finalScore += minNumber
            }
            return finalScore
        }
    }
}