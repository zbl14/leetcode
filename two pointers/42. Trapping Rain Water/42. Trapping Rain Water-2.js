/**
 * @param {number[]} height
 * @return {number}
 */
// DP
var trap = function (height) {
  if (height.length === 0) return 0;
  let res = 0;
  const len = height.length;
  const left = Array(len);
  const right = Array(len);
  left[0] = height[0];
  right[len - 1] = height[len - 1];
  for (let i = 1; i < len; i++) left[i] = Math.max(left[i - 1], height[i]);
  for (let i = len - 2; i >= 0; i--)
    right[i] = Math.max(right[i + 1], height[i]);
  for (let i = 0; i < len; i++) res += Math.min(left[i], right[i]) - height[i];
  return res;
};
