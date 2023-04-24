/**
 * @param {number[]} nums
 * @return {number}
 */
// TC = O(nlogn), SC = O(n), 值得注意的是构造出来的不是最终结果，只是长度为最终结果
// [1, 3, 10, 2], 构造出来的结果为[1, 2, 10]
var lengthOfLIS = function (nums) {
  const stack = [];
  stack.push(nums[0]);
  for (let i = 1; i < nums.length; i++) {
    if (nums[i] > stack[stack.length - 1]) {
      stack.push(nums[i]);
    } else {
      let left = 0;
      let right = stack.length - 1;
      while (left <= right) {
        const mid = left + ((right - left) >> 1);
        stack[mid] >= nums[i] ? (right = mid - 1) : (left = mid + 1);
      }
      stack[left] = nums[i];
    }
  }
  return stack.length;
};
