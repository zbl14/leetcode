/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var splitArray = function (nums, k) {
  let sum = nums.reduce((a, b) => a + b);
  let max = Math.max(...nums);
  return binary(sum, max);

  function binary(hight, low) {
    let mid;
    while (low <= hight) {
      mid = low + ((hight - low) >> 1);
      isValid(mid) ? (hight = mid - 1) : (low = mid + 1);
    }
    return low;
  }

  function isValid(subArrSum) {
    let curSum = 0;
    let count = 1;
    for (let i = 0; i < nums.length; i++) {
      curSum += nums[i];
      if (curSum > subArrSum) {
        count++;
        if (count > k) return false;
        curSum = nums[i];
      }
    }
    return true;
  }
};
