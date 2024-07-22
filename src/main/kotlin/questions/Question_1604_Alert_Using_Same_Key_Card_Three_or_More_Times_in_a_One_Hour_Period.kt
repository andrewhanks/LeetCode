package questions

import java.util.*

class Question_1604_Alert_Using_Same_Key_Card_Three_or_More_Times_in_a_One_Hour_Period {

    companion object {

        fun runQuestion() {
//            Input: keyName = ["alice","alice","alice","bob","bob","bob","bob"], keyTime = ["12:01","12:00","18:00","21:00","21:20","21:30","23:00"]
//            Output: ["bob"]
            val keyName = arrayOf("alice", "alice", "alice", "bob", "bob", "bob", "bob")
            val keyTime = arrayOf("12:01", "12:00", "18:00", "21:00", "21:20", "21:30", "23:00")
            val result = alertNames(keyName, keyTime)
            println("Question 1604: $result")
        }

        fun alertNames(keyName: Array<String>, keyTime: Array<String>): List<String> {
            val stored: MutableMap<String, MutableList<String>> = mutableMapOf()
            for (count in 0..keyName.size - 1) {
                if (!stored.contains(keyName[count])) {
                    stored.put(keyName[count], mutableListOf(keyTime[count]))
                } else {
                    stored[keyName[count]]!!.add(keyTime[count])
                }
            }
            val result: MutableSet<String> = mutableSetOf()
            for ((key, value) in stored) {
                value.sort()
                val queue: Queue<String> = LinkedList()
                for (count in 0..value.size - 1) {
                    if (queue.isEmpty() || !isLongerThanAnHour(queue.peek(), value[count])) {
                        queue.add(value[count])
                        if (queue.size >= 3) {
                            result.add(key)
                        }
                    } else {
                        while (!queue.isEmpty() && isLongerThanAnHour(queue.peek(), value[count])) {
                            queue.remove()
                        }
                        queue.add(value[count])
                    }
                    // println(queue)
                }
            }
            return result.toList().sorted()
        }

        fun isLongerThanAnHour(time1: String, time2: String): Boolean {
            val hour1 = time1.split(":")[0].toInt()
            val minute1 = time1.split(":")[1].toInt()
            val hour2 = time2.split(":")[0].toInt()
            val minute2 = time2.split(":")[1].toInt()
            // println("hour1 = $hour1, minute1 = $minute1, hour2 = $hour2, minute2 = $minute2")
            if (hour2 - hour1 > 1 || (hour2 - hour1 == 1 && minute2 - minute1 > 0)) {
                return true
            } else {
                return false
            }
        }
    }
}