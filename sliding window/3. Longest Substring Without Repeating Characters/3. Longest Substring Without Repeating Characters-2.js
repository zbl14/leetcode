/**
 * @param {string} s
 * @return {number}
 */
// TC = O(n), SC = O(n)
var lengthOfLongestSubstring = function (s) {
  const set = new Set();
  let left = 0;
  let res = 0;
  for (let i = 0; i < s.length; i++) {
    const c = s[i];
    while (set.has(c)) {
      set.delete(s[left]);
      left++;
    }
    set.add(c);
    res = Math.max(res, i - left + 1);
  }
  return res;
};
