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
// Top down
class Solution {
  private int res = 0;

  public int goodNodes(TreeNode root) {
    if (root == null)
      return res;
    int curMax = root.val;
    dfs(root, curMax);
    return res;
  }

  private void dfs(TreeNode root, int curMax) {
    if (root == null)
      return;
    if (root.val >= curMax) {
      res++;
      curMax = root.val;
    }
    dfs(root.left, curMax);
    dfs(root.right, curMax);
  }
}