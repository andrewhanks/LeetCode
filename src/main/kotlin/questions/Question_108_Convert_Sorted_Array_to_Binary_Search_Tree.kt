package questions

import models.TreeNode

class Question_108_Convert_Sorted_Array_to_Binary_Search_Tree {

    companion object {

        fun runQuestion() {
//            Input: nums = [-10,-3,0,5,9]
//            Output: [0,-3,9,-10,null,5]
            val nums = intArrayOf(-10, -3, 0, 5, 9)
            val treeNode = sortedArrayToBST(nums)
            var result = "["
            result = Utils.printTreeNodeByLevelOrder(result, treeNode)
            result += "]"
            println("Question 108: $result")
        }

        fun sortedArrayToBST(nums: IntArray): TreeNode? {
            val mid = (nums.size - 1) / 2
            val rootNode = TreeNode(nums[mid])
            createTree(nums, 0, mid - 1, rootNode, 0)
            createTree(nums, mid + 1, nums.size - 1, rootNode, 1)
            return rootNode
        }

        fun createTree(nums: IntArray, start: Int, end: Int, prevNode: TreeNode, dir: Int) {
            if (start > end) {
                return
            }
            val mid = (start + end) / 2
            val node = TreeNode(nums[mid])
            if (dir == 0) {
                prevNode.left = node
            } else if (dir == 1) {
                prevNode.right = node
            }
            createTree(nums, start, mid - 1, node, 0)
            createTree(nums, mid + 1, end, node, 1)
        }
    }
}