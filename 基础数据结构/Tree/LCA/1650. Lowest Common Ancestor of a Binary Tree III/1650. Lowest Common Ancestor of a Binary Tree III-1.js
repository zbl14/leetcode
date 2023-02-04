/**
 * // Definition for a Node.
 * function Node(val) {
 *    this.val = val;
 *    this.left = null;
 *    this.right = null;
 *    this.parent = null;
 * };
 */

/**
 * @param {Node} node
 * @return {Node}
 */
// leetcode 160，找两个链表的交汇点的套娃题
var lowestCommonAncestor = function (p, q) {
  let a = p;
  let b = q;
  while (a !== b) {
    a = a === null ? q : a.parent;
    b = b === null ? p : b.parent;
  }
  return a;
};
