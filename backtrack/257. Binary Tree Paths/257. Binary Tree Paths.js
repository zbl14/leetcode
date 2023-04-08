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
  if (root === null) return output;
  backtracking(root, output, []);
  return output;
};

const backtracking = (root, paths, currPath) => {
  currPath.push(root.val);
  if (root.left === null && root.right === null) {
    paths.push(currPath.join("->"));
    return;
  }
  if (root.left !== null) {
    backtracking(root.left, paths, currPath);
    currPath.pop();
  }
  if (root.right !== null) {
    backtracking(root.right, paths, currPath);
    currPath.pop();
  }
};
