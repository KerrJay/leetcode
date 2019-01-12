package com.monkey

/**
  * @author monkey.hu
  * @date created in 2019-01-12 17:41:03
  */
object Q2_AddTwoNumber extends App {

  val l1 = new ListNode(2)
  l1.next = new ListNode(4)
  l1.next.next = new ListNode(3)
  val l2 = new ListNode(5)
  l2.next = new ListNode(6)
  l2.next.next = new ListNode(4)

  printList(addTwoNumbers(l1, l2) )


  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {

    var ll1 = l1
    var ll2 = l2

    var result: ListNode = new ListNode()
    var r: ListNode = result

    var x: Int = 0
    while (ll1!= null || ll2 != null){
      if(ll1 != null && ll2 != null){
        var res =  ll2.x + x + ll1.x
        result.next = new ListNode(res % 10)
        x = res / 10
        ll2 = ll2.next
        ll1 = ll1.next
        result = result.next
      }
      if(ll1 == null && ll2 != null){
        var res =  ll2._x + x
        result.next = new ListNode(res % 10)
        x = res / 10
        ll2 = ll2.next
        result = result.next
      }
      if(ll2 == null && ll1 != null){
        var res =  ll1._x + x
        result.next = new ListNode(res % 10)
        x = res / 10
        ll1 = ll1.next
        result = result.next
      }
    }

    if(x==1) result.next = new ListNode(1)

    r.next
  }

  def printList(l: ListNode) = {
    var ll = l
    while (ll != null){
      println(ll.x)
      ll = ll.next
    }
  }

  class ListNode(var _x: Int = 0){
    var x: Int = _x
    var next: ListNode = null
  }

}
