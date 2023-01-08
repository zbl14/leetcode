/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number[]}
 */

//暴力解，o(n)*o(k) => o(n^2)
var maxSlidingWindow = function (nums, k) {
  if (nums.length === k) return [Math.max(...nums)];
  const res = [];
  for (let i = 0; i < nums.length - k + 1; i++) {
    const subArr = nums.slice(i, i + k);
    const maxNumInSubArr = Math.max(...subArr);
    res.push(maxNumInSubArr);
  }
  return res;
};
