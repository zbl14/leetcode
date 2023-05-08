/**
 * @param {number[]} nums
 * @return {number[]}
 */
// TC = O(n), SC = O(1)
var productExceptSelf = function (nums) {
  const res = Array(nums.length).fill(1);

  for (let i = 1; i < nums.length; i++) {
    res[i] = res[i - 1] * nums[i - 1];
  }
  let tmp = 1;
  for (let i = nums.length - 1; i >= 0; i--) {
    res[i] *= tmp;
    tmp *= nums[i];
  }
  return res;
};
