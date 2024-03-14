package questions

import models.TreeNode
import java.util.*


class Question_700_Search_in_a_Binary_Search_Tree {

    companion object {

        fun runQuestion() {
//            Input: root = [4,2,7,1,3], val = 2
//            Output: [2,1,3]
            val root: TreeNode
            val treeNode1 = TreeNode(4)
            val treeNode2 = TreeNode(2)
            val treeNode3 = TreeNode(7)
            val treeNode4 = TreeNode(1)
            val treeNode5 = TreeNode(3)
            treeNode1.left = treeNode2
            treeNode1.right = treeNode3
            treeNode2.left = treeNode4
            treeNode2.right = treeNode5
            root = treeNode1
            val `val` = 2
            val treeNode = searchBST(root, `val`)
            var result = "["
            result = Utils.printTreeNodeByLevelOrder(result, treeNode)
            result += "]"
            println("Question 700: $result")
        }

        fun searchBST(root: TreeNode?, `val`: Int): TreeNode? {
            return search(root, `val`)
        }

        fun search(root: TreeNode?, `val`: Int): TreeNode? {
            if (root?.`val` == `val`) {
                return root
            }
            var target: TreeNode? = null
            if (root?.left != null && target == null) {
                target = search(root?.left, `val`)
            }
            if (root?.right != null && target == null) {
                target = search(root?.right, `val`)
            }
            return target
        }

        fun searchBSTByIterative(root: TreeNode?, `val`: Int): TreeNode? {
            val queue: Queue<TreeNode?> = LinkedList()
            queue.add(root)
            while (!queue.isEmpty()) {
                val node = queue.remove()
                if (node?.`val` == `val`) {
                    return node
                }
                if (node?.left != null) {
                    queue.add(node?.left)
                }
                if (node?.right != null) {
                    queue.add(node?.right)
                }
            }
            return null
        }
    }
}