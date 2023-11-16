package questions

class Question_205_Isomorphic_Strings {

    companion object {

        fun runQuestion() {
//            Input: s = "egg", t = "add"
//            Output: true
            val s = "egg"
            val t = "add"
            val result = isIsomorphic(s, t)
            println("Question 205: $result")
        }

        fun isIsomorphic(s: String, t: String): Boolean {
            if (s.length != t.length) {
                return false
            }
            val mapping: MutableMap<Char, Char> = mutableMapOf()
            for (count in 0..s.length - 1) {
                if (mapping.contains(s[count])) {
                    if (t[count] != mapping[s[count]]) {
                        return false
                    }
                } else {
                    for ((key, value) in mapping) {
                        if (t[count] == value) {
                            return false
                        }
                    }
                    mapping.put(s[count], t[count])
                }
            }
            return true
        }
    }
}