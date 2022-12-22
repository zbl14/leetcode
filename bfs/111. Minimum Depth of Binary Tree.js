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
var minDepth = function (root) {
  if (root === null) return 0;
  let depth = 1;
  const queue = [root];
  while (queue.length) {
    let size = queue.length;
    for (let i = 0; i < size; i++) {
      const cur = queue.shift();
      if (cur.left == null && cur.right == null) return depth;
      if (cur.left) queue.push(cur.left);
      if (cur.right) queue.push(cur.right);
    }
    depth++;
  }
  return depth;
};
