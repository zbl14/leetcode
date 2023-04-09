/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
  public TreeNode sortedListToBST(ListNode head) {
    if (head == null)
      return null;
    return helper(head, null);
  }

  private TreeNode helper(ListNode left, ListNode right) {
    if (left == right)
      return null;
    ListNode slow = left;
    ListNode fast = left;
    while (fast != right && fast.next != right) {
      slow = slow.next;
      fast = fast.next.next;
    }
    TreeNode root = new TreeNode(slow.val);
    root.left = helper(left, slow);
    root.right = helper(slow.next, right);
    return root;
  }
}