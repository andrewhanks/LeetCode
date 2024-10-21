package questions

import models.TreeNode
import java.util.*


class Question_2641_Cousins_in_Binary_Tree_II {

    companion object {

        fun runQuestion() {
//            Input: root = [5,4,9,1,10,null,7]
//            Output: [0,0,0,7,7,null,11]
            val root: TreeNode
            val treeNode1 = TreeNode(5)
            val treeNode2 = TreeNode(4)
            val treeNode3 = TreeNode(9)
            val treeNode4 = TreeNode(1)
            val treeNode5 = TreeNode(10)
            val treeNode7 = TreeNode(7)
            treeNode1.left = treeNode2
            treeNode1.right = treeNode3
            treeNode2.left = treeNode4
            treeNode2.right = treeNode5
            treeNode3.right = treeNode7
            root = treeNode1
            val treeNode = replaceValueInTree(root)
            var result = "["
            result = Utils.printTreeNodeByLevelOrder(result, treeNode)
            result += "]"
            println("Question 2641: $result")
        }

        fun replaceValueInTree(root: TreeNode?): TreeNode? {
            val queue: Queue<TreeNode> = LinkedList()
            queue.add(root)
            queue.add(TreeNode(-1))
            while (!queue.isEmpty()) {
                val size = queue.size
                val levelNodes: MutableList<TreeNode> = mutableListOf()
                val levelValues: MutableList<Int> = mutableListOf()
                var total = 0
                var sum = 0
                var times = 0
                for (i in 0..size - 1) {
                    val node = queue.remove()
                    if (node?.`val` == -1) {
                        for (count in 0..times - 1) {
                            levelValues.add(sum)
                        }
                        sum = 0
                        times = 0
                        continue
                    } else {
                        sum += node?.`val`!!
                        times++
                    }
                    total += node?.`val`!!
                    levelNodes.add(node)
                    if (node?.left != null) {
                        queue.add(node?.left)
                    }
                    if (node?.right != null) {
                        queue.add(node?.right)
                    }
                    queue.add(TreeNode(-1))
                }
                // println("levelNodes = $levelNodes, levelValues = $levelValues")
                for (i in 0..levelNodes.size - 1) {
                    levelNodes[i]?.`val` = total - levelValues[i]
                }
            }
            return root
        }
    }
}