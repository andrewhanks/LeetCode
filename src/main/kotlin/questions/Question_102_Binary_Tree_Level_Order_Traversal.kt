package questions

import models.TreeNode
import java.util.*


class Question_102_Binary_Tree_Level_Order_Traversal {

    companion object {

        fun runQuestion() {
            val treeNodes: TreeNode
            val treeNode1 = TreeNode(3)
            val treeNode2 = TreeNode(9)
            val treeNode3 = TreeNode(20)
            val treeNode4 = TreeNode(15)
            val treeNode5 = TreeNode(7)
            treeNode1.left = treeNode2
            treeNode1.right = treeNode3
            treeNode3.left = treeNode4
            treeNode3.right = treeNode5
            treeNodes = treeNode1
            val resultList = levelOrder(treeNodes)
            var result = "["
            resultList.forEachIndexed { firstIndex, firstI ->
                resultList[firstIndex].forEachIndexed { secondIndex, secondI ->
                    if (0 == secondIndex) {
                        result += "["
                    }
                    result += secondI
                    if (secondIndex == resultList[firstIndex].size - 1) {
                        result += "]"
                    } else {
                        result += ","
                    }
                }
                if (firstIndex == resultList.size - 1) {
                    result += "]"
                } else {
                    result += ","
                }
            }
            if (']' != result.last()) {
                result += "]"
            }
            println("Question 102: $result")
        }

        fun levelOrder(root: TreeNode?): List<List<Int>> {
            val nodes: Queue<TreeNode?> = LinkedList()
            val resultList: MutableList<MutableList<Int>> = mutableListOf()
            if (root?.`val` == null) {
                return resultList
            }
            nodes.add(root)
            while (!nodes.isEmpty()) {
                val levelList: MutableList<Int> = mutableListOf()
                for (count in 0..nodes.size - 1) {
                    val item = nodes.remove()
                    if (item?.`val` != null) {
                        levelList.add(item?.`val`!!)
                    }
                    if (item?.left != null) {
                        nodes.add(item?.left)
                    }
                    if (item?.right != null) {
                        nodes.add(item?.right)
                    }
                }
                resultList.add(levelList)
            }
            return resultList
        }
    }
}