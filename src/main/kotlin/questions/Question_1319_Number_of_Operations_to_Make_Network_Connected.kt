package questions

class Question_1319_Number_of_Operations_to_Make_Network_Connected {

    companion object {

        fun runQuestion() {
//            Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2],[1,3]]
//            Output: 2
            val connections =
                arrayOf(intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(0, 3), intArrayOf(1, 2), intArrayOf(1, 3))
            val n = 6
            val result = makeConnected(n, connections)
            println("Question 1319: $result")
        }

        fun makeConnected(n: Int, connections: Array<IntArray>): Int {
            if (n > connections.size + 1) {
                return -1
            }
            val store = IntArray(n) { 0 }
            for (count in 0..store.size - 1) {
                store[count] = count
            }
            for (count in 0..connections.size - 1) {
                union(store, connections[count][0], connections[count][1])
            }
            for (count in 0..connections.size - 1) {
                union(store, connections[count][0], connections[count][1])
            }
            // for(count in 0..n-1) {
            //     println("$count : ${store[count]}")
            // }
            store.sort()
            var ans = 0
            var pre = -1
            for (count in 0..store.size - 1) {
                if (pre != store[count]) {
                    pre = store[count]
                    ans++
                }
            }
            return ans - 1
        }

        fun union(store: IntArray, x: Int, y: Int) {
            val node1 = find(store, x)
            val node2 = find(store, y)
            if (node1 == node2) {
                return
            }
            store[node2] = node1
        }

        fun find(store: IntArray, x: Int): Int {
            if (x == store[x]) {
                return x
            }
            store[x] = find(store, store[x])
            return store[x]
        }
    }
}