/**
 * @param {number} x
 * @param {number} n
 * @return {number}
 */

// divide-and-conquer, O(lgn)
var myPow = function (x, n) {
  let res = pow(x, Math.abs(n));
  return n >= 0 ? res : 1 / res;
};

const pow = (x, n) => {
  if (x === 0 || x === 1) return x;
  if (n === 0) return 1;

  let res = pow(x, parseInt(n / 2));
  res = res * res;
  return n % 2 === 0 ? res : res * x;
};
