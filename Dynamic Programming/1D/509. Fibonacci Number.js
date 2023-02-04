/**
 * @param {number} n
 * @return {number}
 */
// TC = O(n), SC = O(1)
var fib = function (n) {
  if (n <= 1) return n;
  let pre1 = 1;
  let pre2 = 0;
  let cur = 0;
  for (let i = 2; i <= n; i++) {
    cur = pre1 + pre2;
    pre2 = pre1;
    pre1 = cur;
  }
  return cur;
};
