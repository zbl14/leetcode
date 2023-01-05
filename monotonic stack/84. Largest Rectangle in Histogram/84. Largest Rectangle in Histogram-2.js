/**
 * @param {number[]} heights
 * @return {number}
 */

// monotonic stack, TC = o(n)
var largestRectangleArea = function (heights) {
  const stack = [];
  let res = 0;
  for (let i = 0; i < heights.length; i++) {
    while (stack.length && heights[i] <= heights[stack[stack.length - 1]]) {
      const preHeight = heights[stack.pop()];
      const width = i - (stack.length ? stack[stack.length - 1] + 1 : 0);
      res = Math.max(res, preHeight * width);
    }
    stack.push(i);
  }
  while (stack.length) {
    const preHeight = heights[stack.pop()];
    const width =
      heights.length - (stack.length ? stack[stack.length - 1] + 1 : 0);
    res = Math.max(res, preHeight * width);
  }
  return res;
};
