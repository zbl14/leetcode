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
  public void recoverTree(TreeNode root) {
    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = null;
    Stack<TreeNode> stack = new Stack<>();

    while (root != null || !stack.isEmpty()) {
      while (root != null) {
        stack.push(root);
        root = root.left;
      }
      root = stack.pop();
      if (prev != null && root.val <= prev.val) {
        if (first == null) {
          first = prev;
          second = root;
        } else {
          second = root;
        }
      }
      prev = root;
      root = root.right;
    }

    int tmp = first.val;
    first.val = second.val;
    second.val = tmp;
  }
}