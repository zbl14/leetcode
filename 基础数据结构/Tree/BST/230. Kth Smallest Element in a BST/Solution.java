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
// class Solution {
// private PriorityQueue<Integer> pq;
// public int kthSmallest(TreeNode root, int k) {
// pq = new PriorityQueue<>((a,b) -> b - a);
// helper(root);
// while(pq.size() > k){
// pq.poll();
// }
// return pq.poll();
// }

// private void helper(TreeNode root){
// if(root == null) return;
// helper(root.left);
// pq.offer(root.val);
// helper(root.right);
// }
// }

// class Solution {
// int count = 0;
// int res;
// public int kthSmallest(TreeNode root, int k) {
// helper(root, k);
// return res;
// }

// private void helper(TreeNode root, int k){
// if(root == null) return;
// helper(root.left, k);
// count++;
// if(count == k) {
// res = root.val;
// return;
// };
// helper(root.right, k);
// }
// }

class Solution {
  public int kthSmallest(TreeNode root, int k) {
    Stack<TreeNode> stack = new Stack<>();
    int count = 0;
    while (root != null || !stack.isEmpty()) {
      while (root != null) {
        stack.push(root);
        root = root.left;
      }
      root = stack.pop();
      count++;
      if (count == k)
        return root.val;
      root = root.right;
    }
    return -1;
  }
}
