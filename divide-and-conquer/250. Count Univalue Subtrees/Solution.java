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
// divide and conquer, bottom-up
class Solution {
  private int res = 0;

  public int countUnivalSubtrees(TreeNode root) {
    dfs(root);
    return res;
  }

  private boolean dfs(TreeNode node) {
    if (node == null)
      return true;
    boolean left = dfs(node.left);
    boolean right = dfs(node.right);
    if (left && right && (node.left == null || node.left.val == node.val)
        && (node.right == null || node.right.val == node.val)) {
      res++;
      return true;
    }
    return false;
  }
}
