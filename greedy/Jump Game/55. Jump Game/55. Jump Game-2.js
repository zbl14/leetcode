/**
 * @param {number[]} nums
 * @return {boolean}
 */
// DP, TC = O(n^2)
var canJump = function (nums) {
  const memo = Array(nums.length);
  memo[memo.length - 1] = 1;
  return canJumpFromPos(0, nums, memo) === 1;
};

const canJumpFromPos = (pos, nums, memo) => {
  if (memo[pos] !== undefined) return memo[pos];
  let furthest = Math.min(pos + nums[pos], nums.length - 1);
  for (let next = pos + 1; next <= furthest; next++) {
    if (canJumpFromPos(next, nums, memo) === 1) return (memo[pos] = 1);
  }
  return (memo[pos] = -1);
};
