package questions

import java.util.*

class Question_1792_Maximum_Average_Pass_Ratio {

    companion object {

        fun runQuestion() {
//            Input: classes = [[1,2],[3,5],[2,2]], extraStudents = 2
//            Output: 0.78333
            val classes = arrayOf(intArrayOf(1, 2), intArrayOf(3, 5), intArrayOf(2, 2))
            val extraStudents = 2
            val result = maxAverageRatio(classes, extraStudents)
            println("Question 1792: $result")
        }

        fun maxAverageRatio(classes: Array<IntArray>, extraStudents: Int): Double {
            val queue = PriorityQueue<FloatArray> { a, b ->
                ((b[2] - a[2]) * 1000000000).toInt()
            }
            classes.forEach { item ->
                val increase = ((item[0] + 1F) / (item[1] + 1F)) - ((item[0].toFloat() / item[1]))
                // println("item[0]+1F/item[1]+1F = ${(item[0]+1F)/(item[1]+1F)}, item[0]/item[1] = ${item[0].toFloat()/item[1]}, increase = $increase")
                queue.add(floatArrayOf(item[0].toFloat(), item[1].toFloat(), increase))
            }
            var ret = 0.0
            for (i in 0..extraStudents - 1) {
                val item = queue.remove()
                // println("item = ${item.contentToString()}")
                val increase = ((item[0] + 2F) / (item[1] + 2F)) - ((item[0] + 1F) / (item[1] + 1F))
                queue.add(floatArrayOf(item[0] + 1F, item[1] + 1F, increase))
            }
            while (!queue.isEmpty()) {
                val item = queue.remove()
                ret += (item[0] / item[1])
            }
            ret = ret / classes.size
            return "%.5f".format(ret).toDouble()
        }
    }
}