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
  public TreeNode insertIntoBST(TreeNode root, int val) {
    TreeNode cur = root;
    TreeNode newNode = new TreeNode(val);
    if (cur == null) {
      cur = newNode;
      return cur;
    }
    TreeNode prev = null;
    while (cur != null) {
      prev = cur;
      if (cur.val < val)
        cur = cur.right;
      else
        cur = cur.left;
    }
    if (prev.val < val)
      prev.right = newNode;
    else
      prev.left = newNode;
    return root;
  }
}

// class Solution {
// public TreeNode insertIntoBST(TreeNode root, int val) {
// if(root == null){
// root = new TreeNode(val);
// return root;
// }
// if(val < root.val) {
// root.left = insertIntoBST(root.left, val);
// } else {
// root.right = insertIntoBST(root.right, val);
// }
// return root;
// }
// }
