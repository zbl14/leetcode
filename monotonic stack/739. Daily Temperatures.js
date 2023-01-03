/**
 * @param {number[]} temperatures
 * @return {number[]}
 */
var dailyTemperatures = function (temperatures) {
  const stack = [];
  const n = temperatures.length;
  const res = Array(n).fill(0);
  for (let i = n - 1; i >= 0; i--) {
    while (
      stack.length &&
      temperatures[i] >= temperatures[stack[stack.length - 1]]
    )
      stack.pop();
    res[i] = stack.length ? stack[stack.length - 1] - i : 0;
    stack.push(i);
  }
  return res;
};
