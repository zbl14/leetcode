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
 * @param {number[]} postorder
 * @return {TreeNode}
 */
var constructFromPrePost = function (preorder, postorder) {
  const postMap = new Map();
  postorder.forEach((value, index) => postMap.set(value, index));
  let preIdx = 0;

  const dfs = (postStart, postEnd) => {
    if (preIdx >= preorder.length || postStart > postEnd) return null;
    const root = new TreeNode(preorder[preIdx]);
    preIdx++;
    if (preIdx == preorder.length || postStart == postEnd) return root;
    const postIdx = postMap.get(preorder[preIdx]);
    root.left = dfs(postStart, postIdx);
    root.right = dfs(postIdx + 1, postEnd - 1);
    return root;
  };

  return dfs(0, postorder.length - 1);
};
