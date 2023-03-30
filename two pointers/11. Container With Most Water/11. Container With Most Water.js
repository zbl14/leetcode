/**
 * @param {number[]} height
 * @return {number}
 */
var maxArea = function (height) {
  let i = 0,
    j = height.length - 1,
    res = 0;
  while (i < j) {
    res = Math.max(res, Math.min(height[i], height[j]) * (j - i));
    height[i] <= height[j] ? i++ : j--;
  }
  return res;
};
