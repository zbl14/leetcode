/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var subarraysDivByK = function (nums, k) {
  const map = new Map();
  let prefix = 0;
  let res = 0;
  map.set(0, 1);
  for (const num of nums) {
    prefix = (prefix + (num % k) + k) % k;
    res += map.get(prefix) || 0;
    map.set(prefix, (map.get(prefix) || 0) + 1);
  }
  return res;
};
