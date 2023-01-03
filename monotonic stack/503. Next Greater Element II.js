/**
 * @param {number[]} nums
 * @return {number[]}
 */
var nextGreaterElements = function (nums) {
  const stack = [];
  const n = nums.length;
  const res = [];
  for (let i = 2 * n - 1; i >= 0; i--) {
    while (stack.length && nums[i % n] >= stack[stack.length - 1]) stack.pop();
    res[i % n] = stack.length === 0 ? -1 : stack[stack.length - 1];
    stack.push(nums[i % n]);
  }
  return res;
};
