/**
 * @param {string} s
 * @return {number}
 */
// TC = O(n^3) SC = O(n)
var lengthOfLongestSubstring = function (s) {
  let ans = 0;
  for (let i = 0; i < s.length; i++) {
    for (let j = i + 1; j <= s.length; j++) {
      if (isValid(s, i, j)) ans = Math.max(ans, j - i);
    }
  }
  return ans;
};

const isValid = (s, start, end) => {
  const set = new Set();
  for (let i = start; i < end; i++) {
    const c = s[i];
    if (set.has(c)) return false;
    set.add(c);
  }
  return true;
};
