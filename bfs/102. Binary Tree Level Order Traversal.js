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
var levelOrder = function (root) {
  if (!root) return [];
  const q = [root];
  const res = [];
  while (q.length) {
    const size = q.length;
    const curLevel = [];
    for (let i = 0; i < size; i++) {
      const cur = q.shift();
      if (cur.left) q.push(cur.left);
      if (cur.right) q.push(cur.right);
      curLevel.push(cur.val);
    }
    res.push(curLevel);
  }
  return res;
};
