package questions

import kotlin.math.max

class Question_3169_Count_Days_Without_Meetings {

    companion object {

        fun runQuestion() {
//            Input: days = 5, meetings = [[2,4],[1,3]]
//            Output: 1
            val meetings = arrayOf(
                intArrayOf(2, 4),
                intArrayOf(1, 3)
            )
            val days = 5
            val result = countDays(days, meetings)
            println("Question 3169: $result")
        }

        fun countDays(days: Int, meetings: Array<IntArray>): Int {
            meetings.sortBy { it[0] }
            val allMeetings: MutableList<IntArray> = mutableListOf()
            for (count in 0..meetings.size - 1) {
                if (allMeetings.size >= 1 &&
                    meetings[count][0] >= allMeetings[allMeetings.size - 1][0] &&
                    meetings[count][0] <= allMeetings[allMeetings.size - 1][1]
                ) {
                    allMeetings[allMeetings.size - 1][1] = max(allMeetings[allMeetings.size - 1][1], meetings[count][1])
                } else {
                    allMeetings.add(intArrayOf(meetings[count][0], meetings[count][1]))
                }
            }
            var result = days
            for (count in 0..allMeetings.size - 1) {
                result = result - (allMeetings[count][1] - allMeetings[count][0] + 1)
            }
            return result
        }
    }
}