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
// TC = O(nlogn ~ n^2), SC = O(n)
class Solution {
  public TreeNode constructMaximumBinaryTree(int[] nums) {
    return build(nums, 0, nums.length);
  }

  private TreeNode build(int[] nums, int l, int r) {
    if (l == r)
      return null;
    int maxIdx = findMax(nums, l, r);
    TreeNode root = new TreeNode(nums[maxIdx]);
    root.left = build(nums, l, maxIdx);
    root.right = build(nums, maxIdx + 1, r);
    return root;
  }

  private int findMax(int[] nums, int l, int r) {
    int maxIdx = l;
    for (int i = l; i < r; i++) {
      if (nums[maxIdx] < nums[i]) {
        maxIdx = i;
      }
    }
    return maxIdx;
  }
}