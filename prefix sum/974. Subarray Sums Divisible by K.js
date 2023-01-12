/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var subarraysDivByK = function (nums, k) {
  const map = new Map(); //记录remainder，frequency
  let prefix = 0;
  let res = 0;
  map.set(0, 1);
  for (const num of nums) {
    // +k是为了避免num为负数的情况，prefix记录的是prefix除以k所的余数
    prefix = (prefix + (num % k) + k) % k;
    res += map.get(prefix) || 0;
    map.set(prefix, (map.get(prefix) || 0) + 1);
  }
  return res;
};
