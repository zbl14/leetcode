/**
 * @param {number[]} numbers
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function (numbers, target) {
  let l = 0,
    r = numbers.length;
  while (l < r) {
    let sum = numbers[l] + numbers[r];
    if (sum == target) break;
    sum < target ? l++ : r--;
  }
  return [l + 1, r + 1];
};

// A = [2, 5, 9, 7, 4, 6, 1, 8]
// - output any pair where the sum is 11.
const printAllTwoSum = (nums, target) => {
  let res = [];
  nums.sort((a, b) => a - b);
  let l = 0,
    r = nums.length;
  while (l < r) {
    let sum = nums[l] + nums[r];
    if (nums[l] + nums[r] === target) res.push([nums[l], nums[r]]);
    sum < target ? l++ : r--;
  }
  return res;
};
