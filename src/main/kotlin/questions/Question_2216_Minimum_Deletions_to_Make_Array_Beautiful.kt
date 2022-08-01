package questions

class Question_2216_Minimum_Deletions_to_Make_Array_Beautiful {

    companion object {

        fun runQuestion() {
            val numberArray = intArrayOf(1, 1, 2, 3, 5)
            val result = minDeletion(numberArray)
            println("Question 1705: $result")
        }

        fun minDeletion(nums: IntArray): Int {
            var countFirst = 0
            var countSecond = 1
            var deletions = 0
            var numsMutableList = nums.toMutableList()
            while (countFirst <= numsMutableList.size - 2) {
                while (countFirst < numsMutableList.size && countSecond < numsMutableList.size &&
                    numsMutableList[countFirst] == numsMutableList[countSecond]
                ) {
                    countSecond++
                    deletions++
                }
                countFirst = countSecond + 1
                countSecond = countFirst + 1
            }
            if ((numsMutableList.size - deletions) % 2 == 1) {
                deletions++
            }
            return deletions
        }
    }
}