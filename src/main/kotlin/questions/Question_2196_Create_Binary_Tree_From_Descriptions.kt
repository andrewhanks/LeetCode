package questions

import Utils
import models.TreeNode

class Question_2196_Create_Binary_Tree_From_Descriptions {

    companion object {

        fun runQuestion() {
//            Input: descriptions = [[20,15,1],[20,17,0],[50,20,1],[50,80,0],[80,19,1]]
//            Output: [50,20,80,15,17,19]
            val preorder = arrayOf(
                intArrayOf(20, 15, 1),
                intArrayOf(20, 17, 0),
                intArrayOf(50, 20, 1),
                intArrayOf(50, 80, 0),
                intArrayOf(80, 19, 1)
            )
            var treeNode = createBinaryTree(preorder)
            var result = "["
            result = Utils.printTreeNodeByLevelOrder(result, treeNode)
            result += "]"
            println("Question 2196: $result")
        }

        fun createBinaryTree(descriptions: Array<IntArray>): TreeNode? {
            if (descriptions.size == 0) {
                return null
            }
            var rootValue = 0
            for (i in 0..descriptions.size - 1) {
                var isTheSame = false
                for (j in 0..descriptions.size - 1) {
                    if (descriptions[j][1] == descriptions[i][0]) {
                        isTheSame = true
                    }
                }
                if (!isTheSame) {
                    rootValue = descriptions[i][0]
                }
            }
            // println("rootValue = $rootValue")
            val root = createNode(descriptions, rootValue)
            return root
        }

        fun createNode(descriptions: Array<IntArray>, value: Int): TreeNode {
            val node = TreeNode(value)
            for (count in 0..descriptions.size - 1) {
                if (value == descriptions[count][0]) {
                    if (descriptions[count][2] == 1) {
                        node.left = createNode(descriptions, descriptions[count][1])
                    } else {
                        node.right = createNode(descriptions, descriptions[count][1])
                    }
                }
            }
            return node
        }
    }
}