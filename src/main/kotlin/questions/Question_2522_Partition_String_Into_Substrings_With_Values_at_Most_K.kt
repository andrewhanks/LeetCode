package questions

class Question_2522_Partition_String_Into_Substrings_With_Values_at_Most_K {

    companion object {

        fun runQuestion() {
//            Input: s = "165462", k = 60
//            Output: 4
            val s = "165462"
            val k = 60
            val result = minimumPartition(s, k)
            println("Question 2522: $result")
        }

        fun minimumPartition(s: String, k: Int): Int {
            var result = s
            val targetSize = k.toString().length
            var count = 0
            while (result.length > 0) {
                var temp = if (targetSize <= result.length) {
                    println("targetSize = $targetSize, result.length = ${result.length}")
                    result.substring(0..targetSize - 1)
                } else {
                    result.substring(0..result.length - 1)
                }
                println("temp.toInt() = ${temp.toInt()}, k = $k")
                if (temp.length < targetSize) {
                    result = ""
                } else {
                    if (temp.toInt() <= k) {
                        result = result.substring(targetSize..result.length - 1)
                    } else {
                        result = result.substring(targetSize - 1..result.length - 1)
                        if (targetSize == 1 && temp.length == 1) {
                            return -1
                        }
                    }
                }
                count++
            }
            return count
        }
    }
}