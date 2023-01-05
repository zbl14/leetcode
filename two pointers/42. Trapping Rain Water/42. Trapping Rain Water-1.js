/**
 * @param {number[]} height
 * @return {number}
 */
// two pointer
var trap = function (height) {
  let leftMax = 0;
  let rightMax = 0;
  let left = 0;
  let right = height.length - 1;
  let res = 0;
  while (left < right) {
    leftMax = Math.max(leftMax, height[left]);
    rightMax = Math.max(rightMax, height[right]);
    if (height[left] < height[right]) {
      res += leftMax - height[left];
      left++;
    } else {
      res += rightMax - height[right];
      right--;
    }
  }
  return res;
};
