/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
// use hashmap, TC = O(n), SC = O(n)
var twoSum = function (nums, target) {
  const numIndices = new Map();
  for (let i = 0; i < nums.length; i++) {
    const num = nums[i];
    if (numIndices.has(target - num)) {
      return [numIndices.get(target - num), i];
    }
    numIndices.set(num, i);
  }
};
