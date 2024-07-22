package questions

import models.TreeNode
import java.util.*


class Question_1123_Lowest_Common_Ancestor_of_Deepest_Leaves {

    companion object {

        fun runQuestion() {
//            Input: root = [3,5,1,6,2,0,8,null,null,7,4]
//            Output: [2,7,4]
            val root: TreeNode
            val treeNode1 = TreeNode(3)
            val treeNode2 = TreeNode(5)
            val treeNode3 = TreeNode(1)
            val treeNode4 = TreeNode(6)
            val treeNode5 = TreeNode(2)
            val treeNode6 = TreeNode(0)
            val treeNode7 = TreeNode(8)
            val treeNode8 = TreeNode(7)
            val treeNode9 = TreeNode(4)
            treeNode1.left = treeNode2
            treeNode1.right = treeNode3
            treeNode2.left = treeNode4
            treeNode2.right = treeNode5
            treeNode3.left = treeNode6
            treeNode3.right = treeNode7
            treeNode5.left = treeNode8
            treeNode5.right = treeNode9
            root = treeNode1
            val treeNode = lcaDeepestLeaves(root)
            var result = "["
            result = Utils.printTreeNodeByLevelOrder(result, treeNode)
            result += "]"
            println("Question 1123: $result")
        }

        fun lcaDeepestLeaves(root: TreeNode?): TreeNode? {
            if (root == null) {
                return null
            }
            val stored: MutableList<TreeNode> = mutableListOf()
            var level = 0
            val queue: Queue<TreeNode> = LinkedList()
            queue.add(root)
            while (!queue.isEmpty()) {
                val size = queue.size
                level++
                for (count in 0..size - 1) {
                    val node = queue.remove()
                    if (node?.left != null) {
                        queue.add(node?.left)
                    }
                    if (node?.right != null) {
                        queue.add(node?.right)
                    }
                }
            }
            return find(root, level, 1)
        }

        fun find(root: TreeNode?, level: Int, currentLevel: Int): TreeNode? {
            // println("level = $level, currentLevel = $currentLevel")
            if (root == null || currentLevel == level) {
                return root
            }
            val left = find(root?.left, level, currentLevel + 1)
            val right = find(root?.right, level, currentLevel + 1)
            if (left == null) {
                return right
            }
            if (right == null) {
                return left
            }
            return root
        }
    }
}