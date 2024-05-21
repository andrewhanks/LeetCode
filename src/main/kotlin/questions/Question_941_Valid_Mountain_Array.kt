package questions

class Question_941_Valid_Mountain_Array {

    companion object {

        fun runQuestion() {
//            Input: arr = [0,3,2,1]
//            Output: true
            val arr = intArrayOf(0, 3, 2, 1)
            val result = validMountainArray(arr)
            println("Question 941: $result")
        }

        fun validMountainArray(arr: IntArray): Boolean {
            if (arr.size == 1) {
                return false
            }
            var top = false
            var dir = 0
            for (count in 1..arr.size - 1) {
                if (arr[count] > arr[count - 1]) {
                    if (dir == 1) {
                        return false
                    } else if (count == arr.size - 1) {
                        return false
                    }
                } else if (arr[count] < arr[count - 1]) {
                    if (count == 1) {
                        return false
                    } else if (!top) {
                        top = true
                        dir = 1
                    } else if (dir == 0) {
                        return false
                    }
                } else {
                    return false
                }
            }
            return true
        }
    }
}