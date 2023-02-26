/**
 * @param {number[]} nums
 * @return {number[]}
 */
// TC = O(n), SC = O(n)
var productExceptSelf = function (nums) {
  const res = Array(nums.length).fill(1);

  for (let i = 1; i < nums.length; i++) {
    res[i] = res[i - 1] * nums[i - 1];
  }
  let tmp = 1;
  for (let i = nums.length - 1; i >= 0; i--) {
    res[i] *= tmp;
    tmp *= nums[i];
  }
  return res;
};

// TC = O(n), SC = O(1)
// var productExceptSelf = function(nums) {
//   const n = nums.length;
//   let temp = 1;
//   for (let i = 0; i < n; i++) {
//       temp *= nums[i];
//       nums[i] = temp;
//   }
//   temp = 1;
//   for (let i = n - 1; i >= 0; i--) {
//       nums[i] = (i > 0 ? nums[i - 1] : 1) * temp;
//       temp *= nums[i];
//   }
//   return nums;
// };
