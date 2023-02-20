/**
 * @param {number[][]} matrix
 * @param {number} target
 * @return {boolean}
 */
var searchMatrix = function (matrix, target) {
  const m = matrix.length;
  const n = matrix[0].length;
  let start = 0;
  let end = m * n - 1;
  let mid;
  while (start <= end) {
    mid = start + ((end - start) >> 1);
    const num = matrix[Math.floor(mid / n)][mid % n];
    if (num === target) return true;
    else num > target ? (end = mid - 1) : (start = mid + 1);
  }
  return false;
};
