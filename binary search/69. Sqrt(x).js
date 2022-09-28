/**
 * @param {number} x
 * @return {number}
 */
var mySqrt = function (x) {
  if (x < 2) return x;
  let l = 1,
    r = x >> 1,
    mid;
  while (l <= r) {
    mid = l + ((r - l) >> 1);
    if (mid === x / mid) {
      return mid;
    } else {
      mid > x / mid ? (r = mid - 1) : (l = mid + 1);
    }
  }
  return r;
};
