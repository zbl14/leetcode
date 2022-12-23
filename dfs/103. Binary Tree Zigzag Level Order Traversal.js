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
 * @return {number[][]}
 */
var zigzagLevelOrder = function (root) {
  let res = [];
  dfs(root, res, 0);
  return res;
};

const dfs = (root, res, height) => {
  if (!root) return [];
  if (height >= res.length) res.push([]);
  height % 2 == 0 ? res[height].push(root.val) : res[height].unshift(root.val);
  if (root.left) dfs(root.left, res, height + 1);
  if (root.right) dfs(root.right, res, height + 1);
};
