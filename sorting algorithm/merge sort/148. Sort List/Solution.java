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
  public ListNode sortList(ListNode head) {
    if (head == null || head.next == null)
      return head;
    ListNode mid = findMid(head);
    ListNode right = sortList(mid.next);
    mid.next = null;
    ListNode left = sortList(head);
    return merge(left, right);
  }

  public ListNode findMid(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  public ListNode merge(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode();
    ListNode cur = dummy;
    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        cur.next = l1;
        l1 = l1.next;
      } else {
        cur.next = l2;
        l2 = l2.next;
      }
      cur = cur.next;
    }
    if (l1 != null)
      cur.next = l1;
    else
      cur.next = l2;
    return dummy.next;
  }
}