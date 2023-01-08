/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var constrainedSubsetSum = function (nums, k) {
  const q = [];
  const sum = Array(nums.length).fill(0); // 保存的是到当前i的maxSum
  let res = nums[0];
  for (let i = 0; i < nums.length; i++) {
    sum[i] = nums[i];
    if (q.length) sum[i] += sum[q[0]];
    res = Math.max(res, sum[i]);
    if (q.length && i - q[0] >= k) q.shift();
    while (q.length && sum[q[q.length - 1]] <= sum[i]) q.pop(); //单调递减队列，保持队列第一个数字为当前最大sum
    if (sum[i] > 0) q.push(i);
  }
  return res;
};
