package questions


class Question_2512_Reward_Top_K_Students {

    companion object {

        fun runQuestion() {
//            Input: positive_feedback = ["smart","brilliant","studious"], negative_feedback = ["not"],
//                report = ["this student is studious","the student is smart"], student_id = [1,2], k = 2
//            Output: [1,2]
            val positive_feedback = arrayOf("smart", "brilliant", "studious")
            val negative_feedback = arrayOf("not")
            val report = arrayOf("this student is studious", "the student is smart")
            val student_id = intArrayOf(1, 2)
            val k = 2
            val result = topStudents(positive_feedback, negative_feedback, report, student_id, k)
            println("Question 2512: $result")
        }

        fun topStudents(
            positive_feedback: Array<String>,
            negative_feedback: Array<String>,
            report: Array<String>,
            student_id: IntArray,
            k: Int
        ): List<Int> {
            val positiveMap: MutableMap<String, Int> = mutableMapOf()
            val negativeMap: MutableMap<String, Int> = mutableMapOf()
            for (item in positive_feedback) {
                positiveMap[item] = positiveMap.getOrDefault(item, 0) + 1
            }
            for (item in negative_feedback) {
                negativeMap[item] = negativeMap.getOrDefault(item, 0) + 1
            }
            val score = IntArray(student_id.size) { 0 }
            val result: MutableList<Int> = mutableListOf()
            for (i in 0..report.size - 1) {
                val sentences = report[i].split(" ")
                for (j in 0..sentences.size - 1) {
                    if (positiveMap[sentences[j]] != null) {
                        score[i] += 3
                    }
                    if (negativeMap[sentences[j]] != null) {
                        score[i] -= 1
                    }
                }
            }
            val temp = student_id.sortedWith(Comparator { a, b ->
                if (score[student_id.indexOf(b)] != score[student_id.indexOf(a)]) {
                    score[student_id.indexOf(b)] - score[student_id.indexOf(a)]
                } else {
                    a - b
                }
            })
            // println("student_id = ${student_id.contentToString()}")
            // println("score = ${score.contentToString()}")
            // println("temp = $temp")
            for (count in 0..k - 1) {
                result.add(temp[count])
            }
            return result
        }
    }
}