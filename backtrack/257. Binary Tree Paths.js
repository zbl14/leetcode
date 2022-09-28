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
 * @return {string[]}
 */
var binaryTreePaths = function (root) {
  const output = [];
  if (!root) return output;
  dfs(root, output, []);
  return output;
};

const dfs = (root, paths, currPath) => {
  currPath.push(root.val);
  if (root.left === null && root.right === null) {
    paths.push(currPath.join("->"));
    return;
  }
  // backtracking
  if (root.left !== null) {
    dfs(root.left, paths, currPath);
    currPath.pop();
  }
  // backtracking
  if (root.right !== null) {
    dfs(root.right, paths, currPath);
    currPath.pop();
  }
};
