/**
 * @param {number[]} nums
 * @return {boolean}
 */
// greedy, TC = O(n), SC = O(1)
var canJump = function (nums) {
  let max = 0;
  for (let i = 0; i < nums.length; i++) {
    if (i <= max) max = Math.max(max, i + nums[i]);
  }
  return max >= nums.length - 1;
};
