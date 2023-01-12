/**
 * @param {number[]} nums
 * @param {number} k
 * @return {boolean}
 */
// sliding window, TC = O(n), SC = O(n)
var containsNearbyDuplicate = function (nums, k) {
  const set = new Set();
  for (let i = 0; i < nums.length; i++) {
    if (i > k) set.delete(nums[i - k - 1]);
    if (set.has(nums[i])) {
      return true;
    } else {
      set.add(nums[i]);
    }
  }
  return false;
};
