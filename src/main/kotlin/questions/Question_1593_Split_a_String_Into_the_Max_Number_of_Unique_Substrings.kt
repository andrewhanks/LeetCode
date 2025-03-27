package questions

class Question_1593_Split_a_String_Into_the_Max_Number_of_Unique_Substrings {

    companion object {

        fun runQuestion() {
//            Input: s = "ababccc"
//            Output: 5
            val s = "ababccc"
            val result = maxUniqueSplit(s)
            println("Question 1593: $result")
        }

        fun maxUniqueSplit(s: String): Int {
            val max: MutableList<MutableSet<String>> = MutableList(1) { mutableSetOf() }
            val set: MutableSet<String> = mutableSetOf()
            dfs(s, 0, max, set)
            return max[0].size
        }

        fun dfs(s: String, index: Int, max: MutableList<MutableSet<String>>, set: MutableSet<String>) {
            if (index > s.length - 1) {
                if (max[0].size < set.size) {
                    max[0] = set.toMutableSet()
                }
            }
            for (i in 1..s.length - 1 - index + 1) {
                val substring = s.substring(index..index + i - 1)
                // println("substring = $substring, set = $set")
                if (!set.contains(substring)) {
                    set.add(substring)
                    dfs(s, index + i, max, set)
                    set.remove(substring)
                }
            }
        }
    }
}