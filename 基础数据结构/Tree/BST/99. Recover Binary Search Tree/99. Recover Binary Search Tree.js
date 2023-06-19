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
 * @return {void} Do not return anything, modify root in-place instead.
 */
var recoverTree = function (root) {
  let first = null,
    second = null;
  let prev = new TreeNode(-Infinity);
  const stack = [];
  while (root !== null || stack.length !== 0) {
    while (root !== null) {
      stack.push(root);
      root = root.left;
    }
    root = stack.pop();
    if (root.val <= prev.val) {
      if (first === null) {
        first = prev;
        second = root;
      } else {
        second = root;
      }
    }
    prev = root;
    root = root.right;
  }
  let tmp = first.val;
  first.val = second.val;
  second.val = tmp;
};
