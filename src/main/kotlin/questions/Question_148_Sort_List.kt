package questions

import models.ListNode

class Question_148_Sort_List {

    companion object {

        fun runQuestion() {
            val listNode1 = ListNode(-1)
            val listNode2 = ListNode(5)
            listNode1.next = listNode2
            val listNode3 = ListNode(3)
            listNode2.next = listNode3
            val listNode4 = ListNode(4)
            listNode3.next = listNode4
            val listNode5 = ListNode(0)
            listNode4.next = listNode5
            val resultListNode = sortList(listNode1)
            var tempResultList: ListNode? = resultListNode
            var result = "[" + tempResultList!!.`val`.toString()
            tempResultList = tempResultList!!.next
            while (null != tempResultList!!.next) {
                result = result + "," + tempResultList.`val`
                tempResultList = tempResultList.next
            }
            result = result + "," + tempResultList.`val`
            result += "]"
            println("Question 148: $result")
        }

        fun sortList(head: ListNode?): ListNode? {
            var currentNode = head
            val arrayForSort: MutableList<Int> = mutableListOf()
            while (currentNode != null && currentNode?.`val` != null) {
                arrayForSort.add(currentNode!!.`val`)
                currentNode = currentNode?.next
            }
            arrayForSort.sort()
            println(arrayForSort)
            currentNode = head
            arrayForSort.forEachIndexed { index, value ->
                currentNode?.`val` = value
                currentNode = currentNode?.next
            }
            return head
        }
    }
}