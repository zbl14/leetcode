/**
 * // Definition for a Node.
 * function Node(val, left, right) {
 *      this.val = val;
 *      this.left = left;
 *      this.right = right;
 *  };
 */

/**
 * @param {Node} root
 * @return {Node}
 */
// iterative
var treeToDoublyList = function (root) {
  if (root === null) return null;
  let first = null,
    prev = null;
  let stack = [];
  while (root !== null || stack.length !== 0) {
    while (root !== null) {
      stack.push(root);
      root = root.left;
    }
    root = stack.pop();
    if (first === null) first = root;
    if (prev !== null) {
      prev.right = root;
      root.left = prev;
    }
    prev = root;
    root = root.right;
  }
  first.left = prev;
  prev.right = first;
  return first;
};
