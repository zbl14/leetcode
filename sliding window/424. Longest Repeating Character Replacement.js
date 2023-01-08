/**
 * @param {string} s
 * @param {number} k
 * @return {number}
 */
var characterReplacement = function (s, k) {
  const map = Array(26);
  let l = 0;
  let res = 0;
  let largestCount = 0;
  for (let r = 0; r < s.length; r++) {
    const cur = s.charAt(r);
    map[cur] = (map[cur] || 0) + 1;
    largestCount = Math.max(largestCount, map[cur]);
    while (r - l + 1 - largestCount > k) {
      const lChar = s.charAt(l);
      map[lChar]--;
      l++;
    }
    res = Math.max(res, r - l + 1);
  }
  return res;
};
