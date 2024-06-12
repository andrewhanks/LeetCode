package questions

import java.util.*

class Question_721_Accounts_Merge {

    companion object {

        fun runQuestion() {
//            Input: accounts = [
//                ["John","johnsmith@mail.com","john_newyork@mail.com"],
//                ["John","johnsmith@mail.com","john00@mail.com"],
//                ["Mary","mary@mail.com"],
//                ["John","johnnybravo@mail.com"]
//            ]
//            Output: [
//                ["John","john00@mail.com","john_newyork@mail.com","johnsmith@mail.com"],
//                ["Mary","mary@mail.com"],
//                ["John","johnnybravo@mail.com"]
//            ]
            val accounts = listOf(
                listOf("John", "johnsmith@mail.com", "john_newyork@mail.com"),
                listOf("John", "johnsmith@mail.com", "john00@mail.com"),
                listOf("Mary", "mary@mail.com"),
                listOf("John", "johnnybravo@mail.com")
            )
            val result = accountsMerge(accounts)
            println("Question 721: $result")
        }

        fun accountsMerge(accounts: List<List<String>>): List<List<String>> {
            val union: MutableMap<String, TreeSet<String>> = mutableMapOf()
            val parents: MutableMap<String, String> = mutableMapOf()
            val owners: MutableMap<String, String> = mutableMapOf()
            for (i in 0..accounts.size - 1) {
                val name = accounts[i][0]
                for (j in 1..accounts[i].size - 1) {
                    val email = accounts[i][j]
                    parents.put(email, email)
                    owners.put(email, name)
                }
            }
            for (i in 0..accounts.size - 1) {
                val node1 = find(parents, accounts[i][1])
                for (j in 1..accounts[i].size - 1) {
                    val node2 = find(parents, accounts[i][j])
                    parents[node2] = node1
                }
            }
            for (i in 0..accounts.size - 1) {
                val node = find(parents, accounts[i][1])
                if (!union.contains(node)) {
                    union.put(node, TreeSet())
                }
                union[node]!!.add(accounts[i][1])
                for (j in 2..accounts[i].size - 1) {
                    union[node]!!.add(accounts[i][j]!!)
                }
            }
            val result: MutableList<MutableList<String>> = mutableListOf()
            for ((key, value) in union) {
                val temp: MutableList<String> = mutableListOf()
                temp.add(owners[key]!!)
                temp.addAll(union[key]!!)
                result.add(temp)
            }
            return result
        }

        fun find(parents: MutableMap<String, String>, email: String): String {
            if (parents[email] == email) {
                return email
            }
            parents[email] = find(parents, parents[email]!!)
            return parents[email]!!
        }
    }
}