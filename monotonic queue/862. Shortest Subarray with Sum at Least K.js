/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var shortestSubarray = function (nums, k) {
  const n = nums.length;
  let res = n + 1;
  let sum = Array(n + 1).fill(0);
  for (let i = 0; i < n; i++) sum[i + 1] = sum[i] + nums[i];
  const q = [];
  for (let i = 0; i < n + 1; i++) {
    while (q.lenth && sum[i] - sum[q[0]] >= k)
      res = Math.min(res, i - q.shift());
    while (q.length && sum[q[q.length - 1]] >= sum[i]) q.pop();
    q.push(i);
  }
  return res <= n ? res : -1;
};
