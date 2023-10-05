package questions

import models.Node
import models.RandomNode
import java.util.*

class Question_138_Copy_List_with_Random_Pointer {

    companion object {

        fun runQuestion() {
//            Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
//            Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
            val nodes: RandomNode
            val node1 = RandomNode(7)
            val node2 = RandomNode(13)
            val node3 = RandomNode(11)
            val node4 = RandomNode(10)
            val node5 = RandomNode(1)
            node1.next = node2
            node1.random = null
            node2.next = node3
            node2.random = node1
            node3.next = node4
            node3.random = node5
            node4.next = node5
            node4.random = node3
            node5.next = null
            node5.random = node1
            nodes = node1
            var node = copyRandomList(nodes)
            var result = "["
            result = Utils.printRandomNode(result, node)
            result += "]"
            println("Question 138: $result")
        }

        fun copyRandomList(node: RandomNode?): RandomNode? {
            val map: MutableMap<RandomNode, RandomNode> = mutableMapOf()
            var curr = node
            while (curr != null) {
                map.put(curr, RandomNode(curr!!.`val`!!))
                curr = curr?.next
            }
            curr = node
            while (curr != null) {
                map.get(curr)?.next = map.get(curr?.next)
                map.get(curr)?.random = map.get(curr?.random)
                curr = curr?.next
            }
            return map.get(node)
        }
    }
}