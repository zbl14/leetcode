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

// 2 pass, TC = O(n), SC = O(1)
class Solution {
  public ListNode swapNodes(ListNode head, int k) {
    int listLength = 0;
    ListNode front = null;
    ListNode end = null;
    ListNode cur = head;

    while (cur != null) {
      listLength++;
      if (listLength == k) {
        front = cur;
      }
      cur = cur.next;
    }

    end = head;
    for (int i = 1; i <= listLength - k; i++) {
      end = end.next;
    }

    int temp = front.val;
    front.val = end.val;
    end.val = temp;
    return head;
  }
}