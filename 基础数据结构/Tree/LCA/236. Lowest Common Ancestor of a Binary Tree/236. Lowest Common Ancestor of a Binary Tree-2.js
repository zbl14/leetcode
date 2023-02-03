/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @param {TreeNode} p
 * @param {TreeNode} q
 * @return {TreeNode}
 */
var lowestCommonAncestor = function (root, p, q) {
  const parent = new Map();
  dfs(null, root, parent);
  const ancestors = new Set();
  while (p !== null) {
    ancestors.add(p);
    p = parent.get(p);
  }
  while (!ancestors.has(q)) q = parent.get(q);
  return q;
};

const dfs = (parentNode, cur, parent) => {
  if (cur === null) return;
  parent.set(cur, parentNode);
  dfs(cur, cur.left, parent);
  dfs(cur, cur.right, parent);
};
