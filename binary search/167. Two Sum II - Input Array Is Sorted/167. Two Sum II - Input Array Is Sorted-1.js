/**
 * @param {number[]} numbers
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function (numbers, target) {
  let l = 0;
  let r = numbers.length - 1;
  let mid;
  while (l < r) {
    mid = l + ((r - l) >> 1);
    const sum = numbers[l] + numbers[r];
    if (sum === target) {
      return [l + 1, r + 1];
    } else if (sum < target) {
      l = numbers[mid] + numbers[r] < target ? mid : l + 1;
    } else {
      r = numbers[mid] + numbers[l] > target ? mid : r - 1;
    }
  }
};
