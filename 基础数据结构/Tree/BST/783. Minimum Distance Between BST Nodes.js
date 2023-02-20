/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number}
 */
// recursive
var minDiffInBST = function (root) {
  let minDiff = Infinity;
  let prev = Infinity;

  function traverse(node) {
    if (node === null) {
      return;
    }
    traverse(node.left);
    minDiff = Math.min(Math.abs(node.val - prev), minDiff);
    prev = node.val;
    traverse(node.right);
  }

  traverse(root);
  return minDiff;
};

// iterative
var minDiffInBST = function (root) {
  let minDiff = Infinity;
  let prev = Infinity;
  let stack = [];
  while (root !== null || stack.length !== 0) {
    while (root !== null) {
      stack.push(root);
      root = root.left;
    }
    root = stack.pop();
    minDiff = Math.min(Math.abs(root.val - prev), minDiff);
    prev = root.val;
    root = root.right;
  }
  return minDiff;
};
