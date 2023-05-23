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
// bfs, TC = O(n), SC = O(n)
class Solution {
  public boolean isCompleteTree(TreeNode root) {
    if (root == null)
      return true;

    boolean foundNull = false;
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);

    while (!q.isEmpty()) {
      TreeNode cur = q.poll();
      if (cur == null) {
        foundNull = true;
      } else {
        if (foundNull)
          return false;
        q.offer(cur.left);
        q.offer(cur.right);
      }
    }
    return true;
  }
}
