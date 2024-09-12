package questions

import kotlin.math.abs


class Question_1169_Invalid_Transactions {

    companion object {

        fun runQuestion() {
//            Input: transactions = ["alice,20,800,mtv","alice,50,100,beijing"]
//            Output: ["alice,20,800,mtv","alice,50,100,beijing"]
            val transactions = arrayOf("alice,20,800,mtv", "alice,50,100,beijing")
            val result = invalidTransactions(transactions)
            println("Question 1169: $result")
        }

        fun invalidTransactions(transactions: Array<String>): List<String> {
            val map: MutableMap<String, MutableList<String>> = mutableMapOf()
            for (tran in transactions) {
                val name = tran.split(",")[0]
                if (map.contains(name)) {
                    map[name]!!.add(tran)
                } else {
                    map.put(name, mutableListOf(tran))
                }
            }
            val invalid: MutableList<String> = mutableListOf()
            for ((name, trans) in map) {
                // println("trans = $trans")
                for (i in 0..trans.size - 1) {
                    for (j in 0..trans.size - 1) {
                        val curTran = trans[i]
                        val compareTran = trans[j]
                        if (curTran.split(",")[2].toInt() > 1000) {
                            invalid.add(curTran)
                            break
                        }
                        if (i == j) {
                            continue
                        }
                        if (abs(curTran.split(",")[1].toInt() - compareTran.split(",")[1].toInt()) <= 60 &&
                            curTran.split(",")[3] != compareTran.split(",")[3]
                        ) {
                            invalid.add(curTran)
                            break
                        }
                    }
                }
            }
            return invalid
        }
    }
}