package questions

import models.TreeNode

class Question_654_Maximum_Binary_Tree {

    companion object {

        fun runQuestion() {
//            Input: nums = [3,2,1,6,0,5]
//            Output: [6,3,5,null,2,0,null,null,1]
            val nums = intArrayOf(3, 2, 1, 6, 0, 5)
            val treeNode = constructMaximumBinaryTree(nums)
            var result = "["
            result = Utils.printTreeNodeByLevelOrder(result, treeNode)
            result += "]"
            println("Question 654: $result")
        }

        fun constructMaximumBinaryTree(nums: IntArray): TreeNode? {
            return construct(nums, null, 0)
        }

        fun construct(nums: IntArray, current: TreeNode?, child: Int): TreeNode? {
            val temp = nums.maxOrNull()
            if (temp == null) {
                return null
            }
            val node = TreeNode(temp)
            if (child == 1) {
                current?.left = node
            } else if (child == 2) {
                current?.right = node
            }
            val index = nums.indexOf(temp)
            val leftArray: MutableList<Int> = mutableListOf()
            for (count in 0..index - 1) {
                leftArray.add(nums[count])
            }
            construct(leftArray.toIntArray(), node, 1)
            val rightArray: MutableList<Int> = mutableListOf()
            for (count in index + 1..nums.size - 1) {
                rightArray.add(nums[count])
            }
            construct(rightArray.toIntArray(), node, 2)
            return node
        }
    }
}