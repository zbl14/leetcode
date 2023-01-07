/**
 * @param {string} s
 * @return {number}
 */
// TC = O(n), SC = O(n), map比set快一点，但TC量级不变
var lengthOfLongestSubstring = function (s) {
  const map = new Map();
  let l = 0;
  let res = 0;
  for (let r = 0; r < s.length; r++) {
    const c = s.charAt(r);
    if (map.has(c)) {
      l = Math.max(map.get(c), l);
    }
    map.set(c, r + 1);
    res = Math.max(res, r - l + 1);
  }
  return res;
};
