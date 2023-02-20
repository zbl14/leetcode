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
var verticalTraversal = function (root) {
  const res = [];
  const q = [];
  const colToNode = new Map();
  if (root !== null) q.push([root, 0, 0]);
  while (q.length !== 0) {
    const [cur, col, row] = q.shift();
    if (!colToNode.has(col)) colToNode.set(col, []);
    colToNode.get(col).push([row, cur.val]);
    if (cur.left !== null) q.push([cur.left, col - 1, row + 1]);
    if (cur.right !== null) q.push([cur.right, col + 1, row + 1]);
  }

  const sortedCols = [...colToNode.entries()].sort((a, b) => a[0] - b[0]);
  console.log(sortedCols[0]);
  console.log(sortedCols[1]);
  for (const [col, nodes] of sortedCols) {
    res.push(
      nodes
        .sort((a, b) => (a[0] !== b[0] ? a[0] - b[0] : a[1] - b[1]))
        .map((x) => x[1])
    );
  }
  return res;
};
