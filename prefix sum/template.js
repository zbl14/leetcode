// 如果是需要做subArray sum, 建议用长度为N+1的模板，因为N的板子会把第一个element漏掉，
// pre[right] - pre[left], 因为left在index为0的时候，已经有数字了总会被减掉

// template 1
let sum = Array(nums.length).fill(0);
sum[0] = nums[0];
for (let i = 1; i < nums.length; i++) {
  sum[i] = sum[i - 1] + nums[i];
}

// template 2
let sum1 = Array(nums.length + 1).fill(0);
for (let i = 0; i < nums.length; i++) sum1[i + 1] = sum1[i] + nums[i];

// 主要四类考题
// 1. 2sum系列
// 2. rangeSum
// 3. sliding window
// 4. monotonic queue
