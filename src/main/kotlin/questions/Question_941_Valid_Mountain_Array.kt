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

        fun validMountainArrayWithTwoPointers(arr: IntArray): Boolean {
            var i = 0
            var j = arr.size - 1
            while (i < arr.size - 1 && arr[i] < arr[i + 1]) {
                i++
            }
            while (j > 0 && arr[j] < arr[j - 1]) {
                j--
            }
            return i < arr.size - 1 && i == j && j > 0
        }
    }
}