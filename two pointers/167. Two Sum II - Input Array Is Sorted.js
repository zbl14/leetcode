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
