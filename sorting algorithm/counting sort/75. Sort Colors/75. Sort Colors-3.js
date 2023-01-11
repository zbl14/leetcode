/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
//dual pivot
var sortColors = function (nums) {
  let left = 0;
  let right = nums.length - 1;
  for (let i = 0; i <= right; i++) {
    if (nums[i] == 0 && i > left) swap(nums, i--, left++);
    else if (nums[i] == 2 && i < right) swap(nums, i--, right--);
  }
};

const swap = (nums, i, j) => {
  let temp = nums[i];
  nums[i] = nums[j];
  nums[j] = temp;
};
