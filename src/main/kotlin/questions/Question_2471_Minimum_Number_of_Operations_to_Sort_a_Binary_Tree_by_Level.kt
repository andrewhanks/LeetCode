package questions

import models.TreeNode
import java.util.*


class Question_2471_Minimum_Number_of_Operations_to_Sort_a_Binary_Tree_by_Level {

    companion object {

        fun runQuestion() {
//            Input: root = [1,4,3,7,6,8,5,null,null,null,null,9,null,10]
//            Output: 3
            val root: TreeNode
            val treeNode1 = TreeNode(1)
            val treeNode2 = TreeNode(4)
            val treeNode3 = TreeNode(3)
            val treeNode4 = TreeNode(7)
            val treeNode5 = TreeNode(6)
            val treeNode6 = TreeNode(8)
            val treeNode7 = TreeNode(5)
            val treeNode8 = TreeNode(9)
            val treeNode9 = TreeNode(10)
            treeNode1.left = treeNode2
            treeNode1.right = treeNode3
            treeNode2.left = treeNode4
            treeNode2.right = treeNode5
            treeNode3.left = treeNode6
            treeNode3.right = treeNode7
            treeNode6.left = treeNode8
            treeNode7.left = treeNode9
            root = treeNode1
            val result = minimumOperations(root)
            println("Question 2471: $result")
        }

        fun minimumOperations(root: TreeNode?): Int {
            val queue: Queue<TreeNode> = LinkedList()
            queue.add(root)
            var ans = 0
            while (!queue.isEmpty()) {
                val size = queue.size
                val levelNode: MutableList<Int> = mutableListOf()
                for (count in 0..size - 1) {
                    val node = queue.remove()
                    val value = node?.`val`!!
                    levelNode.add(value)
                    if (node?.left != null) {
                        queue.add(node?.left)
                    }
                    if (node?.right != null) {
                        queue.add(node?.right)
                    }
                }
                // println("levelNode = $levelNode")
                ans += sort(levelNode)
            }
            return ans
        }

        fun sort(levelNode: MutableList<Int>): Int {
            val sorted = levelNode.sorted().toMutableList()
            var ans = 0
            // println("levelNode = $levelNode, sorted = $sorted")
            for (count in 0..levelNode.size - 1) {
                if (levelNode[count] != sorted[count]) {
                    val index = levelNode.indexOf(sorted[count])
                    val temp = levelNode[count]
                    levelNode[count] = levelNode[index]
                    levelNode[index] = temp
                    ans++
                }
            }
            return ans
        }
    }
}