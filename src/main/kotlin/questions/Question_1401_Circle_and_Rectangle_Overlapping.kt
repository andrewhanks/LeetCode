package questions

class Question_1401_Circle_and_Rectangle_Overlapping {

    companion object {

        fun runQuestion() {
//            Input: radius = 1, xCenter = 0, yCenter = 0, x1 = 1, y1 = -1, x2 = 3, y2 = 1
//            Output: true
            val radius = 1
            val xCenter = 0
            val yCenter = 0
            val x1 = 1
            val y1 = -1
            val x2 = 3
            val y2 = 1
            val result = checkOverlap(radius, xCenter, yCenter, x1, y1, x2, y2)
            println("Question 1401: $result")
        }

        fun checkOverlap(radius: Int, xCenter: Int, yCenter: Int, x1: Int, y1: Int, x2: Int, y2: Int): Boolean {
            if (xCenter >= x1 && xCenter <= x2 && yCenter >= y1 && yCenter <= y2) return true

            if (xCenter <= x1 && yCenter >= y1 && yCenter <= y2 && xCenter + radius >= x1) return true
            if (yCenter >= y2 && xCenter >= x1 && xCenter <= x2 && yCenter - radius <= y2) return true
            if (xCenter >= x2 && yCenter >= y1 && yCenter <= y2 && xCenter - radius <= x2) return true
            if (yCenter <= y1 && xCenter >= x1 && xCenter <= x2 && yCenter + radius >= y1) return true

            if (((x1 - xCenter) * (x1 - xCenter) + (y1 - yCenter) * (y1 - yCenter) <= radius * radius) ||
                ((x2 - xCenter) * (x2 - xCenter) + (y1 - yCenter) * (y1 - yCenter) <= radius * radius) ||
                ((x1 - xCenter) * (x1 - xCenter) + (y2 - yCenter) * (y2 - yCenter) <= radius * radius) ||
                ((x2 - xCenter) * (x2 - xCenter) + (y2 - yCenter) * (y2 - yCenter) <= radius * radius)
            ) return true

            return false
        }
    }
}