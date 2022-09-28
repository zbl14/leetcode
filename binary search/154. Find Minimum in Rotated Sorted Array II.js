/**
 * @param {number[]} nums
 * @return {number}
 */
var findMin = function (nums) {
  let l = 0,
    r = nums.length - 1,
    mid;
  while (l <= r) {
    mid = l + ((r - l) >> 1);
    if (nums[r] === nums[mid]) {
      r--;
    } else {
      nums[r] > nums[mid] ? (r = mid) : (l = mid + 1);
    }
  }
  return nums[l];
};
