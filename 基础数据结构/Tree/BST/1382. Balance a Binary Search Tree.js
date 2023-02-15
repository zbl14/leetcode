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
 * @return {TreeNode}
 */
var balanceBST = function (root) {
  const res = [];
  inorderTraversal(root, res);
  return buildTree(res, 0, res.length - 1);
};

const inorderTraversal = (root, res) => {
  if (root === null) return;
  inorderTraversal(root.left, res);
  res.push(root.val);
  inorderTraversal(root.right, res);
};

// same as leetcode 108, build a balance tree from sorted array
const buildTree = (arr, start, end) => {
  if (start > end) return null;
  const mid = start + ((end - start) >> 1);
  let node = new TreeNode(arr[mid]);
  node.left = buildTree(arr, start, mid - 1);
  node.right = buildTree(arr, mid + 1, end);
  return node;
};
