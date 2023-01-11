/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var sortColors = function (nums) {
  let numsFreq = {},
    maxNum = nums[0],
    sortedIndex = 0;
  for (const num of nums) {
    if (num > maxNum) {
      maxNum = num;
    }
    numsFreq[num] ? numsFreq[num]++ : (numsFreq[num] = 1);
  }
  for (let j = 0; j < 3; j++) {
    while (numsFreq[j] > 0) {
      nums[sortedIndex++] = j;
      numsFreq[j]--;
    }
  }
};
