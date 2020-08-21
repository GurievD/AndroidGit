package com.example.myapplication21.leetcode

class AddTwoNumbers {
    fun addTwoNumbers(listNode: ListNode?, listNode2: ListNode?, number: Int = 0): ListNode? {
        if (listNode == null && listNode2 == null && number == 0) {
            return null
        }
        val sumNode = (listNode?.nodeValue ?: 0) + (listNode2?.nodeValue ?: 0)
        val sum = sumNode + number
        return ListNode(sum % 10).apply {
            nextNode = addTwoNumbers(listNode?.nextNode, listNode2?.nextNode, sum/10)
        }
    }
}

