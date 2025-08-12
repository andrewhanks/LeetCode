package questions

import models.TreeNode
import java.util.*

class Question_1028_Recover_a_Tree_From_Preorder_Traversal {

    companion object {

        fun runQuestion() {
//            Input: traversal = "1-2--3---4-5--6---7"
//            Output: [1,2,5,3,null,6,null,4,null,7]
            val traversal = "1-2--3---4-5--6---7"
            val treeNode = recoverFromPreorder(traversal)
            var result = "["
            result = Utils.printTreeNodeByLevelOrder(result, treeNode)
            result += "]"
            println("Question 1028: $result")
        }

        fun recoverFromPreorder(traversal: String): TreeNode? {
            var root: TreeNode? = null
            val stack: Stack<TreeNode?> = Stack()
            var level = 0
            var value = ""
            var i = 0
            while (i <= traversal.length - 1) {
                // println("traversal[$i] = ${traversal[i]}")
                if (traversal[i] != '-') {
                    value += traversal[i]
                } else {
                    if (!value.isEmpty()) {
                        if (root == null) {
                            root = TreeNode(value.toInt())
                            stack.add(root)
                        } else {
                            createNextNode(level, value, stack)
                        }
                        level = 0
                        value = ""
                    }
                    level++
                }
                i++
            }
            if (root == null) {
                root = TreeNode(value.toInt())
                stack.add(root)
            } else {
                createNextNode(level, value, stack)
            }
            return root
        }

        fun createNextNode(level: Int, value: String, stack: Stack<TreeNode?>) {
            // println("level = $level, stack.size = ${stack?.size}, value = $value")
            if (level == stack.size) {
                val item = stack.peek()
                val leftNode = TreeNode(value.toInt())
                item?.left = leftNode
                stack.add(leftNode)
            } else {
                while (level < stack.size) {
                    stack.removeLast()
                }
                // println("stack.size = ${stack?.size}, stack.peek() = ${stack.peek()?.`val`}")
                val item = stack.peek()
                val rightNode = TreeNode(value.toInt())
                item?.right = rightNode
                stack.add(rightNode)
            }
        }
    }
}