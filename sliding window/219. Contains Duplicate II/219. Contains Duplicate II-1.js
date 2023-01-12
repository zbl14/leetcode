/**
 * @param {number[]} nums
 * @param {number} k
 * @return {boolean}
 */
// hash map, TC = O(n), SC = O(n)
var containsNearbyDuplicate = function (nums, k) {
  const map = new Map();
  for (let r = 0; r < nums.length; r++) {
    const cur = nums[r];
    if (map.has(cur)) {
      if (r - map.get(cur) <= k) return true;
    }
    map.set(cur, r);
  }
  return false;
};
