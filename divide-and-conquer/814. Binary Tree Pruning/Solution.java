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
// bottom-up
// class Solution {
// public TreeNode pruneTree(TreeNode root) {
// return hasOne(root) ? root : null;
// }

// private boolean hasOne(TreeNode node){
// if (node == null) return false;
// boolean leftHasOne = hasOne(node.left);
// boolean rightHasOne = hasOne(node.right);
// if(!leftHasOne) node.left = null;
// if(!rightHasOne) node.right = null;
// return node.val == 1 || leftHasOne || rightHasOne;
// }
// }

// Top-down, divide and conquer
class Solution {
  public TreeNode pruneTree(TreeNode root) {
    if (root == null) {
      return null;
    }

    TreeNode left = pruneTree(root.left);
    TreeNode right = pruneTree(root.right);

    root.left = left;
    root.right = right;

    if (root.val == 0 && left == null && right == null) {
      return null;
    }

    return root;
  }
}
