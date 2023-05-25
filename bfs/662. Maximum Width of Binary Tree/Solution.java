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
// TC = O(n)
// SC = O(w), where w is the maximum width of a tree, worse scenario is O(n)
class Solution {
  public int widthOfBinaryTree(TreeNode root) {
    if (root == null)
      return 0;
    Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
    q.offer(new Pair<>(root, 0));

    int res = 0;
    while (!q.isEmpty()) {
      int size = q.size();
      int start = 0;
      int end = 0;
      for (int i = 0; i < size; i++) {
        Pair<TreeNode, Integer> cur = q.poll();
        if (i == 0)
          start = cur.getValue();
        if (i == size - 1)
          end = cur.getValue();
        TreeNode node = cur.getKey();
        if (node.left != null)
          q.offer(new Pair<>(node.left, 2 * cur.getValue()));
        if (node.right != null)
          q.offer(new Pair<>(node.right, 2 * cur.getValue() + 1));
      }
      res = Math.max(res, end - start + 1);
    }
    return res;
  }
}