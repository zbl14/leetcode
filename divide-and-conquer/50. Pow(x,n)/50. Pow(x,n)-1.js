/**
 * @param {number} x
 * @param {number} n
 * @return {number}
 */

//暴力for loop，O(n), 2884 ms
var myPow = function (x, n) {
  let power = 1;
  if (n < 0) return 1 / myPow(x, -n);
  for (let i = 0; i < n; i++) {
    power *= x;
  }
  return power;
};
