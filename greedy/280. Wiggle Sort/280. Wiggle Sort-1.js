/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
// TC = O(nlogn), becasue of using build-in sort(), SC = O(n)
var wiggleSort = function (nums) {
  nums.sort((a, b) => a - b);
  const mid = nums.length >> 1;
  let r = nums.length - 1;
  const stack1 = [];
  const stack2 = [];
  while (r >= 0) {
    if (r >= mid) stack2.unshift(nums[r]);
    else stack1.push(nums[r]);
    r--;
  }
  let l = 0;
  while (stack1.length !== 0 && stack2.length !== 0) {
    nums[l] = stack1.pop();
    nums[++l] = stack2.pop();
    l++;
  }
  if (stack2.length !== 0) nums[l] = stack2.pop();
  return nums;
};
