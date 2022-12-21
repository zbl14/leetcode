/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permuteUnique = function (nums) {
  let res = [];
  let used = [];
  nums.sort((a, b) => a - b);
  backtrack([], used);
  return res;

  function backtrack(curList, used) {
    if (curList.length === nums.length) {
      res.push([...curList]);
    } else {
      for (let i = 0; i < nums.length; i++) {
        // when a number has the same value with its previous, we can
        // use this number only if his previous is used
        if (used[i] || (i > 0 && nums[i] === nums[i - 1] && used[i - 1]))
          continue;
        used[i] = true;
        curList.push(nums[i]);
        backtrack(curList, used);
        used[i] = false;
        curList.pop();
      }
    }
  }
};
