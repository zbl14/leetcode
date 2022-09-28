/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var searchRange = function (nums, target) {
  let l = 0,
    r = nums.length - 1,
    mid;
  while (l <= r) {
    mid = l + ((r - l) >> 1);
    if (nums[mid] === target) {
      let low = mid,
        high = mid;
      while (low >= 0 && nums[low] === target) {
        low--;
      }
      while (high < nums.length && nums[high] === target) {
        high++;
      }
      return [low + 1, high - 1];
    } else {
      nums[mid] > target ? (r = mid - 1) : (l = mid + 1);
    }
  }
  return [-1, -1];
};
