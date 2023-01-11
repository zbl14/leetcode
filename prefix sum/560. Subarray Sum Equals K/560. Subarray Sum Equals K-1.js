/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
//TC = O(n^2)
var subarraySum = function (nums, k) {
  let count = 0;
  let sum = Array(nums.length + 1).fill(0);
  for (let i = 0; i < nums.length; i++) sum[i + 1] = sum[i] + nums[i];
  for (let l = 0; l < nums.length; l++) {
    for (let r = l + 1; r <= nums.length; r++) {
      if (sum[r] - sum[l] === k) count++;
    }
  }
  return count;
};
