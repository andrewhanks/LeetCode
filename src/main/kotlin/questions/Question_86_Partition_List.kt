package questions

import models.ListNode

class Question_86_Partition_List {

    companion object {

        fun runQuestion() {
//            Input: head = [1,4,3,2,5,2], x = 3
//            Output: [1,2,2,4,3,5]
            val listNode = ListNode()
            listNode.`val` = 1
            listNode.next = ListNode(4)
            listNode.next!!.next = ListNode(3)
            listNode.next!!.next!!.next = ListNode(2)
            listNode.next!!.next!!.next!!.next = ListNode(5)
            listNode.next!!.next!!.next!!.next!!.next = ListNode(2)
            val x = 3
            val resultListNode = partition(listNode, x)
            var tempResultList = resultListNode
            var result = "[" + tempResultList!!.`val`.toString()
            tempResultList = tempResultList.next
            while (null != tempResultList!!.next) {
                result = result + "," + tempResultList.`val`
                tempResultList = tempResultList.next
            }
            result = result + "," + tempResultList.`val`
            result += "]"
            println("Question 86: $result")
        }

        fun partition(head: ListNode?, x: Int): ListNode? {
            if (head == null || head?.next == null) {
                return head
            }
            val result: MutableList<Int> = mutableListOf()
            var currentNode: ListNode? = head
            while (currentNode != null) {
                result.add(currentNode.`val`!!)
                currentNode = currentNode?.next
            }
            var insertCount = 0
            for (count in 0..result.size - 1) {
                val value = result[count]
                if (value >= x) {
                    insertCount = count - 1
                    break
                }
            }
            var count = insertCount + 1
            while (count <= result.size - 1) {
                if (result[count] < x) {
                    result.add(insertCount + 1, result[count])
                    result.removeAt(count + 1)
                    insertCount++
                } else {

                }
                count++
            }
            var currentHead: ListNode? = null
            for (count in 0..result.size - 1) {
                val newNode = ListNode(result[count])
                if (count == 0) {
                    currentHead = newNode
                    currentNode = newNode
                } else {
                    currentNode?.next = newNode
                    currentNode = currentNode?.next
                }
            }
            return currentHead
        }
    }
}