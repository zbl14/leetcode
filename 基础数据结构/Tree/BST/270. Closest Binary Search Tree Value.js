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
 * @param {number} target
 * @return {number}
 */
var closestValue = function (root, target) {
  const res = dfs(root, target, Infinity, 0);
  return res;
};

const dfs = function (root, target, min, res) {
  if (root === null) return res;
  if (Math.abs(root.val - target) < min) {
    min = Math.abs(root.val - target);
    res = root.val;
  }
  if (root.val > target) return dfs(root.left, target, min, res);
  else return dfs(root.right, target, min, res);
};
