package questions

class Question_2126_Destroying_Asteroids {

    companion object {

        fun runQuestion() {
            val massArray = intArrayOf(3, 9, 19, 5, 21)
            val planetMass = 10
            val result = asteroidsDestroyed(planetMass, massArray)
            println("Question 2126: $result")
        }

        fun asteroidsDestroyed(mass: Int, asteroids: IntArray): Boolean {
            var tempMass = mass.toLong()
            asteroids.sort()
            asteroids.forEach { value ->
                if (tempMass >= value) {
                    tempMass += value
                } else {
                    return false
                }
            }
            return true
        }
    }
}