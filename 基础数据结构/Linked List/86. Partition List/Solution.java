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
  public ListNode partition(ListNode head, int x) {
    if (head == null)
      return null;
    ListNode before_head = new ListNode();
    ListNode before = before_head;
    ListNode after_head = new ListNode();
    ListNode after = after_head;

    while (head != null) {
      if (head.val < x) {
        before.next = head;
        before = before.next;
      } else {
        after.next = head;
        after = after.next;
      }
      head = head.next;
    }
    before.next = after_head.next;
    after.next = null;
    return before_head.next;
  }
}