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
  let i = l - 1;
  for (let j = l; j < r; j++) {
    if (nums[j] < pivot) {
      i++;
      swap(nums, i, j);
    }
  }
  swap(nums, i + 1, r);
  return i + 1;
};

const swap = (nums, i, j) => {
  [nums[i], nums[j]] = [nums[j], nums[i]];
};
