/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var maxResult = function (nums, k) {
  const n = nums.length;
  const dp = Array(n).fill(0);
  dp[0] = nums[0];
  const q = [];
  for (let i = 0; i < n - 1; i++) {
    while (q.length && i - q[0] >= k) q.shift();
    while (q.length && dp[q[q.length - 1]] <= dp[i]) q.pop();
    q.push(i);
    dp[i + 1] = dp[q[0]] + nums[i + 1];
  }
  return dp[n - 1];
};
