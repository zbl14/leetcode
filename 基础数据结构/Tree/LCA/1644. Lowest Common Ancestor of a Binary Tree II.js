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
  let count = 0;
  function lca(root, p, q) {
    if (root === null) return null;
    const left = lca(root.left, p, q);
    const right = lca(root.right, p, q);
    if (root == p || root === q) {
      count++;
      return root;
    }
    return left && right ? root : left || right;
  }

  let res = lca(root, p, q);
  return count === 2 ? res : null;
};
