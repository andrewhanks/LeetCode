package questions

import models.ListNode

class Question_82_Remove_Duplicates_from_Sorted_List_II {

    companion object {

        fun runQuestion() {
//            Input: head = [1,2,3,3,4,4,5]
//            Output: [1,2,5]
            val listNode = ListNode()
            listNode.`val` = 1
            listNode.next = ListNode(2)
            listNode.next!!.next = ListNode(3)
            listNode.next!!.next!!.next = ListNode(3)
            listNode.next!!.next!!.next!!.next = ListNode(4)
            listNode.next!!.next!!.next!!.next!!.next = ListNode(4)
            listNode.next!!.next!!.next!!.next!!.next!!.next = ListNode(5)
            val resultListNode = deleteDuplicatesMap(listNode)
            var tempResultList = resultListNode
            var result = "[" + tempResultList!!.`val`.toString()
            tempResultList = tempResultList.next
            while (null != tempResultList!!.next) {
                result = result + "," + tempResultList.`val`
                tempResultList = tempResultList.next
            }
            result = result + "," + tempResultList.`val`
            result += "]"
            println("Question 82: $result")
        }

        fun deleteDuplicatesMap(head: ListNode?): ListNode? {
            if (head == null) {
                return head
            }
            val result: MutableMap<Int?, Int> = mutableMapOf()
            var currentNode = head
            while (currentNode != null) {
                if (result.contains(currentNode?.`val`)) {
                    result[currentNode?.`val`] = result[currentNode?.`val`]!! + 1
                } else {
                    result.put(currentNode?.`val`, 1)
                }
                currentNode = currentNode?.next
            }
            var currentHead: ListNode? = null
            currentNode = null
            for (item in result) {
                val key = item.key
                val value = item.value
                if (value == 1) {
                    val newNode = ListNode(key!!)
                    if (currentHead == null) {
                        currentHead = newNode
                        currentNode = newNode
                    } else {
                        currentNode?.next = newNode
                        currentNode = currentNode?.next
                    }
                }
            }
            return currentHead
        }

        fun deleteDuplicatesPointers(head: ListNode?): ListNode? {
            if (head == null || head?.next == null) {
                return head
            }
            var currentValue: Int? = -1000
            var previousNode: ListNode? = null
            var currentHead: ListNode? = null
            var currentNode = head
            var nextNode = head?.next
            while (currentNode != null) {
                if (currentNode?.`val` == nextNode?.`val` || currentValue == currentNode?.`val`) {
                    currentValue = currentNode?.`val`
                } else {
                    if (currentHead == null) {
                        currentHead = currentNode
                        previousNode = currentNode
                    } else {
                        previousNode?.next = currentNode
                        previousNode = previousNode?.next
                    }
                    currentValue = currentNode?.`val`
                }
                currentNode = currentNode?.next
                if (nextNode != null) {
                    nextNode = nextNode?.next
                }
            }
            previousNode?.next = null
            return currentHead
        }

        fun deleteDuplicatesList(head: ListNode?): ListNode? {
            val result: MutableList<ListNode?> = mutableListOf()
            var current = head
            while (current != null) {
                result.add(current)
                current = current?.next
            }
//             result.forEach {
//                 println("result 1 = ${it?.`val`}")
//             }
            var currentValue = head?.`val`
            var count = 0
            var sameValueCount = 0
            while (count <= result.size - 1) {
                // println("=================")
                if (currentValue == result[count]?.`val`) {
                    sameValueCount++
                } else {
                    if (sameValueCount > 1) {
                        for (itemNumber in 0..sameValueCount - 1) {
                            // println("itemNumber = $itemNumber")
                            result.removeAt(count - sameValueCount)
                        }
                        count = count - sameValueCount
                        // result.forEach {
                        //     println("result = ${it?.`val`}")
                        // }
                    }
                    currentValue = result[count]?.`val`
                    sameValueCount = 1
                    // println(result.size)
                }
                // println("currentValue = $currentValue, result[count]?.`val` = ${result[count]?.`val`}, sameValueCount = $sameValueCount")
                count++
            }
            if (sameValueCount > 1) {
                val lastRemovedIndex = result.size - sameValueCount
                for (itemNumber in 0..sameValueCount - 1) {
                    result.removeAt(lastRemovedIndex)
                }
            }
            for (count in 1..result.size - 1) {
                result[count - 1]?.next = result[count]
            }
            if (!result.isEmpty()) {
                result[result.size - 1]?.next = null
            }
            if (result.isEmpty()) {
                return null
            }
            return result[0]
        }
    }
}