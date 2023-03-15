/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
// rotated sorted array
var search = function (nums, target) {
  let l = 0;
  let r = nums.length - 1;
  while (l <= r) {
    mid = l + ((r - l) >> 1);
    if (nums[mid] === target) return mid;
    else if (nums[mid] >= nums[l]) {
      if (nums[l] <= target && target < nums[mid]) r = mid - 1;
      else l = mid + 1;
    } else {
      if (nums[mid] < target && target <= nums[r]) l = mid + 1;
      else r = mid - 1;
    }
  }
  return -1;
};
