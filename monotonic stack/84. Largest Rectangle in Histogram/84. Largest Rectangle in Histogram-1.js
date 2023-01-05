/**
 * @param {number[]} heights
 * @return {number}
 */

// divide-and-conquer, TC = average nlogn, worst n^2
var largestRectangleArea = function (heights) {
  return calculateArea(heights, 0, heights.length - 1);
};

const calculateArea = (heights, start, end) => {
  if (start > end) return 0;
  let minHeightIndex = start;
  for (let i = start; i <= end; i++) {
    if (heights[minHeightIndex] > heights[i]) minHeightIndex = i;
  }
  const curArea = heights[minHeightIndex] * (end - start + 1);
  const left = calculateArea(heights, start, minHeightIndex - 1);
  const right = calculateArea(heights, minHeightIndex + 1, end);
  return Math.max(curArea, Math.max(left, right));
};
