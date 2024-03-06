package questions

import models.ListNode

class Question_19_Remove_Nth_Node_From_End_of_List {

    companion object {

        fun runQuestion() {
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

        fun removeNthFromEndSolution2(head: ListNode?, n: Int): ListNode? {
            val result: MutableList<ListNode?> = mutableListOf()
            var current = head
            while (current != null) {
                result.add(current)
                current = current?.next
            }
            current = head
            val previousOfDeleteNode = result.size - 1 - n
            val nextOfDeleteNode = result.size - 1 - n + 2
            if (result.size - 1 - n < 0) {
                if (result.size == 1) {
                    return null
                } else {
                    return result[1]
                }
            } else {
                if (result.size - 1 - n + 2 <= result.size - 1) {
                    result[previousOfDeleteNode]?.next = result[nextOfDeleteNode]
                } else {
                    result[previousOfDeleteNode]?.next = null
                }
            }
            return current
        }
    }
}