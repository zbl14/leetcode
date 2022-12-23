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
var maxDepth = function (root) {
  if (!root) return 0;
  let depth = 0;
  const q = [root];
  while (q.length) {
    let size = q.length;
    for (let i = 0; i < size; i++) {
      const cur = q.shift();
      if (cur.left) q.push(cur.left);
      if (cur.right) q.push(cur.right);
    }
    depth++;
  }
  return depth;
};
