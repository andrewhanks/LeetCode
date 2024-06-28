package questions

import java.util.*

class Question_735_Asteroid_Collision {

    companion object {

        fun runQuestion() {
//            Input: asteroids = [-2,1,1,-2]
//            Output: [-2,-2]
            val inputIntArray = intArrayOf(-2, 1, 1, -2)
            val result = asteroidCollision(inputIntArray)
            println("Question 735: ${result.contentToString()}")
        }

        fun asteroidCollision(asteroids: IntArray): IntArray {
            val positiveStack: Stack<Int> = Stack()
            val negativeStack: Stack<Int> = Stack()
            for (count in 0..asteroids.size - 1) {
                val asteroid = asteroids[count]
                if (asteroid > 0) {
                    positiveStack.add(asteroid)
                } else {
                    if (positiveStack.size == 0) {
                        negativeStack.add(asteroid)
                        continue
                    }
                    if (positiveStack.size != 0) {
                        var isMassBigger = false
                        while (positiveStack.size != 0 && positiveStack.peek() <= -asteroid) {
                            val last = positiveStack.removeLast()
                            if (last < -asteroid) {
                                isMassBigger = true
                            } else {
                                isMassBigger = false
                                if (last == -asteroid) {
                                    break
                                }
                            }
                        }
                        if (positiveStack.size == 0 && isMassBigger) {
                            negativeStack.add(asteroid)
                        }
                    }
                }
            }
            val result: MutableList<Int> = mutableListOf()
            while (positiveStack.size != 0) {
                result.add(positiveStack.removeLast())
            }
            while (negativeStack.size != 0) {
                result.add(negativeStack.removeLast())
            }
            return result.reversed().toIntArray()
        }
    }
}