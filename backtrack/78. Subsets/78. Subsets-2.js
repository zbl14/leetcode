/**
 * @param {number[]} nums
 * @return {number[][]}
 */

var subsets = function (nums) {
  let ans = [];
  for (let i = 0; i < 1 << nums.length; i++) {
    let sublist = [];
    for (let j = 0; j < nums.length; j++) {
      if (i & (1 << j)) {
        sublist.push(nums[j]);
      }
    }
    ans.push(sublist);
  }
  return ans;
};
