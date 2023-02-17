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
 * @param {number} targetSum
 * @return {number}
 */
var pathSum = function (root, sum) {
  const map = new Map();
  let count = 0;

  const preoderTraversal = (node, currentSum) => {
    if (node === null) return;
    currentSum += node.val;
    if (currentSum === sum) count++;
    if (map.has(currentSum - sum)) count += map.get(currentSum - sum);
    map.set(currentSum, map.get(currentSum) + 1 || 1);

    preoderTraversal(node.left, currentSum);
    preoderTraversal(node.right, currentSum);

    map.set(currentSum, map.get(currentSum) - 1);
  };

  preoderTraversal(root, 0);
  return count;
};
