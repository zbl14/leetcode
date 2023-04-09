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

// dfs bottom-up, TC = O(n), SC = O(n)
class Solution {
  public List<List<Integer>> findLeaves(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    dfs(root, res);
    return res;
  }

  private int dfs(TreeNode root, List<List<Integer>> res) {
    if (root == null)
      return -1;
    int leftHeight = dfs(root.left, res);
    int rightHeight = dfs(root.right, res);
    int curHeight = Math.max(leftHeight, rightHeight) + 1;
    if (res.size() == curHeight) {
      res.add(new ArrayList<>());
    }
    res.get(curHeight).add(root.val);
    return curHeight;
  }
}