/**
 * // Definition for a Node.
 * function Node(val) {
 *    this.val = val;
 *    this.left = null;
 *    this.right = null;
 *    this.parent = null;
 * };
 */

/**
 * @param {Node} node
 * @return {Node}
 */
var lowestCommonAncestor = function (p, q) {
  const visited = new Set();
  while (p !== null) {
    visited.add(p);
    p = p.parent;
  }
  while (q !== null) {
    if (visited.has(q)) {
      return q;
    }
    q = q.parent;
  }
  return null;
};
