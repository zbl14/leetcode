/**
 * Definition for isBadVersion()
 *
 * @param {integer} version number
 * @return {boolean} whether the version is bad
 * isBadVersion = function(version) {
 *     ...
 * };
 */

/**
 * @param {function} isBadVersion()
 * @return {function}
 */
var solution = function (isBadVersion) {
  /**
   * @param {integer} n Total versions
   * @return {integer} The first bad version
   */
  return function (n) {
    let l = 1;
    let r = n;
    let mid;
    while (l <= r) {
      mid = l + ((r - l) >> 1);
      isBadVersion(mid) ? (r = mid - 1) : (l = mid + 1);
    }
    return l;
  };
};
