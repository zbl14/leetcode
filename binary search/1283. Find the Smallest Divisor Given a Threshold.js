/**
 * @param {number[]} nums
 * @param {number} threshold
 * @return {number}
 */
var smallestDivisor = function (nums, threshold) {
  return binary(1, Math.max(...nums));

  function binary(low, high) {
    let mid;
    while (low <= high) {
      mid = low + ((high - low) >> 1);
      isValid(mid) ? (high = mid - 1) : (low = mid + 1);
    }
    return low;
  }

  function isValid(curDivisor) {
    const curSum = nums
      .map((e) => Math.ceil(e / curDivisor))
      .reduce((a, b) => a + b);
    return curSum <= threshold;
  }
};
