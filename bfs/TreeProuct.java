package bfs;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
}

class TreeProuct {
  public int product(TreeNode root) {
    if (root == null)
      return 1;
    int res = 1;
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    while (!q.isEmpty()) {
      int size = q.size();
      int curLevelMax = Integer.MIN_VALUE;
      for (int i = 0; i < size; i++) {
        TreeNode cur = q.poll();
        curLevelMax = Math.max(curLevelMax, cur.val);
        if (cur.left != null)
          q.offer(cur.left);
        if (cur.right != null)
          q.offer(cur.right);
      }
      res *= curLevelMax;
    }
    return res;
  }

  public static void main(String[] args) {
    // Create a tree
    TreeNode root = new TreeNode(10);
    root.left = new TreeNode(3);
    root.right = new TreeNode(4);
    root.left.left = new TreeNode(7);
    root.left.right = new TreeNode(10);
    root.right.left = new TreeNode(12);
    root.right.right = new TreeNode(9);
    root.left.left.left = new TreeNode(1);
    root.left.left.right = new TreeNode(6);
    root.right.left.left = new TreeNode(24);
    root.right.left.right = new TreeNode(3);
    root.right.right.right = new TreeNode(7);
    root.left.left.left.left = new TreeNode(12);
    root.right.left.right.left = new TreeNode(5);
    root.right.left.right.right = new TreeNode(4);

    TreeProuct obj = new TreeProuct();

    System.out.println(obj.product(root)); // Output: 138240
  }
}
