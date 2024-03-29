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
  public boolean isPalindrome(ListNode head) {
    if (head == null || head.next == null)
      return true;
    ListNode secondHalf = findMid(head);
    ListNode reversedSecondHalf = reverseList(secondHalf);

    ListNode p1 = head;
    ListNode p2 = reversedSecondHalf;
    while (p1 != null && p2 != null) {
      if (p1.val != p2.val)
        return false;
      p1 = p1.next;
      p2 = p2.next;
    }
    return true;
  }

  private ListNode findMid(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    return slow;
  }

  private ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode cur = head;
    while (cur != null) {
      ListNode tmp = cur.next;
      cur.next = prev;
      prev = cur;
      cur = tmp;
    }
    return prev;
  }
}