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
  double maxAverage = 0;

  public double maximumAverageSubtree(TreeNode root) {
    dfs(root);
    return maxAverage;
  }

  private int[] dfs(TreeNode node) {
    if (node == null)
      return new int[] { 0, 0 };
    int subTreeSum = node.val;
    int sumTreeNodes = 1;
    int left[] = dfs(node.left);
    int right[] = dfs(node.right);
    sumTreeNodes += left[0] + right[0];
    subTreeSum += left[1] + right[1];
    maxAverage = Math.max(maxAverage, (double) subTreeSum / (double) sumTreeNodes);
    return new int[] { sumTreeNodes, subTreeSum };
  }
}