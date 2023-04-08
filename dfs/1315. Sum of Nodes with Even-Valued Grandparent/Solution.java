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

// bottom up
class Solution {
  public int sumEvenGrandparent(TreeNode root) {
    return dfs(root, false, false);
  }

  private int dfs(TreeNode root, boolean grandparentIsEven, boolean parentIsEven) {
    if (root == null)
      return 0;
    int sum = 0;
    if (grandparentIsEven)
      sum += root.val;
    boolean isEven = root.val % 2 == 0;
    sum += dfs(root.left, parentIsEven, isEven);
    sum += dfs(root.right, parentIsEven, isEven);
    return sum;
  }
}

// top down
// class Solution {
// int sum = 0;

// public int sumEvenGrandparent(TreeNode root) {
// dfs(root, null, null);
// return sum;
// }

// private void dfs(TreeNode node, TreeNode parent, TreeNode grandparent) {
// if (node == null) {
// return;
// }

// if (grandparent != null && grandparent.val % 2 == 0) {
// sum += node.val;
// }

// dfs(node.left, node, parent);
// dfs(node.right, node, parent);
// }
// }
