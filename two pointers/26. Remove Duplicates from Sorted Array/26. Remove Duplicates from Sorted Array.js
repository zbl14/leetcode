/**
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function (nums) {
  let i = 0,
    j = 0;
  while (j < nums.length) {
    if (i === 0 || nums[j] !== nums[i - 1]) {
      nums[i++] = nums[j++];
    } else {
      j++;
    }
  }
  return i;
};
