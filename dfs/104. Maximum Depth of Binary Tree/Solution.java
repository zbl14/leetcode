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

// dfs bottom up
class Solution {
  private int res = 0;

  public int maxDepth(TreeNode root) {
    dfs(root, 0);
    return res;
  }

  private void dfs(TreeNode root, int depth) {
    if (root == null)
      return;
    depth++;
    if (root.left == null && root.right == null) {
      if (res < depth)
        res = depth;
    }
    dfs(root.left, depth);
    dfs(root.right, depth);
  }
}

// dfs top down
// class Solution{
// public int maxDepth(TreeNode root){
// if(root == null) return 0;
// int left = maxDepth(root.left);
// int right = maxDepth(root.right);
// return Math.max(left, right) + 1;
// }
// }

// bfs
// class Solution {
// public int maxDepth(TreeNode root) {
// if (root == null)
// return 0;
// int res = 0;
// Queue<TreeNode> q = new LinkedList<>();
// q.offer(root);
// while (!q.isEmpty()) {
// int size = q.size();
// for (int i = 0; i < size; i++) {
// TreeNode cur = q.poll();
// if (cur.left != null)
// q.offer(cur.left);
// if (cur.right != null)
// q.offer(cur.right);
// }
// res++;
// }
// return res;
// }
// }