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
// 104套娃
var diameterOfBinaryTree = function (root) {
  let diameter = 0;

  const longestPath = function (root) {
    if (root === null) return 0;
    const left = longestPath(root.left);
    const right = longestPath(root.right);
    diameter = Math.max(diameter, left + right);
    return 1 + Math.max(left, right);
  };

  longestPath(root, 0);
  return diameter;
};
