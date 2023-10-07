package questions


class Question_77_Combinations {

    companion object {

        fun runQuestion() {
//            Input: n = 4, k = 2
//            Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
            val n = 4
            val k = 2
            val resultList = combine(n, k)
            var result = "["
            resultList.forEachIndexed { firstIndex, firstI ->
                resultList[firstIndex].forEachIndexed { secondIndex, secondI ->
                    if (0 == secondIndex) {
                        result += "["
                    }
                    result += secondI
                    if (secondIndex == resultList[firstIndex].size - 1) {
                        result += "]"
                    } else {
                        result += ","
                    }
                }
                if (firstIndex == resultList.size - 1) {
                    result += "]"
                } else {
                    result += ","
                }
            }
            if (']' != result.last()) {
                result += "]"
            }
            println("Question 77: $result")
        }

        fun combine(n: Int, k: Int): List<List<Int>> {
            val resultList: MutableList<MutableList<Int>> = mutableListOf()
            val temp: MutableList<Int> = mutableListOf()
            dp(1, n, k, resultList, temp)
            return resultList
        }

        fun dp(start: Int, n: Int, k: Int, resultList: MutableList<MutableList<Int>>, temp: MutableList<Int>) {
            if (k == 0) {
                resultList.add(MutableList(temp.size) { index -> temp[index] })
                println(resultList)
                return
            }
            for (i in start..n - k + 1) {
                temp.add(i)
                println("add $i")
                dp(i + 1, n, k - 1, resultList, temp)
                val index = temp.size - 1
                val value = temp.removeAt(index)
                println("remove $value at ${index}")
            }
        }

        fun combineBacktrace(n: Int, k: Int): List<List<Int>> {
            val ans: MutableList<List<Int>> = ArrayList()
            getAns(1, n, k, ArrayList(), ans)
            return ans
        }

        private fun getAns(start: Int, n: Int, k: Int, temp: ArrayList<Int>, ans: MutableList<List<Int>>) {
            //如果 temp 里的数字够了 k 个，就把它加入到结果中
            if (temp.size == k) {
                ans.add(ArrayList(temp))
                return
            }
            //从 start 到 n
            for (i in start..n) {
                //将当前数字加入 temp
                temp.add(i)
                //进入递归
                getAns(i + 1, n, k, temp, ans)
                //将当前数字删除，进入下次 for 循环
                temp.removeAt(temp.size - 1)
            }
        }
    }
}