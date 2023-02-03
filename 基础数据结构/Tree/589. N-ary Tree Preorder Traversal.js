/**
 * // Definition for a Node.
 * function Node(val, children) {
 *    this.val = val;
 *    this.children = children;
 * };
 */

/**
 * @param {Node|null} root
 * @return {number[]}
 */
var preorder = function (root) {
  const res = [];
  const stack = [];
  if (root !== null) stack.push(root);
  while (stack.length !== 0) {
    const cur = stack.pop();
    res.push(cur.val);
    for (let i = cur.children.length - 1; i >= 0; i--) {
      stack.push(cur.children[i]);
    }
  }
  return res;
};
