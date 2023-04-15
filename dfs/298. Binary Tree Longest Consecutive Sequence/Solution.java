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
  private int res = 1;

  public int longestConsecutive(TreeNode root) {
    if (root == null)
      return 0;
    dfs(root, null, 0);
    return res;
  }

  private void dfs(TreeNode root, TreeNode prev, int temp) {
    if (root == null)
      return;
    if (prev != null && prev.val + 1 == root.val) {
      temp++;
    } else {
      temp = 1;
    }
    res = Math.max(temp, res);
    prev = root;
    dfs(root.left, prev, temp);
    dfs(root.right, prev, temp);
  }
}