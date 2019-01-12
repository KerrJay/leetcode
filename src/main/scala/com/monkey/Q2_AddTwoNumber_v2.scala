package com.monkey

/**
  * @author monkey.hu
  * @date created in 2019-01-12 19:14:30
  */
object Q2_AddTwoNumber_v2 extends App {
  val l1 = new ListNode(2)
  l1.next = new ListNode(4)
  l1.next.next = new ListNode(3)
  val l2 = new ListNode(5)
  l2.next = new ListNode(6)
  l2.next.next = new ListNode(4)

  printList(addTwoNumbers(l1, l2))


  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {

    var ll1 = l1
    var ll2 = l2

    var result: ListNode = new ListNode()
    var dummy: ListNode = result

    var carry: Int = 0
    var sum, x, y: Int = 0
    while (ll1 != null || ll2 != null) {
      if (ll1 != null) x = ll1.x else x = 0
      if (ll2 != null) y = ll2.x else y = 0
      sum = x + y + carry
      result.next = new ListNode(sum % 10)
      carry = if (sum > 9) 1 else 0
      result = result.next

      if (ll1 != null) ll1 = ll1.next
      if (ll2 != null) ll2 = ll2.next
    }

    if (carry == 1) result.next = new ListNode(1)

    dummy.next
  }

  def printList(l: ListNode) = {
    var ll = l
    while (ll != null) {
      println(ll.x)
      ll = ll.next
    }
  }

  class ListNode(var _x: Int = 0) {
    var x: Int = _x
    var next: ListNode = null
  }

}
