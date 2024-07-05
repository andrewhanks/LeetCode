package questions

import models.ListNode

class Question_61_Rotate_List {

    companion object {

        fun runQuestion() {
//            Input: head = [1,2,3,4,5], k = 2
//            Output: [4,5,1,2,3]
            val listNode = ListNode()
            listNode.`val` = 1
            listNode.next = ListNode(2)
            listNode.next!!.next = ListNode(3)
            listNode.next!!.next!!.next = ListNode(4)
            listNode.next!!.next!!.next!!.next = ListNode(5)
            val k = 2
            val resultListNode = rotateRight(listNode, k)
            var tempResultList = resultListNode
            var result = "[" + tempResultList!!.`val`.toString()
            tempResultList = tempResultList.next
            while (null != tempResultList!!.next) {
                result = result + "," + tempResultList.`val`
                tempResultList = tempResultList.next
            }
            result = result + "," + tempResultList.`val`
            result += "]"
            println("Question 61: $result")
        }

        fun rotateRight(head: ListNode?, k: Int): ListNode? {
            if (head == null) {
                return null
            }
            val stored: MutableList<ListNode> = mutableListOf()
            var current = head
            while (current != null) {
                stored.add(current)
                current = current?.next
            }
            val remain = k % stored.size
            val start = (stored.size - remain) % stored.size
            val result = stored[start]
            current = result
            for (count in start + 1..start + stored.size - 1) {
                current?.next = stored[count % stored.size]
                current = current?.next
                current?.next = null
            }
            return result
        }

        fun rotateRightOldSolution(head: ListNode?, k: Int): ListNode? {
            if (head == null || head?.next == null) {
                return head
            }
            var currentNode = head
            var totalNumber = 0
            while (currentNode != null) {
                totalNumber++
                currentNode = currentNode?.next
            }
            if (k % totalNumber == 0) {
                return head
            }
            var itemCountFromHead = totalNumber - k
            while (itemCountFromHead < 0) {
                itemCountFromHead += totalNumber
            }
            currentNode = head
            var currentCount = 0
            var currentHead: ListNode? = null
            println("=======================")
            while (currentNode != null) {
                println(currentNode?.`val`)
                currentCount++
                var tempNode: ListNode? = null
                if (currentCount == itemCountFromHead) {
                    tempNode = currentNode
                } else {
                    if (currentCount == itemCountFromHead + 1) {
                        currentHead = currentNode
                    }
                    if (currentCount == totalNumber) {
                        currentNode?.next = head
                    }
                }
                currentNode = currentNode?.next
                if (currentCount == itemCountFromHead) {
                    tempNode?.next = null
                }
            }
            return currentHead
        }
    }
}