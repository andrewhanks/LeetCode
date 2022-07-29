package questions

import models.ListNode

class Question_19_Remove_Nth_Node_From_End_of_List {

    companion object {

        fun runQuestion19() {
            val listNode = ListNode()
            listNode.`val` = 1
            listNode.next = ListNode(2)
            listNode.next!!.next = ListNode(3)
            listNode.next!!.next!!.next = ListNode(4)
            listNode.next!!.next!!.next!!.next = ListNode(5)
            val n = 2
            val resultListNode = removeNthFromEnd(listNode, n)
            var tempResultList = resultListNode
            var result = "[" + tempResultList!!.`val`.toString()
            tempResultList = tempResultList.next
            while (null != tempResultList!!.next) {
                result = result + "," + tempResultList.`val`
                tempResultList = tempResultList.next
            }
            result = result + "," + tempResultList.`val`
            result += "]"
            println("Question 19: $result")
        }

        fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
            if (null == head) {
                return null
            }
            var totalCount = 1
            var currentNode = head
            while (null != currentNode!!.next) {
                totalCount++
                currentNode = currentNode.next
            }
            println("totalCount = ${totalCount}")

            var finalRemoveItemCount = totalCount - n + 1
            currentNode = head

            if (1 == finalRemoveItemCount) {
                return head.next
            } else if (1 == totalCount) {
                return null
            } else if (2 == totalCount && 1 == n) {
                head.next = null
                return head
            }

            var nextNode = currentNode.next
            while (finalRemoveItemCount > 2) {
                currentNode = currentNode!!.next
                nextNode = currentNode!!.next
                finalRemoveItemCount--
            }

            currentNode!!.next = nextNode!!.next

            return head
        }
    }
}