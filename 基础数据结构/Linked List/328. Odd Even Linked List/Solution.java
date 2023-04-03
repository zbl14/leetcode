class ListNode {
  int val;
  ListNode next;

  ListNode() {
  }

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}

class Solution {
  public ListNode oddEvenList(ListNode head) {
    if (head == null)
      return null;
    ListNode odd_head = new ListNode();
    ListNode odd = odd_head;
    ListNode even_head = new ListNode();
    ListNode even = even_head;

    int i = 1;
    while (head != null) {
      if (i % 2 == 0) {
        even.next = head;
        even = even.next;
      } else {
        odd.next = head;
        odd = odd.next;
      }
      head = head.next;
      i++;
    }
    odd.next = even_head.next;
    even.next = null;
    return odd_head.next;
  }
}

// class Solution {
// public ListNode oddEvenList(ListNode head) {
// if (head == null)
// return null;
// ListNode odd = head;
// ListNode even = head.next;
// ListNode evenHead = even;
// while (even != null && even.next != null) {
// odd.next = even.next;
// odd = odd.next;
// even.next = odd.next;
// even = even.next;
// }
// odd.next = evenHead;
// return head;
// }
// }