package questions

import models.ListNode
import java.math.BigInteger

class Question_2_Add_Two_Numbers {

    companion object {

        fun runQuestion() {
//            Input: l1 = [2,4,3], l2 = [5,6,4]
//            Output: [7,0,8]
            val listNode1 = ListNode()
            val listNode2 = ListNode()
            listNode1.`val` = 2
            listNode1.next = ListNode(4)
            listNode1.next!!.next = ListNode(3)
            listNode2.`val` = 5
            listNode2.next = ListNode(6)
            listNode2.next!!.next = ListNode(4)
            val resultListNode = addTwoNumbers(listNode1, listNode2)
            var tempResultList = resultListNode
            var result = "[" + tempResultList!!.`val`.toString()
            tempResultList = tempResultList.next
            while (null != tempResultList!!.next) {
                result = result + "," + tempResultList.`val`
                tempResultList = tempResultList.next
            }
            result = result + "," + tempResultList.`val`
            result += "]"
            println("Question 2: $result")
        }

        fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
            val number1 = transferToString(l1)
            val number2 = transferToString(l2)
            var total = number1.toBigInteger() + number2.toBigInteger()
            var result: ListNode? = null
            var previous: ListNode? = null
            while (total != BigInteger.ZERO) {
                val node = ListNode((total.mod(10.toBigInteger())).toInt())
                total = total.divide(10.toBigInteger())
                if (result == null) {
                    result = node
                }
                previous?.next = node
                previous = node
            }
            if (result == null) {
                result = ListNode(0)
            }
            return result
        }

        fun transferToString(head: ListNode?): String {
            val result = StringBuilder()
            var current = head
            while (current != null) {
                result.append(current?.`val`)
                current = current?.next
            }
            return result.reversed().toString()
        }

        fun addTwoNumbersCalculateDirectly(l1: ListNode?, l2: ListNode?): ListNode? {
            var tempL1 = l1
            var tempL2 = l2
            var temp: ListNode? = null
            val result = ListNode(-1)
            var tempNode = result
            var overTen = false

            if (tempL1 != null || tempL2 != null) {
                val sum = tempL1!!.`val` + tempL2!!.`val`
                if (sum / 10 > 0) {
                    overTen = true
                }
                temp = ListNode(sum % 10)
                tempNode.next = temp
                tempNode = tempNode.next!!
            }
            while (tempL1!!.next != null || tempL2!!.next != null) {
                if (tempL1!!.next != null && tempL2!!.next != null) {
                    tempL1 = tempL1!!.next
                    tempL2 = tempL2!!.next
                    val sum: Int
                    if (overTen) {
                        sum = tempL1!!.`val` + tempL2!!.`val` + 1
                    } else {
                        sum = tempL1!!.`val` + tempL2!!.`val`
                    }
                    overTen = false
                    if (sum / 10 > 0) {
                        overTen = true
                    }
                    temp = ListNode(sum % 10)
                    tempNode.next = temp
                    tempNode = tempNode.next!!
                } else if (tempL1!!.next != null) {
                    tempL1 = tempL1!!.next
                    val sum: Int
                    if (overTen) {
                        sum = tempL1!!.`val` + 1
                    } else {
                        sum = tempL1!!.`val`
                    }
                    overTen = false
                    if (sum / 10 > 0) {
                        overTen = true
                    }
                    temp = ListNode(sum % 10)
                    tempNode.next = temp
                    tempNode = tempNode.next!!
                } else if (tempL2!!.next != null) {
                    tempL2 = tempL2!!.next
                    val sum: Int
                    if (overTen) {
                        sum = tempL2!!.`val` + 1
                    } else {
                        sum = tempL2!!.`val`
                    }
                    overTen = false
                    if (sum / 10 > 0) {
                        overTen = true
                    }
                    temp = ListNode(sum % 10)
                    tempNode.next = temp
                    tempNode = tempNode.next!!
                }
            }

            if (overTen) {
                temp = ListNode(1)
                tempNode.next = temp
            }

            return result.next
        }
    }
}