package questions

import models.ListNode

class Question_23_Merge_k_Sorted_Lists {

    companion object {

        fun runQuestion() {
            var listNodeArray: Array<ListNode?> = Array(3) { null }
            val listNode1 = ListNode(1)
            listNode1.next = ListNode(4)
            listNode1.next!!.next = ListNode(5)
            listNodeArray[0] = listNode1
            val listNode2 = ListNode(1)
            listNode2.next = ListNode(3)
            listNode2.next!!.next = ListNode(4)
            listNodeArray[1] = listNode2
            val listNode3 = ListNode(2)
            listNode3.next = ListNode(6)
            listNodeArray[2] = listNode3
            listNodeArray = arrayOf(listNode1, listNode2, listNode3)
            val resultListNode = mergeKLists(listNodeArray)
            var tempResultList: ListNode? = resultListNode
            var result = "[" + tempResultList!!.`val`.toString()
            tempResultList = tempResultList!!.next
            while (null != tempResultList!!.next) {
                result = result + "," + tempResultList.`val`
                tempResultList = tempResultList.next
            }
            result = result + "," + tempResultList.`val`
            result += "]"
            println("Question 23: $result")
        }

        fun mergeKLists(lists: Array<ListNode?>): ListNode? {
            if (lists.isEmpty()) {
                return null
            } else {
                var listNode = lists[0]
                for (i in 1..lists.size - 1) {
                    listNode = insertSecondListToFirstList(listNode, lists[i])
                }
                return listNode
            }
        }

        private fun insertSecondListToFirstList(firstListNode: ListNode?, secondListNode: ListNode?): ListNode? {
            if (null == firstListNode) {
                return secondListNode
            }
            if (null == secondListNode) {
                return firstListNode
            }
            var resultListNode: ListNode? = null
            var previousNode: ListNode? = null
            var currentFirstElement = firstListNode
            var currentSecondElement = secondListNode

            run addLoop@{
                do {
                    if (null == currentFirstElement) {
                        previousNode!!.next = currentSecondElement
                        return@addLoop
                    }
                    if (currentSecondElement!!.`val` < currentFirstElement!!.`val`) {
                        val insertNode = ListNode(currentSecondElement!!.`val`)
                        if (null == previousNode) {
                            insertNode.next = firstListNode
                            previousNode = insertNode
                            resultListNode = insertNode
                        } else {
                            previousNode!!.next = insertNode
                            insertNode.next = currentFirstElement
                            previousNode = insertNode
                        }
                        currentSecondElement = currentSecondElement!!.next
                    } else {
                        previousNode = currentFirstElement
                        currentFirstElement = currentFirstElement!!.next

                    }
                } while (null != currentSecondElement)
            }

            if (null == resultListNode) {
                resultListNode = firstListNode
            }

            return resultListNode
        }
    }
}