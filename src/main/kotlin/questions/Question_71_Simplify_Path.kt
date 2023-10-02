package questions

class Question_71_Simplify_Path {

    companion object {

        fun runQuestion() {
            val string = "/a/./b/../../c/"
            val result = simplifyPath(string)
            println("Question 71: $result")
        }

        fun simplifyPath(path: String): String {
            var result: StringBuilder = StringBuilder()
            val tempPath = path.split('/')
            for (count in 0..tempPath.size - 1) {
                if (tempPath[count].isEmpty()) {

                } else if (tempPath[count] == ".") {

                } else if (tempPath[count] == "..") {
                    val lastIndexOfSlash = result.lastIndexOf("/")
                    if (lastIndexOfSlash != -1) {
                        result = result.deleteRange(lastIndexOfSlash, result.length)
                    }
                } else {
                    result.append("/")
                    result.append(tempPath[count])
                }
                println("result = $result, tempPath[count] = ${tempPath[count]}")
            }
            if (result.isEmpty()) {
                result.append("/")
            }
            return result.toString()
        }
    }
}