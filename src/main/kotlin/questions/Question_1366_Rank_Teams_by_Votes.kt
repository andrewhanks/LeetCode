package questions

class Question_1366_Rank_Teams_by_Votes {

    companion object {

        fun runQuestion() {
//            Input: votes = ["WXYZ","XYZW"]
//            Output: "XWYZ"
            val stringArray = arrayOf("WXYZ", "XYZW")
            val result = rankTeams(stringArray)
            println("Question 1366: $result")
        }

        fun rankTeams(votes: Array<String>): String {
            if (votes.size == 1) {
                return votes[0]
            }
            val size = votes[0].length
            val result = Array(26) { IntArray(size + 1) { 0 } }
            for (count in 0..25) {
                result[count][size] = count
            }
            for (i in 0..votes.size - 1) {
                for (j in 0..votes[i].length - 1) {
                    result[votes[i][j] - 'A'][j]++
                }
            }
            // println("result origin = ${result.contentDeepToString()}")
            result.sortWith(Comparator { a, b ->
                var ret = 0
                for (count in 0..size - 1) {
                    if (a[count] < b[count]) {
                        ret = 1
                        break
                    } else if (a[count] > b[count]) {
                        ret = -1
                        break
                    }
                }
                ret
            })
            // println("result sorted = ${result.contentDeepToString()}")
            var ans = StringBuilder()
            for (count in 0..size - 1) {
                ans.append((result[count][size] + 'A'.toInt()).toChar())
            }
            return ans.toString()
        }
    }
}