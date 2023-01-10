/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var subarraysWithKDistinct = function (nums, k) {
  return atMost(nums, k) - atMost(nums, k - 1);
};

const atMost = (nums, k) => {
  const map = new Map();
  let l = 0;
  let res = 0;
  let integerType = 0;
  for (let r = 0; r < nums.length; r++) {
    map.set(nums[r], (map.get(nums[r]) || 0) + 1);
    if (map.get(nums[r]) === 1) integerType++; //发现一个新的数字，validCount++
    while (integerType > k) {
      //数字种类大于k的时候，窗口不valid，shrink窗口
      map.set(nums[l], map.get(nums[l]) - 1);
      if (map.get(nums[l]) === 0) integerType--; //若移动左窗口，刚好减少一种数字，validCount--
      l++;
    }
    res += r - l + 1; // 高斯算法 Gaussian Elimination
  }
  return res;
};
