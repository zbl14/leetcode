/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var shortestSubarray = function (nums, k) {
  const n = nums.length;
  let res = n + 1;
  let prefixSum = Array(n + 1).fill(0);
  for (let i = 0; i < n; i++) prefixSum[i + 1] = prefixSum[i] + nums[i];
  const q = [];
  for (let i = 0; i < n + 1; i++) {
    while (q.length && prefixSum[i] - prefixSum[q[0]] >= k)
      res = Math.min(res, i - q.shift());
    while (q.length && prefixSum[q[q.length - 1]] >= prefixSum[i]) q.pop();
    q.push(i);
  }
  console.log(res);
  return res <= n ? res : -1;
};
