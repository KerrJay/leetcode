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

    //定义指向头结点的变量
    var result: ListNode = new ListNode()
    //定义一个dummy指针来指向头节点，这样可以任意的移动刚开始指向头节点的变量而不用担心头结点的丢失
    var dummy: ListNode = result

    //保存两个一位数相加后结果的十位数上的值：结果大于等于10则为1，否则为0
    var carry: Int = 0
    var sum, x, y: Int = 0
    while (ll1 != null || ll2 != null) {
      //如果当前链表的当前节点为空，则值为null
      if (ll1 != null) x = ll1.x else x = 0
      if (ll2 != null) y = ll2.x else y = 0
      sum = x + y + carry
      result.next = new ListNode(sum % 10)
      carry = if (sum > 9) 1 else 0
      result = result.next

      //链表当前节点不为空，则向后推移一个节点，若为空，则不变
      if (ll1 != null) ll1 = ll1.next
      if (ll2 != null) ll2 = ll2.next
    }
    //当两个链表中的所以节点都相加完之后，判断最后一个相加的结果是否超过10，超过10的时候需要额外增加一个节点来保存进位的结果
    if (carry == 1) result.next = new ListNode(1)
    //返回dummy指针的next，即结果的头指针
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
