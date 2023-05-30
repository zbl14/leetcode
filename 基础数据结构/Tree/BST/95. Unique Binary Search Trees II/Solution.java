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
  public List<TreeNode> generateTrees(int n) {
    if (n == 0)
      return new ArrayList<TreeNode>();
    return backtrack(1, n);
  }

  private List<TreeNode> backtrack(int start, int end) {
    List<TreeNode> res = new ArrayList<>();
    if (start > end)
      res.add(null);
    for (int i = start; i <= end; i++) {
      List<TreeNode> leftList = backtrack(start, i - 1);
      List<TreeNode> rightList = backtrack(i + 1, end);
      for (TreeNode left : leftList) {
        for (TreeNode right : rightList) {
          TreeNode root = new TreeNode(i);
          root.left = left;
          root.right = right;
          res.add(root);
        }
      }
    }
    return res;
  }
}