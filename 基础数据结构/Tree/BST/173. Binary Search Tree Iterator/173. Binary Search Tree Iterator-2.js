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
 */
class BSTIterator {
  constructor(root) {
    this.stack = [];
    this.pushAllLeft(root);
  }
  /**
   * @return {number}
   */
  next() {
    const node = this.stack.pop();
    this.pushAllLeft(node.right);
    return node.val;
  }
  /**
   * @return {boolean}
   */
  hasNext() {
    return this.stack.length !== 0;
  }
  pushAllLeft(root) {
    while (root !== null) {
      this.stack.push(root);
      root = root.left;
    }
  }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * var obj = new BSTIterator(root)
 * var param_1 = obj.next()
 * var param_2 = obj.hasNext()
 */
