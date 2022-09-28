/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permute = function (nums) {
  let res = [];
  backtracking(nums, 0, res);
  return res;

  function backtracking(nums, level, res) {
    if (level === nums.length - 1) {
      res.push([...nums]);
      return;
    }
    for (let i = level; i < nums.length; i++) {
      swap(nums, i, level);
      backtracking(nums, level + 1, res);
      swap(nums, i, level);
    }
  }

  function swap(arr, a, b) {
    let temp;
    temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
    return arr;
  }
};
