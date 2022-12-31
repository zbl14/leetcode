// divide-and-conquer, O(nlgn)

/**
 * @param {number[]} nums
 * @return {number}
 */
var majorityElement = function (nums) {
  return divide(nums, 0, nums.length - 1);
};

function divide(nums, left, right) {
  if (left === right) return nums[left]; // only one element
  let mid = left + ((right - left) >> 1);
  const leftRes = divide(nums, left, mid);
  const rightRes = divide(nums, mid + 1, right);
  if (leftRes === rightRes) return leftRes; // 左右最高频element是一样的，则return该element
  const leftCount = conquer(nums, leftRes, left, right);
  const rightCount = conquer(nums, rightRes, left, right);
  return leftCount > rightCount ? leftRes : rightRes;
}

function conquer(nums, target, left, right) {
  let count = 0;
  for (i = left; i <= right; i++) {
    if (nums[i] == target) count++;
  }
  return count;
}
