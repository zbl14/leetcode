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
  private int maxLen = 0;

  public int longestConsecutive(TreeNode root) {
    dfs(root);
    return maxLen;
  }

  private int[] dfs(TreeNode root) {
    if (root == null)
      return new int[] { 0, 0 };

    int increase = 1;
    int decrease = 1;
    if (root.left != null) {
      int[] left = dfs(root.left);
      if (root.val == root.left.val + 1) {
        decrease = left[1] + 1;
      } else if (root.val == root.left.val - 1) {
        increase = left[0] + 1;
      }
    }

    if (root.right != null) {
      int[] right = dfs(root.right);
      if (root.val == root.right.val + 1) {
        decrease = Math.max(decrease, right[1] + 1);
      } else if (root.val == root.right.val - 1) {
        increase = Math.max(increase, right[0] + 1);
      }
    }

    maxLen = Math.max(maxLen, decrease + increase - 1);
    return new int[] { increase, decrease };
  }
}