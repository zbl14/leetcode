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
 var minDepth = function(root) {
  let min = 0;
  let start = 0;
  let dfs = (node, deep) => {
      if(node === null) {
          return;
      }
      deep++;
      if(node.left === null && node.right === null) {
          if(min > deep || min === 0) {
              min = deep;
          }
      }
      dfs(node.left, deep);
      dfs(node.right, deep);
  }
  dfs(root, start);
  return min;
};