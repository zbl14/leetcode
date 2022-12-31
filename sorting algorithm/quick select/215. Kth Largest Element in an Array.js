/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var findKthLargest = function (nums, k) {
  let l = 0,
    r = nums.length - 1,
    target = nums.length - k;
  while (l < r) {
    let mid = quickSelection(nums, l, r);
    if (mid == target) {
      return nums[mid];
    }
    mid < target ? (l = mid + 1) : (r = mid - 1);
  }
  return nums[l];
};

const quickSelection = (nums, l, r) => {
  let pivot = nums[r];
  let wall = l;
  for (let i = l; i < r; i++) {
    if (nums[i] < pivot) {
      swap(nums, i, wall);
      wall++;
    }
  }
  swap(nums, wall, r);
  return wall;
};

const swap = (nums, i, j) => {
  [nums[i], nums[j]] = [nums[j], nums[i]];
};
