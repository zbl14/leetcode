/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var subsetsWithDup = function (nums) {
  let res = [];
  let cur = [];
  nums.sort((a, b) => a - b);
  const backtrack = (res, cur, nums, index) => {
    res.push([...cur]);
    for (let i = index; i < nums.length; i++) {
      if (i !== index && nums[i] === nums[i - 1]) continue;
      cur.push(nums[i]);
      backtrack(res, cur, nums, i + 1);
      cur.pop();
    }
  };

  backtrack(res, cur, nums, 0);
  return res;
};
