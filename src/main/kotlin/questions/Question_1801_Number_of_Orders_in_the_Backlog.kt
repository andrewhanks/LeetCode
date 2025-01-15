package questions

import java.util.*


class Question_1801_Number_of_Orders_in_the_Backlog {

    companion object {

        fun runQuestion() {
//            Input: orders = [[10,5,0],[15,2,1],[25,1,1],[30,4,0]]
//            Output: 6
            val orders = arrayOf(intArrayOf(10, 5, 0), intArrayOf(15, 2, 1), intArrayOf(25, 1, 1), intArrayOf(30, 4, 0))
            val result = getNumberOfBacklogOrders(orders)
            println("Question 1801: $result")
        }

        fun getNumberOfBacklogOrders(orders: Array<IntArray>): Int {
            val mod = 1000000007
            val buyQueue = PriorityQueue<IntArray> { a, b ->
                b[0] - a[0]
            }
            val sellQueue = PriorityQueue<IntArray> { a, b ->
                a[0] - b[0]
            }
            for (order in orders) {
                val price = order[0]
                var rest = order[1]
                if (order[2] == 0) {
                    while (!sellQueue.isEmpty() && sellQueue.peek()[0] <= price && rest > 0) {
                        val sellItem = sellQueue.remove()
                        if (rest - sellItem[1] >= 0) {
                            rest = rest - sellItem[1]
                        } else {
                            sellQueue.add(intArrayOf(sellItem[0], sellItem[1] - rest))
                            rest = 0
                            break
                        }
                    }
                    if (rest > 0) {
                        buyQueue.add(intArrayOf(order[0], rest))
                    }
                } else if (order[2] == 1) {
                    while (!buyQueue.isEmpty() && buyQueue.peek()[0] >= price && rest > 0) {
                        val buyItem = buyQueue.remove()
                        if (rest - buyItem[1] >= 0) {
                            rest = rest - buyItem[1]
                        } else {
                            buyQueue.add(intArrayOf(buyItem[0], buyItem[1] - rest))
                            rest = 0
                            break
                        }
                    }
                    if (rest > 0) {
                        sellQueue.add(intArrayOf(order[0], rest))
                    }
                }
            }
            var ans = 0L
            for (item in buyQueue) {
                ans += item[1]
                ans = ans % mod
                // println("buyQueue item = ${item.contentToString()}")
            }
            for (item in sellQueue) {
                ans += item[1]
                ans = ans % mod
                // println("sellQueue item = ${item.contentToString()}")
            }
            return ans.toInt()
        }
    }
}