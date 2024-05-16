package questions

import models.Node
import java.util.*

class Question_116_Populating_Next_Right_Pointers_in_Each_Node {

    companion object {

        fun runQuestion() {
//            Input: root = [1,2,3,4,5,6,7]
//            Output: [1,#,2,3,#,4,5,6,7,#]
            val root: Node
            val node1 = Node(1)
            val node2 = Node(2)
            val node3 = Node(3)
            val node4 = Node(4)
            val node5 = Node(5)
            val node6 = Node(6)
            val node7 = Node(7)
            node1.left = node2
            node1.right = node3
            node2.left = node4
            node2.right = node5
            node3.left = node6
            node3.right = node7
            root = node1
            var node = connect(root)
            var result = "["
            result = Utils.printTreeNodeByLevelOrder(result, node)
            result += "]"
            println("Question 116: $result")
        }

        fun connect(root: Node?): Node? {
            if (root == null) {
                return root
            }
            val queue: Queue<Node?> = LinkedList()
            queue.add(root)
            while (!queue.isEmpty()) {
                val size = queue.size
                var node1 = queue.remove()
                addNodeToQueue(queue, node1)
                for (count in 1..size - 1) {
                    val node2 = queue.remove()
                    addNodeToQueue(queue, node2)
                    node1?.next = node2
                    node1 = node2
                }
                node1?.next = null
            }
            return root
        }

        fun addNodeToQueue(queue: Queue<Node?>, node: Node?) {
            if (node == null) {
                return
            }
            if (node?.left != null) {
                queue.add(node?.left)
            }
            if (node?.right != null) {
                queue.add(node?.right)
            }
        }
    }
}