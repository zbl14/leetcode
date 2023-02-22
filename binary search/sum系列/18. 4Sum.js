/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[][]}
 */
// TC = O(n^3), SC = O(1)
var fourSum = function (nums, target) {
  const res = [];
  nums.sort((a, b) => a - b);
  for (let i = 0; i < nums.length - 3; i++) {
    if (i !== 0 && nums[i] === nums[i - 1]) continue;
    for (let j = i + 1; j < nums.length - 2; j++) {
      if (j !== i + 1 && nums[j] === nums[j - 1]) continue;
      let start = j + 1;
      let end = nums.length - 1;
      while (start < end) {
        const sum = nums[i] + nums[j] + nums[start] + nums[end];
        if (sum === target) {
          res.push([nums[i], nums[j], nums[start], nums[end]]);
          start++;
          end--;
          while (start < end && nums[start] === nums[start - 1]) start++;
          while (start < end && nums[end] === nums[end + 1]) end--;
        } else {
          sum < target ? start++ : end--;
        }
      }
    }
  }
  return res;
};
