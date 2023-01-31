/**
 * @param {number[]} nums
 * @return {number}
 */
var pivotIndex = function (nums) {
  const n = nums.length;
  let preFix = new Array(n).fill(0);
  preFix[0] = nums[0];
  for (let i = 1; i < n; i++) {
    preFix[i] = preFix[i - 1] + nums[i];
  }
  if (preFix[n - 1] === nums[0]) return 0;
  for (let i = 1; i < n; i++) {
    if (preFix[i - 1] === preFix[n - 1] - preFix[i]) return i;
  }
  return -1;
};
