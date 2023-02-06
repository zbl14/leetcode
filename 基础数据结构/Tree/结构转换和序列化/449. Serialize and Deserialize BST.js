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
  if (root === null) return "";
  let str = root.val.toString();
  if (root.left !== null) str += "," + serialize(root.left);
  if (root.right !== null) str += "," + serialize(root.right);
  return str;
};

/**
 * Decodes your encoded data to tree.
 *
 * @param {string} data
 * @return {TreeNode}
 */
var deserialize = function (data) {
  if (data === "") return null;
  let q = data.split(",").map(Number);
  return dfs(q, -Infinity, Infinity);
};

const dfs = function (q, lower, upper) {
  if (q.length === 0) return null;
  const val = q[0];
  if (val < lower || val > upper) return null;
  q.shift();
  let root = new TreeNode(val);
  root.left = dfs(q, lower, val);
  root.right = dfs(q, val, upper);
  return root;
};
/**
 * Your functions will be called as such:
 * deserialize(serialize(root));
 */
