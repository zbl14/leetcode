/**
 * @param {number[]} height
 * @return {number}
 */
// monotonic stack，递减栈，需要3个元素来储水，左墙壁，湖底，右墙壁，stack储存index
// height [2,1,0,1,3]
// stack  [2,1,0]
// stack  [2,(1,0,1)]    湖底高度为0，water += 1
// stack  [2,(1,  1,3)]  湖底高度为1，water += 0
// stack  [(2,1,    ,3)] 湖底高度为1，water += (高度差1) * (长度3)
var trap = function (height) {
  const stack = [];
  let res = 0;
  for (let i = 0; i < height.length; i++) {
    while (stack.length && height[i] > height[stack[stack.length - 1]]) {
      const pre = stack.pop();
      if (!stack.length) break;
      const minHeight = Math.min(height[stack[stack.length - 1]], height[i]);
      res += (minHeight - height[pre]) * (i - stack[stack.length - 1] - 1);
    }
    stack.push(i);
  }
  return res;
};
