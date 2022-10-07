/**
 * @param {number[]} nums
 * @return {number}
 */
var numberOfArithmeticSlices = function (nums) {
  let n = nums.length;
  if (n < 3) return 0;
  let count = 0,
    diff,
    res = 0;
  for (let i = 1; i < n; i++) {
    let newDiff = nums[i] - nums[i - 1];
    if (newDiff === diff) {
      res += count;
      count++;
    } else {
      diff = newDiff;
      count = 1;
    }
  }
  return res;
};
