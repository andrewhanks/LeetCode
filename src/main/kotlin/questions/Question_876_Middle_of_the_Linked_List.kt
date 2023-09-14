package questions

import models.ListNode

class Question_876_Middle_of_the_Linked_List {

    companion object {

        fun runQuestion() {
            // [1,2,3,4,5]
            val listNode = ListNode()
            listNode.`val` = 1
            listNode.next = ListNode(2)
            listNode.next!!.next = ListNode(3)
            listNode.next!!.next!!.next = ListNode(4)
            listNode.next!!.next!!.next!!.next = ListNode(5)
            val resultListNode = middleNode(listNode)
            var tempResultList = resultListNode
            var result = "[" + tempResultList!!.`val`.toString()
            tempResultList = tempResultList.next
            while (null != tempResultList!!.next) {
                result = result + "," + tempResultList.`val`
                tempResultList = tempResultList.next
            }
            result = result + "," + tempResultList.`val`
            result += "]"
            println("Question 876: $result")
        }

        fun middleNode(head: ListNode?): ListNode? {
            val nodeArray: MutableList<Int> = mutableListOf()
            var currentNode = head
            while (currentNode?.`val` != null) {
                nodeArray.add(currentNode.`val`)
                currentNode = currentNode.next
            }
            currentNode = head
            println("nodeArray[nodeArray.size/2] = " + nodeArray[nodeArray.size / 2])
            for (count in 0..nodeArray.size / 2 - 1) {
                currentNode = currentNode?.next
            }
            return currentNode
        }
    }
}