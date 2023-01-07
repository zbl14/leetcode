/**
 * @param {string} s
 * @return {number}
 */
// TC = O(n) SC = O(n)
var lengthOfLongestSubstringTwoDistinct = function (s) {
  const map = new Map();
  let l = 0;
  let res = 0;
  for (let r = 0; r < s.length; r++) {
    const cur = s.charAt(r);
    map.has(cur) ? map.set(cur, map.get(cur) + 1) : map.set(cur, 1);
    while (map.size > 2) {
      const c = s.charAt(l);
      map.set(c, map.get(c) - 1);
      if (map.get(c) === 0) map.delete(c);
      l++;
    }
    res = Math.max(res, r - l + 1);
  }
  return res;
};
