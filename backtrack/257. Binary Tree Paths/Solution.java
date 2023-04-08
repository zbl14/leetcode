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
  public List<String> binaryTreePaths(TreeNode root) {
    List<String> res = new ArrayList<>();
    if (root == null)
      return res;
    dfs(root, res, new ArrayList<>());
    return res;
  }

  private void dfs(TreeNode root, List<String> res, List<String> tmp) {
    if (root == null) {
      return;
    }
    tmp.add(String.valueOf(root.val));
    if (root.left == null && root.right == null) {
      res.add(String.join("->", tmp));
    }
    dfs(root.left, res, tmp);
    dfs(root.right, res, tmp);
    tmp.remove(tmp.size() - 1);
  }
}
