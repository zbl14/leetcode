/**
 * @param {number[]} nums
 * @param {number} k
 * @return {boolean}
 */
var checkSubarraySum = function (nums, k) {
  const map = new Map(); // 存储的为remainder, index
  let prefix = 0;
  map.set(0, -1); // 因为为position，所以起始为-1
  for (let i = 0; i < nums.length; i++) {
    prefix += nums[i];
    prefix %= k;
    if (map.has(prefix)) {
      if (i - map.get(prefix) > 1) return true;
    } else {
      map.set(prefix, i);
    }
  }
  return false;
};
