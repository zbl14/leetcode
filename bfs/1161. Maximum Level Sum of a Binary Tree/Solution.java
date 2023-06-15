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
  public int maxLevelSum(TreeNode root) {
    int res = 0;
    int max = Integer.MIN_VALUE;
    int curLevel = 0;
    Queue<TreeNode> q = new LinkedList<>();
    if (root != null)
      q.offer(root);
    while (!q.isEmpty()) {
      int size = q.size();
      curLevel++;
      int levelSum = 0;
      for (int i = 0; i < size; i++) {
        TreeNode curNode = q.poll();
        levelSum += curNode.val;
        if (curNode.left != null)
          q.offer(curNode.left);
        if (curNode.right != null)
          q.offer(curNode.right);
      }
      if (levelSum > max) {
        max = levelSum;
        res = curLevel;
      }
    }
    return res;
  }
}