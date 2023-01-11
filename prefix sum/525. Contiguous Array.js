/**
 * @param {number[]} nums
 * @return {number}
 */
var findMaxLength = function (nums) {
  let res = 0;
  let sum = 0;
  const map = new Map();
  map.set(0, -1);
  for (let i = 0; i < nums.length; i++) {
    nums[i] = nums[i] === 0 ? -1 : 1;
    sum += nums[i];
    if (map.has(sum)) res = Math.max(res, i - map.get(sum));
    else map.set(sum, i);
  }
  return res;
};
