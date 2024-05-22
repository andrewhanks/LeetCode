package questions

import models.ListNode

class Question_24_Swap_Nodes_in_Pairs {

    companion object {

        fun runQuestion() {
//            Input: head = [1,2,3,4]
//            Output: [2,1,4,3]
            val listNode1 = ListNode(1)
            val listNode2 = ListNode(2)
            listNode1.next = listNode2
            val listNode3 = ListNode(3)
            listNode2.next = listNode3
            val listNode4 = ListNode(4)
            listNode3.next = listNode4
            val head = listNode1
            val resultListNode = swapPairs(head)
            var tempResultList: ListNode? = resultListNode
            var result = "[" + tempResultList!!.`val`.toString()
            tempResultList = tempResultList!!.next
            while (null != tempResultList!!.next) {
                result = result + "," + tempResultList.`val`
                tempResultList = tempResultList.next
            }
            result = result + "," + tempResultList.`val`
            result += "]"
            println("Question 24: $result")
        }

        fun swapPairs(head: ListNode?): ListNode? {
            if (head == null) {
                return null
            }
            val result: MutableList<ListNode> = mutableListOf()
            var current = head
            while (current != null) {
                result.add(current)
                current = current?.next
            }
            var count = 0
            while (count < result.size - 1) {
                val temp = result[count]
                result[count] = result[count + 1]
                result[count + 1] = temp
                count += 2
            }
            for (count in 1..result.size - 1) {
                result[count - 1]?.next = result[count]
            }
            result[result.size - 1]?.next = null
            return result[0]
        }

        fun swapPairsWithoutList(head: ListNode?): ListNode? {
            var current = head
            var previous: ListNode? = null
            var count = 0
            var newHead = head
            while (current != null) {
                val next = current?.next
                if (next == null && count % 2 == 0) {
                    return newHead
                }
                //println("previous = ${previous?.`val`}, current = ${current?.`val`}, next = ${next?.`val`}")
                if (count % 2 == 0) {
                    if (count == 0) {
                        newHead = next
                    }
                    val nextNext = next?.next
                    current?.next = nextNext
                    previous = current
                    current = next
                } else {
                    val nextNext = next?.next
                    current?.next = previous
                    if (nextNext == null) {
                        previous?.next = next
                    } else {
                        previous?.next = nextNext
                    }
                    previous = current
                    current = next
                }
                count++
            }
            return newHead
        }

        fun swapPairsWithList(head: ListNode?): ListNode? {
            val result: MutableList<ListNode?> = mutableListOf()
            var current = head
            while (current != null) {
                result.add(ListNode(current?.`val`!!))
                current = current?.next
            }
            var newHead = head
            for (count in 0..result.size - 1) {
                if (count % 2 == 0) {
                    if (count + 3 <= result.size - 1) {
                        result[count]?.next = result[count + 3]
                    } else if (count + 2 <= result.size - 1) {
                        result[count]?.next = result[count + 2]
                    }
                } else {
                    if (count == 1) {
                        newHead = result[count]
                    }
                    result[count]?.next = result[count - 1]
                }
            }
            return newHead
        }
    }
}