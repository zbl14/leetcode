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
var verticalOrder = function (root) {
  const res = [];
  const q = [];
  const posMap = new Map();
  const colToNode = new Map();
  if (root !== null) q.push(root);
  posMap.set(root, 0);
  let minCol = 0;
  while (q.length !== 0) {
    const cur = q.shift();
    let col = posMap.get(cur);
    if (!colToNode.has(col)) colToNode.set(col, []);
    colToNode.get(col).push(cur.val);
    if (cur.left !== null) {
      q.push(cur.left);
      posMap.set(cur.left, col - 1);
    }
    if (cur.right !== null) {
      q.push(cur.right);
      posMap.set(cur.right, col + 1);
    }
    minCol = Math.min(col, minCol);
  }
  while (colToNode.has(minCol)) {
    res.push(colToNode.get(minCol++));
    minCol++;
  }
  return res;
};
