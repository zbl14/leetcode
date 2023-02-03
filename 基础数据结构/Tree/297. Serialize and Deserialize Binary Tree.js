/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */

/**
 * Encodes a tree to a single string.
 *
 * @param {TreeNode} root
 * @return {string}
 */
var serialize = function (root) {
  if (root === null) return "#";
  return root.val + "," + serialize(root.left) + "," + serialize(root.right);
};

/**
 * Decodes your encoded data to tree.
 *
 * @param {string} data
 * @return {TreeNode}
 */
var deserialize = function (data) {
  const dataArr = data.split(",");
  return helper(dataArr);
};

const helper = (arr) => {
  const str = arr.shift();
  if (str === "#") return null;
  const root = new TreeNode(parseInt(str));
  root.left = helper(arr);
  root.right = helper(arr);
  return root;
};

/**
 * Your functions will be called as such:
 * deserialize(serialize(root));
 */
