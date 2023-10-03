package questions

import models.Node
import java.util.*

class Question_117_Populating_Next_Right_Pointers_in_Each_Node_II {

    companion object {

        fun runQuestion() {
//            Input: root = [1,2,3,4,5,null,7]
//            Output: [1,#,2,3,#,4,5,7,#]
            val nodes: Node
            val node1 = Node(1)
            val node2 = Node(2)
            val node3 = Node(3)
            val node4 = Node(4)
            val node5 = Node(5)
            val node7 = Node(7)
            node1.left = node2
            node1.right = node3
            node2.left = node4
            node2.right = node5
            node3.right = node7
            nodes = node1
            var node = connect(nodes)
            var result = "["
            result = Utils.printTreeNodeByLevelOrder(result, node)
            result += "]"
            println("Question 105: $result")
        }

        fun connect(root: Node?): Node? {
            val queue: Queue<Node?> = LinkedList()
            queue.add(root)
            while (queue.size > 0) {
                var tempNode: Node? = null
                val size = queue.size
                println("size = $size")
                for (count in 0..size - 1) {
                    val item = queue.remove()
                    println("count = $count")
                    if (count == 0) {
                        tempNode = item
                        println("tempNode = ${tempNode?.`val`}")
                    } else {
                        tempNode?.next = item
                        println("tempNode?.next = ${tempNode?.next?.`val`}")
                        tempNode = item
                    }
                    if (item?.left != null) {
                        queue.add(item.left)
                    }
                    if (item?.right != null) {
                        queue.add(item.right)
                    }
                }
            }
            return root
        }
    }
}