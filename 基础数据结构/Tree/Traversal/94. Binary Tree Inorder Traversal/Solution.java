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
// recursive
// class Solution {
// public List<Integer> inorderTraversal(TreeNode root) {
// List<Integer> res = new ArrayList<>();
// dfs(root, res);
// return res;
// }

// private void dfs(TreeNode root, List<Integer> res){
// if(root == null) return;
// dfs(root.left, res);
// res.add(root.val);
// dfs(root.right, res);
// }
// }

// iterative
class Solution {
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    while (root != null || !stack.isEmpty()) {
      while (root != null) {
        stack.push(root);
        root = root.left;
      }
      root = stack.pop();
      res.add(root.val);
      root = root.right;
    }
    return res;
  }
}