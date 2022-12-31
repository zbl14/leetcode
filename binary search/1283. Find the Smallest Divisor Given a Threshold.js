/**
 * @param {number[]} nums
 * @param {number} threshold
 * @return {number}
 */
var smallestDivisor = function (nums, threshold) {
  return binary(1, 10e6);

  function binary(low, hight) {
    let mid;
    while (low <= hight) {
      mid = low + ((hight - low) >> 1);
      console.log(low, hight);
      isValid(mid) ? (hight = mid - 1) : (low = mid + 1);
    }
    return low;
  }

  function isValid(curDivisor) {
    let curSum = nums
      .map((e) => Math.ceil(e / curDivisor))
      .reduce((a, b) => a + b);
    if (curSum <= threshold) {
      return true;
    }
    return false;
  }
};
