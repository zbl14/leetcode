/**
 * @param {number[]} nums
 * @param {number} target
 * @return {boolean}
 */
var search = function (nums, target) {
  let l = 0,
    r = nums.length - 1,
    mid;
  while (l <= r) {
    mid = l + ((r - l) >> 1);
    if (nums[mid] === target) {
      return true;
    }
    if (nums[l] === nums[mid]) {
      l++;
    } else if (nums[mid] <= nums[r]) {
      // right is sorted in ascending order
      target > nums[mid] && target <= nums[r] ? (l = mid + 1) : (r = mid - 1);
    } else {
      // left is sorted in ascending order
      target >= nums[l] && target < nums[mid] ? (r = mid - 1) : (l = mid + 1);
    }
  }
  return false;
};
