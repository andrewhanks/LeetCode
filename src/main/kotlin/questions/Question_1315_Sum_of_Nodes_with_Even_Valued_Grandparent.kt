package questions

import models.TreeNode
import java.util.*


class Question_1315_Sum_of_Nodes_with_Even_Valued_Grandparent {

    companion object {

        fun runQuestion() {
            // Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
            // Output: 18
            val treeNodes: TreeNode
            val treeNode1 = TreeNode(6)
            val treeNode2 = TreeNode(7)
            val treeNode3 = TreeNode(8)
            val treeNode4 = TreeNode(2)
            val treeNode5 = TreeNode(7)
            val treeNode6 = TreeNode(1)
            val treeNode7 = TreeNode(3)
            val treeNode8 = TreeNode(9)
            val treeNode9 = TreeNode(null)
            val treeNode10 = TreeNode(1)
            val treeNode11 = TreeNode(4)
            val treeNode12 = TreeNode(null)
            val treeNode13 = TreeNode(null)
            val treeNode14 = TreeNode(null)
            val treeNode15 = TreeNode(5)
            treeNode1.left = treeNode2
            treeNode1.right = treeNode3
            treeNode2.left = treeNode4
            treeNode2.right = treeNode5
            treeNode3.left = treeNode6
            treeNode3.right = treeNode7
            treeNode4.left = treeNode8
            treeNode4.right = treeNode9
            treeNode5.left = treeNode10
            treeNode5.right = treeNode11
            treeNode6.left = treeNode12
            treeNode6.right = treeNode13
            treeNode7.left = treeNode14
            treeNode7.right = treeNode15
            treeNodes = treeNode1
            val result = sumEvenGrandparent(treeNodes)
            println("Question 1315: $result")
        }

        fun sumEvenGrandparent(root: TreeNode?): Int {
            val tempArray: Queue<TreeNode?> = LinkedList()
            val treeArray: MutableList<Int?> = mutableListOf()
            tempArray.add(root)
            var result = 0
            while (!tempArray.isEmpty()) {
                val tempNode = tempArray.poll()
                if (tempNode?.`val` != null && tempNode.`val`!! % 2 == 0) {
                    println("tempNode.`val` 1 = " + tempNode.`val`)
                    result += calculateSum(tempNode)
                }
                treeArray.add(tempNode?.`val`)
                if (tempNode?.left != null) {
                    tempArray.add(tempNode.left)
                }
                if (tempNode?.right != null) {
                    tempArray.add(tempNode.right)
                }
            }
            return result
        }

        fun calculateSum(node: TreeNode?): Int {
            val tempArray: Queue<TreeNode?> = LinkedList()
            tempArray.add(node)
            var count = 0
            var existCount = 0
            if (node?.left != null && node.right != null) {
                existCount = 3
            } else if (node?.left != null || node?.right != null) {
                existCount = 2
            } else {
                existCount = 1
            }
            var result = 0
            while (!tempArray.isEmpty()) {
                val tempNode = tempArray.poll()
                println("count 2 = " + count + ", existCount = " + existCount)
                if (count == existCount && tempNode?.`val` != null) {
                    println("tempNode.`val` 2 = " + tempNode.`val`)
                    result += tempNode.`val`!!
                    println("result 2 = " + result)
                    continue
                }
                if (count == existCount) {
                    continue
                }
                if (tempNode?.left != null) {
                    tempArray.add(tempNode.left)
                }
                if (tempNode?.right != null) {
                    tempArray.add(tempNode.right)
                }
                count++
            }
            return result
        }
    }
}