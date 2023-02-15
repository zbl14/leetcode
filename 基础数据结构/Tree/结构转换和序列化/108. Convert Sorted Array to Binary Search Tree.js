/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {number[]} nums
 * @return {TreeNode}
 */
var sortedArrayToBST = function (nums) {
  return helper(nums, 0, nums.length - 1);
};

const helper = function (nums, start, end) {
  if (start > end) return null;
  const mid = start + ((end - start) >> 1);
  let node = new TreeNode(nums[mid]);
  node.left = helper(nums, start, mid - 1);
  node.right = helper(nums, mid + 1, end);
  return node;
};
