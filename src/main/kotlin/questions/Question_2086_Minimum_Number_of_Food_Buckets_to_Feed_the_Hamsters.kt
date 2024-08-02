package questions

class Question_2086_Minimum_Number_of_Food_Buckets_to_Feed_the_Hamsters {

    companion object {

        fun runQuestion() {
//            Input: hamsters = "H..H"
//            Output: 2
            val hamsters = "H..H"
            val result = minimumBuckets(hamsters)
            println("Question 2086: $result")
        }

        fun minimumBuckets(hamsters: String): Int {
            val ham = StringBuilder(hamsters)
            if (ham.length == 1) {
                if (ham[0] == 'H') {
                    return -1
                } else {
                    return 0
                }
            }
            var ans = 0
            for (count in 0..ham.length - 1) {
                if (ham[count] != 'H') {
                    continue
                }
                if (count == 0) {
                    if (ham[count + 1] == '.') {
                        ham[count + 1] = 'F'
                        ans++
                    } else {
                        return -1
                    }
                } else if (count == ham.length - 1) {
                    if (ham[count - 1] == '.') {
                        ham[count - 1] = 'F'
                        ans++
                    } else if (ham[count - 1] == 'F') {
                        continue
                    } else {
                        return -1
                    }
                } else {
                    if (ham[count - 1] == 'F') {
                        continue
                    } else if (ham[count - 1] == 'H' && ham[count + 1] == 'H') {
                        return -1
                    } else if (ham[count + 1] == '.') {
                        ham[count + 1] = 'F'
                        ans++
                    } else if (ham[count - 1] == '.') {
                        ham[count - 1] = 'F'
                        ans++
                    }
                }
            }
            return ans
        }
    }
}