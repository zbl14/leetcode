/**
 * @param {string} s
 * @param {number} k
 * @return {number}
 */
// TC = O(26*n)
var longestSubstring = function (s, k) {
  const uniqueLetterMax = new Set(s).size;
  let res = 0;
  for (let i = 1; i <= uniqueLetterMax; i++) {
    const map = new Map();
    let l = 0;
    let validCount = 0;
    for (let r = 0; r < s.length; r++) {
      const cur = s.charAt(r);
      map.set(cur, (map.get(cur) || 0) + 1);
      if (map.get(cur) === k) validCount++; //if the value == k, we know, this unique letter matches the criteria, and we can count the length of this letter
      while (map.size > i) {
        const leftChar = s.charAt(l);
        if (map.get(leftChar) === k) validCount--;
        map.set(leftChar, map.get(leftChar) - 1);
        if (map.get(leftChar) === 0) map.delete(leftChar);
        l++;
      }
      if (map.size === validCount) res = Math.max(res, r - l + 1);
      // 当map里unique letter的数量和符合at least k的letter数量一致，更新string的长度
    }
  }
  return res;
};
