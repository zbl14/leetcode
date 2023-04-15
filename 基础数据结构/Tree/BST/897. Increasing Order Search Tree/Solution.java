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
  TreeNode cur;

  public TreeNode increasingBST(TreeNode root) {
    TreeNode dummy = new TreeNode();
    cur = dummy;
    traversal(root);
    return dummy.right;
  }

  private void traversal(TreeNode node) {
    if (node == null)
      return;
    traversal(node.left);
    node.left = null;
    cur.right = node;
    cur = node;
    traversal(node.right);
  }
}