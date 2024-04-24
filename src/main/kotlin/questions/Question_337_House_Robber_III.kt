package questions

import models.TreeNode
import kotlin.math.max


class Question_337_House_Robber_III {

    companion object {

        fun runQuestion() {
//            Input: root = [3,2,3,null,3,null,1]
//            Output: 7
            val root: TreeNode
            val treeNode1 = TreeNode(3)
            val treeNode2 = TreeNode(2)
            val treeNode3 = TreeNode(3)
            val treeNode4 = TreeNode(3)
            val treeNode5 = TreeNode(1)
            treeNode1.left = treeNode2
            treeNode1.right = treeNode3
            treeNode2.right = treeNode4
            treeNode3.right = treeNode5
            root = treeNode1
            val result = robWithThreeStates(root)
            println("Question 337: $result")
        }

        fun robWithThreeStates(root: TreeNode?): Int {
            val result: Array<MutableMap<TreeNode?, Int>> = Array(3) { mutableMapOf() }
            return dpWithThreeStates(root, 2, result)
        }

        fun dpWithThreeStates(root: TreeNode?, rootTaken: Int, result: Array<MutableMap<TreeNode?, Int>>): Int {
            if (root == null) {
                return 0
            }
            if (result[rootTaken].contains(root)) {
                return result[rootTaken][root]!!
            }
            val value = if (rootTaken == 1) {
                root?.`val`!! + dpWithThreeStates(root?.left, 0, result) + dpWithThreeStates(root?.right, 0, result)
            } else if (rootTaken == 0) {
                dpWithThreeStates(root?.left, 2, result) + dpWithThreeStates(root?.right, 2, result)
            } else {
                max(dpWithThreeStates(root, 0, result), dpWithThreeStates(root, 1, result))
            }
            result[rootTaken][root] = value
            return value
        }

        fun robWithTakenAndNotTaken(root: TreeNode?): Int {
            val result: MutableMap<TreeNode?, Int> = mutableMapOf()
            return dpWithTakenAndNotTaken(root, result)
        }

        fun dpWithTakenAndNotTaken(root: TreeNode?, result: MutableMap<TreeNode?, Int>): Int {
            if (root == null) {
                return 0
            }
            if (result.contains(root)) {
                return result[root]!!
            }
            val left =
                dpWithTakenAndNotTaken(root?.left?.left, result) + dpWithTakenAndNotTaken(root?.left?.right, result)
            val right =
                dpWithTakenAndNotTaken(root?.right?.left, result) + dpWithTakenAndNotTaken(root?.right?.right, result)
            val taken = root?.`val`!! + left + right
            val notTaken = dpWithTakenAndNotTaken(root?.left, result) + dpWithTakenAndNotTaken(root?.right, result)
            result[root] = max(taken, notTaken)
            return result[root]!!
        }
    }
}