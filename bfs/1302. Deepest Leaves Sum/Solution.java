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
// bfs
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

// dfs top down
// class Solution {
// int deepestSum = 0, depth = 0;

// public int deepestLeavesSum(TreeNode root) {
// dfs(root, 0);
// return deepestSum;
// }

// private void dfs(TreeNode node, int currDepth) {
// if (node == null) {
// return;
// }
// if (node.left == null && node.right == null) {
// if (depth < currDepth) {
// deepestSum = node.val;
// depth = currDepth;
// } else if (depth == currDepth) {
// deepestSum += node.val;
// }
// }
// dfs(node.left, currDepth + 1);
// dfs(node.right, currDepth + 1);
// }
// }
