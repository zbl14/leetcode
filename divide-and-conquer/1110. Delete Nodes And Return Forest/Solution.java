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
// divide and conquer, bottom-up
// TC = O(n + m), where n is # of nodes and m is the length of to_delete
// SC = O(n)
class Solution {
  public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
    if (root == null)
      return new ArrayList<>();

    Set<Integer> set = new HashSet<>();
    for (int val : to_delete)
      set.add(val);

    List<TreeNode> forest = new ArrayList<>();
    TreeNode remain = helper(root, set, forest);
    if (remain != null)
      forest.add(remain);
    return forest;
  }

  private TreeNode helper(TreeNode root, Set<Integer> set, List<TreeNode> forest) {
    if (root == null)
      return null;
    root.left = helper(root.left, set, forest);
    root.right = helper(root.right, set, forest);

    if (set.contains(root.val)) {
      if (root.left != null)
        forest.add(root.left);
      if (root.right != null)
        forest.add(root.right);
      root = null;
    }

    return root;
  }
}