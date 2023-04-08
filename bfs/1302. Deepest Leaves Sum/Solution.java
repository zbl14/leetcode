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
  public int deepestLeavesSum(TreeNode root) {
    int levelSum = 0;
    Queue<TreeNode> q = new LinkedList<>();
    if (root != null)
      q.offer(root);
    while (!q.isEmpty()) {
      int size = q.size();
      levelSum = 0;
      for (int i = 0; i < size; i++) {
        TreeNode cur = q.poll();
        if (cur.left == null && cur.right == null)
          levelSum += cur.val;
        if (cur.left != null)
          q.offer(cur.left);
        if (cur.right != null)
          q.offer(cur.right);
      }
    }
    return levelSum;
  }
}