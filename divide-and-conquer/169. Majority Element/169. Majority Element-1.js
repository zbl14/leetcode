/**
 * @param {number[]} nums
 * @return {number}
 */

// O(n),但占用空间
var majorityElement = function (nums) {
  const len = nums.length;
  if (len === 1) return nums[0];
  const numFreq = {};
  for (let i = 0; i < len; i++) {
    if (!numFreq[nums[i]]) {
      numFreq[nums[i]] = 1;
    } else {
      numFreq[nums[i]]++;
      if (numFreq[nums[i]] > len / 2) return nums[i];
    }
  }
};
