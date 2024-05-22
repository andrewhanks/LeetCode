package questions

class Question_657_Robot_Return_to_Origin {

    companion object {

        fun runQuestion() {
//            Input: moves = "UD"
//            Output: true
            val moves = "UD"
            val result = judgeCircle(moves)
            println("Question 657: $result")
        }

        fun judgeCircle(moves: String): Boolean {
            val dir = mapOf(
                'U' to intArrayOf(1,0),
                'D' to intArrayOf(-1,0),
                'L' to intArrayOf(0,-1),
                'R' to intArrayOf(0,1)
            )
            val result = intArrayOf(0,0)
            for(count in 0..moves.length-1) {
                result[0]=result[0]+dir[moves[count]]!![0]!!
                result[1]=result[1]+dir[moves[count]]!![1]!!
            }
            if(result[0]==0 && result[1]==0) {
                return true
            }else {
                return false
            }
        }
    }
}