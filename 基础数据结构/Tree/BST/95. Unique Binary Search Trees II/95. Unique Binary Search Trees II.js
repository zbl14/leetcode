/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {number} n
 * @return {TreeNode[]}
 */
var generateTrees = function (n) {
  return helper(1, n);
};

const helper = (start, end) => {
  const res = [];
  if (start > end) res.push(null);
  for (let i = start; i <= end; i++) {
    const leftSubtree = helper(start, i - 1);
    const rightSubtree = helper(i + 1, end);
    for (const left of leftSubtree) {
      for (const right of rightSubtree) {
        let root = new TreeNode(i);
        root.left = left;
        root.right = right;
        res.push(root);
      }
    }
  }
  return res;
};
