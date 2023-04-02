import java.util.LinkedList;
import java.util.Queue;

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
  public int maxDepth(TreeNode root) {
    if (root == null)
      return 0;
    int res = 0;
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    while (!q.isEmpty()) {
      int size = q.size();
      for (int i = 0; i < size; i++) {
        TreeNode cur = q.poll();
        if (cur.left != null)
          q.offer(cur.left);
        if (cur.right != null)
          q.offer(cur.right);
      }
      res++;
    }
    return res;
  }
}

// recursive
// class Solution {
// public int maxDepth(TreeNode root) {
// if (root == null)
// return 0;
// return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
// }
// }