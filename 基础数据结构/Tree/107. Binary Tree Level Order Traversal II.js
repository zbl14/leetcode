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
var levelOrderBottom = function (root) {
  const res = [];
  const q = [];
  if (root !== null) q.push(root);
  while (q.length !== 0) {
    const size = q.length;
    const curLevel = [];
    for (let i = 0; i < size; i++) {
      const cur = q.shift();
      curLevel.push(cur.val);
      if (cur.left !== null) q.push(cur.left);
      if (cur.right !== null) q.push(cur.right);
    }
    res.unshift(curLevel);
  }
  return res;
};
