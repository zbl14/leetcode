class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {
  };

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}

class Solution {
  double minDiff = Double.MAX_VALUE;
  int res;

  public int closestValue(TreeNode root, double target) {
    helper(root, target);
    return res;
  }

  private void helper(TreeNode root, double target) {
    if (root == null)
      return;
    helper(root.left, target);
    if (Math.abs(root.val - target) < minDiff) {
      minDiff = Math.abs(root.val - target);
      res = root.val;
    }
    helper(root.right, target);
  }
}

// class Solution {
// public int closestValue(TreeNode root, double target) {
// double minDiff = Double.MAX_VALUE;
// int res = root.val;
// Stack<TreeNode> stack = new Stack<>();
// while (root != null || !stack.isEmpty()) {
// while (root != null) {
// stack.push(root);
// root = root.left;
// }
// root = stack.pop();
// if (Math.abs(root.val - target) < minDiff) {
// minDiff = Math.abs(root.val - target);
// res = root.val;
// }
// root = root.right;
// }
// return res;
// }
// }