/**
 * @param {number[]} nums
 * @return {number}
 */
// TC = O(nlogn), SC = O(1)
var findDuplicate = function (nums) {
  nums.sort();
  for (let i = 1; i < nums.length; i++) {
    if (nums[i] === nums[i - 1]) return nums[i];
  }
  return -1;
};
