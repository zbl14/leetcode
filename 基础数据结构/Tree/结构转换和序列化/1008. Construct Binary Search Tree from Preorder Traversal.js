/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {number[]} preorder
 * @return {TreeNode}
 */
// leetcode 449的其中一部分
var bstFromPreorder = function (preorder) {
  const dfs = function (q, lower, upper) {
    if (q.length === 0) return null;
    const val = q[0];
    if (val < lower || val > upper) return null;
    q.shift();
    let root = new TreeNode(val);
    root.left = dfs(q, lower, val);
    root.right = dfs(q, val, upper);
    return root;
  };
  return dfs(preorder, -Infinity, Infinity);
};
