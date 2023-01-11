/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
//TC = O(n)
// preSum - preSum = target,所以我们要找的是map里是否存在preSum - target
var subarraySum = function (nums, k) {
  const map = new Map();
  let sum = 0,
    res = 0;
  map.set(0, 1);
  for (let num of nums) {
    sum += num;
    if (map.has(sum - k)) res += map.get(sum - k);
    map.set(sum, (map.get(sum) || 0) + 1);
  }
  return res;
};
