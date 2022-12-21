/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var subsets = function (nums) {
  let res = new Set();
  let cur = new Set();
  backtrack(res, cur, nums, 0);
  return [...res];
};

const backtrack = (res, cur, nums, start) => {
  res.add([...cur]);
  for (let i = start; i < nums.length; i++) {
    cur.add(nums[i]);
    backtrack(res, cur, nums, i + 1);
    cur.delete(nums[i]);
  }
};
