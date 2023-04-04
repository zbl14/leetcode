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

// top down
class Solution {
  public boolean hasPathSum(TreeNode root, int targetSum) {
    return dfs(root, 0, targetSum);
  }

  private boolean dfs(TreeNode root, int sum, int targetSum) {
    if (root == null)
      return false;
    int curSum = sum + root.val;
    if (root.left == null && root.right == null && curSum == targetSum)
      return true;
    boolean left = dfs(root.left, curSum, targetSum);
    boolean right = dfs(root.right, curSum, targetSum);
    return left || right;
  }
}