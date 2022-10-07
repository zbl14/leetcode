/**
 * @param {number[]} nums
 * @return {number}
 */
var rob = function (nums) {
  let n = nums.length;
  if (n === 1) return nums[0];
  let pre2 = 0,
    pre1 = 0,
    cur;
  for (let i = 0; i < n; i++) {
    cur = Math.max(pre1, pre2 + nums[i]);
    pre2 = pre1;
    pre1 = cur;
  }
  return cur;
};
