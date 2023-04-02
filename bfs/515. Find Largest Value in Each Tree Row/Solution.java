import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
  public List<Integer> largestValues(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    Queue<TreeNode> q = new LinkedList<>();
    if (root != null)
      q.offer(root);
    while (!q.isEmpty()) {
      int size = q.size();
      int maxInRow = Integer.MIN_VALUE;
      for (int i = 0; i < size; i++) {
        TreeNode cur = q.poll();
        maxInRow = Math.max(maxInRow, cur.val);
        if (cur.left != null)
          q.offer(cur.left);
        if (cur.right != null)
          q.offer(cur.right);
      }
      res.add(maxInRow);
    }
    return res;
  }
}