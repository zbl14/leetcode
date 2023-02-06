/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {number[]} preorder
 * @param {number[]} inorder
 * @return {TreeNode}
 */
// TC = O(n), SC = O(n)
var buildTree = function (preorder, inorder) {
  const inMap = new Map();
  inorder.forEach((value, index) => inMap.set(value, index));
  let preIdx = 0;

  const dfs = (inStart, inEnd) => {
    if (inStart > inEnd) return null;
    const value = preorder[preIdx++];
    const idx = inMap.get(value);
    const root = new TreeNode(value);
    root.left = dfs(inStart, idx - 1);
    root.right = dfs(idx + 1, inEnd);
    return root;
  };

  return dfs(0, preorder.length - 1);
};
