const monotonicQueue = (nums, k) => {
  const n = nums.length;
  const deque = [];
  const res = [];
  for (let i = 0; i < n; i++) {
    while (deque.length && i - deque[0] >= k) deque.shift(); //左出q，保证窗口大小k-1
    while (deque.length && nums[deque[deque.length - 1]] <= nums[i])
      deque.pop(); //右出q，保证递减队列
    deque.push(i); //进q，此时q.length == k
    deque[0]; //使用左边最大值处理结果,根据题目来改变取解的具体位置
  }
  return res;
};
