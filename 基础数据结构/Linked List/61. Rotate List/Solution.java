/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
  public ListNode rotateRight(ListNode head, int k) {
    if (head == null)
      return null;
    if (head.next == null)
      return head;

    ListNode old_tail = head;
    int n;
    for (n = 1; old_tail.next != null; n++) {
      old_tail = old_tail.next;
    }
    old_tail.next = head;

    ListNode new_tail = head;
    for (int i = 1; i < n - k % n; i++) {
      new_tail = new_tail.next;
    }
    ListNode new_head = new_tail.next;

    new_tail.next = null;

    return new_head;
  }
}

// n = 1
// 1->2->3->4->5
// after 1st loop, n = 5,
// 5->1, form a ring;
// k % n = 2, 2nd loop, new_tail point to 3
// create new head, 4->5->1->2->3, because of ring 3->4
// break the ring, new_tail.next = null
